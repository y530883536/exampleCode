package annotation;

import java.lang.reflect.Field;

public class MainApp {
    public static void main(String[] args) throws Exception{
        Person person = new Person();
        person.setName("ycf");
        person.setUserId("helloWorld");
        if(isValidated(person)){
            System.out.println("合法的Person");
        }else{
            System.out.println("非法的Person");
        }
    }

    public static boolean isValidated(Person person) throws Exception{
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object fieldObject = field.get(person);
            boolean isFieldNull = fieldObject == null;
            if(field.isAnnotationPresent(NotNull.class)){
                if(isFieldNull){
                    System.out.println(field.getName() + "不能为空");
                    return false;
                }
            }
            if(field.isAnnotationPresent(Length.class)){
                //被Length注解的Field是允许为null的，因为它没有被NotNull注解
                if(!isFieldNull){
                    //Length只适用于判断String的长度
                    if(field.getType() == String.class){
                        String fieldVal = (String)fieldObject;
                        Length length = field.getAnnotation(Length.class);
                        int min = length.min();
                        int max = length.max();
                        if(fieldVal.length() < min || fieldVal.length() > max){
                            String errorMsgTemp = "成员变量%s的长度是%d,不在%d和%d之间";
                            String errorMsg = String.format(errorMsgTemp, field.getName(), fieldVal.length(), min, max);
                            System.out.println(errorMsg);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

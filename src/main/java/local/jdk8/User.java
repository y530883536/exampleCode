package local.jdk8;

public class User {

    public static void sayStatic(String str){
        System.out.println("static " + str);
    }

    public void sayNormal(String str){
        System.out.println("normal " + str);
    }

    public String getWish(String name){
        return "fuck you " + name;
    }

    public boolean isBig(Integer length){
        return length > 15;
    }

    public String getName(){
        return "ycf";
    }
}

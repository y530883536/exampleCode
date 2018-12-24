package basic;

/**
 * @author yechangfeng
 * @date 2018/12/20
 */
public enum SexEnum {
    MALE(Short.valueOf("1")),FEMALE(Short.valueOf("2"));

    private Short value;

    SexEnum(Short value){
        this.value = value;
    }

    public Short getValue() {
        return value;
    }
}

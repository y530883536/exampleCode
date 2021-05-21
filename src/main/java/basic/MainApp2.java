package basic;

public class MainApp2 {
    public static void main(String[] args) {
        String str = "02-12 12:13:50:228: [Tid=8604][Common]fuck you MULTI:1:0:994:222";
        String result = str.substring(str.indexOf("MULTI"));
        System.out.println(result);
    }
}

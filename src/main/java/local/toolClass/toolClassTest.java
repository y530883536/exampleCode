package local.toolClass;

/**
 * Created by YCF on 2017/5/10.
 */
public class toolClassTest {
    public static void main(String[] args) {
        System.out.println(FrequentlyUseStringTool.isChinese(','));
        System.out.println(FrequentlyUseStringTool.isChinese('，'));
        System.out.println(FrequentlyUseStringTool.isChinese('好'));
        System.out.println(FrequentlyUseStringTool.isChinese('c'));

        //使用的是CJK，但是竟然能够剔除掉日文韩文（不过也有可能是idea的编辑器编码问题）
        System.out.println(FrequentlyUseStringTool.isChinese('メ'));
        System.out.println(FrequentlyUseStringTool.isChinese('う'));
        System.out.println(FrequentlyUseStringTool.isChinese('네'));


    }
}

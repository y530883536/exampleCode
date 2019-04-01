package ycf.zero.local.designPattern.decorator;

public class Pudding extends Condiment {

    public Pudding(Eatable eatable){
        //这句话的作用是实例化一个父类的对象，如果父类有无参构造函数的话就不需要显式调用，JVM会帮我们调用
        super(eatable);
    }

    @Override
    public void flavor() {
        System.out.print("布丁");
        //super就是父类的一个实例化对象，子类的构造方法必须实例化一个父类对象
        super.flavor();
    }
}

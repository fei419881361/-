package com.company.zlf;

public class Base {
    public static String staticStr = "base静态变量";

    private String str = "base普通变量";

    static {
        System.out.println(staticStr);
        System.out.println("base静态代码块");
    }

    {
        System.out.println(str);
        System.out.println("base初始化块");
    }
    public Base(){
        System.out.println("base构造方法");
    }

    public static void main(String[] args) {
        new Base();
    }
}

package com.bladespear.demo.compare_int_Integer;

public class Demo {
    public static void main(String[] args) {
        int a = 1;
        Integer b = (Integer) a;
        Integer c = new Integer(1);

        System.out.println(a == b);

        System.out.println(b.equals(a));
        System.out.println(c.equals(a));

        System.out.println(b.equals(c));
        System.out.println(b==c);
    }
}

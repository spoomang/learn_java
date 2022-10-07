package com.professional.certification.practice;

public class ClassInitializationDemo {
    static {
        System.out.println("Class initializer static demo.");
    }
    {
        System.out.println("Class initializer instance demo.");
    }
    public static void main(String[] args) {
        System.out.println("SubClass : STATIC_FINAL "+SubClass.STATIC_FINAL);
        System.out.println("SubClass : STATIC_FINAL_1 "+SubClass.STATIC_FINAL_1);
        SubClass a  = new SubClass();
        SubClass b  = new SubClass();
        SuperClass c = new SuperClass();
        ClassInitializationDemo d = new ClassInitializationDemo();
        System.out.println(a.getClass().getClassLoader());
        System.out.println(b.getClass().getClassLoader());
        System.out.println(c.getClass().getClassLoader());
        System.out.println(d.getClass().getClassLoader());

    }
}

class SuperClass {

    static {
        System.out.println("Super calss static");
    }
    public SuperClass() {
        System.out.println("Superclass: constructor");
    }
}

class SubClass extends SuperClass {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL_1 = (int)(Math.random() * 5);
    static {
        System.out.println("Static initializer");
    }

    public SubClass() {
        System.out.println("Subclass: constructor");
    }
}
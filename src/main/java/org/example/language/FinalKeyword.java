package org.example.language;

public class FinalKeyword {

    //immutable type
    private final String str1 = "asdasd";
    private final String str2;
    //mutable type - can change
    private final StringBuilder strbldr = new StringBuilder();

    FinalKeyword(String str2) {
        this.str2 = str2;
    }

    public void doSmth() {
        int[] args = new int[10];
//        for (final int i = 0; i < args.length; i++) {} // compile error cannot change
    }

    public void setStr2() {
//        str2 = "abc";  //not worked without constructor
    }
}

//public final class A {}  //error, cant be public
final class A {

}

//class B extends A {} // class B can't inherited from A class


class C {
    //can't override
    public final void doSmth() {

    }
}

class D extends C {

//    @Override
//    public void doSmth() {} // can't override method doSmth in class C is final

}


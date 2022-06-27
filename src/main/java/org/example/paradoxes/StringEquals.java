package org.example.paradoxes;

public class StringEquals {

    //Threadsafe
    StringBuffer sb;
    //Not threadsafe
    StringBuilder sbldr;

    public static void equalsStrings() {
        String a = "abc";
        String b = new String("abc");
        String c = b;
        //a not == b because in reference b another object created by new operator
        System.out.println("a.equals(b) " + a.equals(b));
        System.out.println("a == b " + (a == b));
        System.out.println("a.compareTo(b) == 0 " + (a.compareTo(b) == 0));
        System.out.println("a.equals(b) " + c.equals(b));
        System.out.println("a == b " + (c == b));
        System.out.println("a.compareTo(b) == 0 " + (c.compareTo(b) == 0));
    }
}

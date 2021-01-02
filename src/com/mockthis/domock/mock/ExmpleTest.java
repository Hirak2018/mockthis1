package com.mockthis.domock.mock;

public class ExmpleTest {
    @Mockthis(method ="greetings")
    Example example;

    static {
        AhamockHolder.obj="Happy coding!";
    }
    public static void main(String[] args) {
       Example example=new Example();
       System.out.println("Greetings of the day "+example.greetings());
    }
}

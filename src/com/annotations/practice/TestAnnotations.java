package com.annotations.practice;

public class TestAnnotations {
    @DummyAnnotations
    void display(){
        System.out.println("Hi! Engineer.");
    }
    public static void main(String[] args) {
        new TestAnnotations().display();
    }
}

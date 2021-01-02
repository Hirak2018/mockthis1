package com.mockthis.domock.mock;

import org.junit.Assert;
import org.junit.Test;

public class SampleTest {
    @Mockthis(method = "greetings")
    Example example;

    static {
        AhamockHolder.obj = "Hello Coder!";
    }

    @Test
    public void test_my_framework() {
        Example example = new Example();
        System.out.println(example.greetings());
        Assert.assertEquals("Hello Coder!", example.greetings());
    }
}

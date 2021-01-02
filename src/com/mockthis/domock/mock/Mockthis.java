package com.mockthis.domock.mock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.FIELD})
public @interface Mockthis {
    String method();
}

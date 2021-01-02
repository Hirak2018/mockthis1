package com.mockthis.domock.mock;

import jdk.internal.org.objectweb.asm.AnnotationVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

public class CustomAnnotationVisitor extends AnnotationVisitor {
    public CustomAnnotationVisitor(String desc, boolean visible) {
        super(Opcodes.ASM4);
    }

    public void visit(String name, Object value) {
        AhamockHolder.method=(String) value;
    }
}

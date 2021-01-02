package com.mockthis.domock.mock;

import jdk.internal.org.objectweb.asm.AnnotationVisitor;
import jdk.internal.org.objectweb.asm.Attribute;
import jdk.internal.org.objectweb.asm.FieldVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

public class AhamedFieldVisitor extends FieldVisitor {
    String fieldDesc=null;
    boolean isUseful = false;
    public AhamedFieldVisitor(FieldVisitor fv, String name, String desc) {
        super(Opcodes.ASM4,fv);
        fieldDesc=desc;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        if("Lcom/mockthis/domock/mock/Mockthis;".equals(desc)) {
            String normalizedClassName=fieldDesc.substring(1,fieldDesc.lastIndexOf(";"));
            AhamockHolder.classesList.add(normalizedClassName);
            isUseful=true;
        }
        return new CustomAnnotationVisitor(desc,visible);
    }

    @Override
    public void visitAttribute(Attribute attr) {
            System.out.println("Attribute is"+attr);
    }
}

package com.mockthis.domock.mock;

import jdk.internal.org.objectweb.asm.*;

public class CustomClassVisitor extends ClassVisitor {
private String className;

    public CustomClassVisitor(ClassVisitor cv, String name) {
        super(Opcodes.ASM5,cv);
        this.className=name;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,String signature,String[] exceptions){
        MethodVisitor mv=super.visitMethod(access,name,desc,signature,exceptions);
        return new AhamMockMethodVisitor(mv,name,className);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc,
                                   String signature, Object value) {
        FieldVisitor fv=super.visitField(access,name,desc,signature,value);
        return new AhamedFieldVisitor(fv,name,desc);
    }
}

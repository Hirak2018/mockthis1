package com.mockthis.domock.mock;

import jdk.internal.org.objectweb.asm.AnnotationVisitor;
import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import static jdk.internal.org.objectweb.asm.Opcodes.ARETURN;
import static jdk.internal.org.objectweb.asm.Opcodes.GETSTATIC;

public class AhamMockMethodVisitor extends MethodVisitor {
    boolean isAnnotationPresent = false;
    String className;
    String methodName;

    public AhamMockMethodVisitor(MethodVisitor mv, String name, String className) {
        super(Opcodes.ASM4, mv);
        this.className = className;
        this.methodName=name;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        if ("Lcom/mockthis/domock/mock/Mockthis;".equals(desc)) {
            System.out.println(desc);
            isAnnotationPresent = true;
        }
        return super.visitAnnotation(desc, visible);
    }

    @Override
    public void visitCode() {
        if (isAnnotationPresent) {
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLdcInsn("VirtualCode");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 1);
        }
        if(AhamockHolder.classesList.contains(className) && methodName.contains(AhamockHolder.method)){
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitFieldInsn(GETSTATIC, "com/mockthis/domock/mock/AhamockHolder", "obj", "Ljava/lang/Object;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 1);
        }
    }

}

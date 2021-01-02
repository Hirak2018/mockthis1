package com.mockthis.domock.mock;

import jdk.internal.org.objectweb.asm.*;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class SimpleClassTransformer implements ClassFileTransformer{
    @Override
    public byte[] transform(
            ClassLoader l,
            String name,
            Class c,
            ProtectionDomain d,
            byte[] b) {
            ClassReader cr = new ClassReader(b);
             ClassWriter cw = new ClassWriter(cr, Opcodes.ASM4);
             ClassVisitor cv=new CustomClassVisitor(cw,name);
            cr.accept(cv, 0);
            byte[] newClassData = cw.toByteArray();
            return newClassData;
    }
}


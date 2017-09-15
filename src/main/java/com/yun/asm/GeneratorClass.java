package com.yun.asm;

import jdk.internal.org.objectweb.asm.Opcodes;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by caiyunwu on 2017/9/14.
 */
public class GeneratorClass {
    public static void main(String[] args) throws IOException {
        byte[] b=createClass();
        MyClassLoader myClassLoader =new MyClassLoader();

        Class c = myClassLoader.defineClass("GeneratedClass", b);
        for (Field field : c.getDeclaredFields()) {
            System.out.println(field.getName());
        }

    }

    private static byte[] createClass() throws IOException {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,
                "com.yun.asm.Test", null,
                "java/lang/Object", null);

        cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL,
                "field1", "I", null, new Integer(10)).visitEnd();

        cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL,
                "field2", "I", null, new Integer(12)).visitEnd();

        cw.visitMethod(Opcodes.ACC_PUBLIC, "getField1", "()I", null, null).visitEnd();
        cw.visitMethod(Opcodes.ACC_PUBLIC, "setField1", "(I)V", null, null).visitEnd();

        cw.visitEnd();
        File f = new File("D:\\git\\Test\\src\\main\\java\\com\\yun\\asm\\Test.class");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(cw.toByteArray());
        fos.close();
        return cw.toByteArray();
    }

}

package br.com.sample;

public class StackWalkingSample {

    public static void main (final String... args) {
        method1();
    }

    public static void method1 () {
        method2();
    }

    public static void method2 () {
        method3();
    }

    public static void method3 () {
        final StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        //        walker.forEach(System.out::println);

        walker.forEach(element -> {
            System.out.println("===================================================");
            System.out.println("ByteCodeIndex: " + element.getByteCodeIndex());
            System.out.println("ClassName: " + element.getClassName());
            System.out.println("FileName: " + element.getFileName());
            System.out.println("MethodName: " + element.getMethodName());
            System.out.println("DeclaringClass: " + element.getDeclaringClass());
            System.out.println("LineNumber: " + element.getLineNumber());
            System.out.println("NativeMethod: " + element.isNativeMethod());
            System.out.println("===================================================");
        });
    }
}

package br.com.sample;

public class ModuleAPISample {

    public static void main (final String... args) {
        final Module module = ModuleAPISample.class.getModule();
        System.out.println(module.getName());
        System.out.println(module.getDescriptor());
        System.out.println(module.getPackages());
    }
}

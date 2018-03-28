/**
 * Para compilar utilizando modulos:
 * <p>
 * javac -d mods/br.com.sample.java --module-path mods src/module-info.java $(find . -name "*.java")
 * <p>
 * -d => Nome do modulo
 * --module-path => Diretorios de modulos que sera criado
 * src/module-info.java => Arquivo descritor do modulo
 * <p>
 * Para executar utilizando modulos:
 * java --module-path mods -m br.com.sample.java/br.com.sample.OptionalSample
 */
// Por conversao, os nomes dos modulos seguem o mesmo padrao da nomenclatura de pacotes
module br.com.sample.java {

    // requires indica que esse modulo precisa do modulo jdk.incubator.httpclient
    requires jdk.incubator.httpclient;

    // exports indica que esses pacotes estao publicamente visiveis e acessiveis
    exports br.com.sample;

    // exports indica que o pacote esta publicamente visivel e acessivel para o modulo jdk.incubator.httpclient
    exports br.com.sample.model to jdk.incubator.httpclient;
}
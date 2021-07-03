import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        var nombre="Andres";
        var result=saludo(nombre);
        System.out.println(result);

        

        
    }
    public static String saludo(String nombre){
        return "hola "+ nombre;
    }
}

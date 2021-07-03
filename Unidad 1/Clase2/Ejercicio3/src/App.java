public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // Ciclo del for

        /*
            for(int i = 0; i <= 100; i++){
                System.out.println(i);
            }
        
            for(int i = 0; i <= 100; i += 2){
                System.out.println(i);
            }
        */

        // Ciclo del while

        /*
            int variable = 0;
            while (variable < 100) {
                System.out.println("Valor de la variable es -> " + variable);
                variable++;
            }
            do {
                System.out.println("Valor de la variable do while es :" + variable);
                variable++;
            } while (variable < 200);
        */
        

        // Manejo de incrementales y decrementales

        /*
            int a = 5;
            int b = a++;
            System.out.println(" variable a = " + a);
            System.out.println(" variable b = " + b);
            int c = 5;
            int d = ++c;
            System.out.println(" variable c = " + c);
            System.out.println(" variable d = " + d);
            a += b;
            // a = a + b;
            System.out.println(a);
        */

        if ( (5 < 4)|| (5 == 5) ) {
            System.out.println("Correcto!");
        }

        if ((5 == 5) & (5<4)) {
            System.out.println("Correcto!");
        }

        int a = 3 + 3;

        System.out.print("respuesta = " + a);

    }
}
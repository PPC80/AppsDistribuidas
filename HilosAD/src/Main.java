import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //Crear lista con nombres de nodos
        List<String> lista_nodos = new ArrayList<>();
        lista_nodos.add("nodo1");
        lista_nodos.add("nodo2");
        lista_nodos.add("nodo3");

        //Crear lista de hilos
        List<Thread> lista_hilos = new ArrayList<>();

        for(String n: lista_nodos){
            Nodos hilo = new Nodos(n);
            hilo.start();

            try{
                hilo.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        
        System.out.println("Principal");
    }
}
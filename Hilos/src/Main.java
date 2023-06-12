// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //Crear una instancia del hilo
        Hilos hilo1 = new Hilos(1);
        hilo1.start();

        Hilos hilo2 = new Hilos(2);
        hilo2.start();

        try{
            hilo1.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        //Programa principal
        System.out.println("Programa Principal");
    }
}
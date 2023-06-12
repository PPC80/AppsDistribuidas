// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        HilosRun hilo1 = new HilosRun(1);
        (new Thread(hilo1)).start();

        HilosRun hilo2 = new HilosRun(2);
        (new Thread(hilo2)).start();

        try{
            (new Thread(hilo1)).join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        //Programa principal
        System.out.println("Programa Principal");
    }
}
public class Hilos extends Thread {

    private int tipo;

    public Hilos(int tipo) {
        this.tipo = tipo;
    }

    public void run(){
        //Hilo1
        switch (tipo){
            case 1:
            {
                for (int i = 1; i < 30; i++){
                    System.out.println(i);
                }
            }
            break;
            case 2:
            {
                for (char i = 'a'; i < 'z'; i++){
                    System.out.println(i);
                }
            }
            break;
        }
        System.out.println("Este es un hilo");
    }
}

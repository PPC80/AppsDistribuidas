public class Nodos extends Thread{

    private String nombrenodo;

    public Nodos(String nombrenodo) {
        this.nombrenodo = nombrenodo;
    }

    public void run(){
        System.out.println("Iniciando la aplicacion en el nodo: " + nombrenodo);
    }
}

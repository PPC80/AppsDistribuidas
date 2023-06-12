import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gueva
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ServerSocket socket_servidor = new ServerSocket(8080);
            System.out.println("Esperando conexiones ...");

            while (true){
                //Socket cliente, aceptar conexion
                Socket socket_cliente=socket_servidor.accept();
                System.out.println("Cliente conectado: "+socket_cliente.getInetAddress().getHostAddress());

                //Crear Hilo
                HiloCliente hilo1 = new HiloCliente(socket_cliente);
                hilo1.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
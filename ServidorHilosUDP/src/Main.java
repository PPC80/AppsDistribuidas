import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
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
        // TODO code application logic here


        try {
            int puerto=5000;


            //Crear Socket
            DatagramSocket socket = new DatagramSocket(puerto);
            System.out.println("Servidor esperando conexiones");

            while(true){
                byte [] buffer2= new byte [1024]; //recibir

                //crear paquete para recibir datos
                DatagramPacket paquete = new DatagramPacket(buffer2,0, buffer2.length);
                socket.receive(paquete);


                //Iniciar un nuevo hilo para manejar la solicitud
                Thread hilo_cliente = new HiloCliente(socket,paquete);
                hilo_cliente.start();
                hilo_cliente.join();
            }
        } catch (SocketException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

}

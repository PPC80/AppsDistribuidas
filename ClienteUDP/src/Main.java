import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gueva
 */
public class ClienteUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // TODO code application logic here
        int puerto=5000;
        Scanner scanner= new Scanner (System.in);


        try {
            //Crear Socket
            DatagramSocket socket = new DatagramSocket();

            //Enviar
            InetAddress direccion_servidor=InetAddress.getByName("localhost");
            while(true){
                System.out.println("Ingrese un mensaje (o 'salir' para terminar)");
                String mensaje = scanner.nextLine();

                if (mensaje.equalsIgnoreCase("salir")) {
                    break;
                }

                byte [] buffer=mensaje.getBytes(); //enviar

                DatagramPacket paquete_enviar = new DatagramPacket(buffer,0, buffer.length,direccion_servidor,puerto);
                //Enviar paquete
                socket.send(paquete_enviar);

                //crear paquete para recibir datos
                byte [] buffer2= new byte [1024]; //recibir
                DatagramPacket paquete_recibir = new DatagramPacket(buffer2, buffer2.length);
                socket.receive(paquete_recibir);

                String mensaje2= new String(paquete_recibir.getData());

                //Imprimir mensaje
                System.out.println("Mensaje recibido: "+mensaje2);

                //socket.close();

            }



        } catch (SocketException ex) {
            Logger.getLogger(ClientUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
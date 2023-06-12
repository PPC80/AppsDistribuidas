import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gueva
 */
public class HiloCliente extends Thread {

    private DatagramSocket socket;
    private DatagramPacket paquete;
    Scanner scanner = new Scanner(System.in);

    public HiloCliente(DatagramSocket socket, DatagramPacket paquete) {
        this.socket=socket;
        this.paquete=paquete;
    }

    public void run(){
        String mensaje= new String(paquete.getData());

        //Imprimir mensaje
        System.out.println("Mensaje recibido: "+mensaje);

        //crear paquete para enviar datos
        InetAddress direccion_cliente=paquete.getAddress();
        int puerto_cliente = paquete.getPort();


        System.out.println("Ingrese la Respuesta del servidor para el cliente "+paquete.getAddress());
        String respuesta = scanner.nextLine();
        byte[] buffer= respuesta.getBytes();

        DatagramPacket paquete_respuesta = new DatagramPacket(buffer, buffer.length,direccion_cliente,puerto_cliente);
        try {
            //Enviar paquete
            socket.send(paquete_respuesta);
        } catch (IOException ex) {
            Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}



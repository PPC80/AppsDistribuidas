import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int puerto = 5000;
        byte [] buffer2 = new byte[1024]; //recibir



        try {
            //Crear Socket
            DatagramSocket socket = new DatagramSocket(puerto);

            while(true){
                byte [] buffer; //enviar
                //Crear paquete
                DatagramPacket paquete = new DatagramPacket(buffer2, buffer2.length);

                socket.receive(paquete);

                String mensaje = new String(paquete.getData());

                //Imprimir mensaje
                System.out.println(mensaje);

                //Crear paquete para enviar datos
                InetAddress direccion_cliente = paquete.getAddress();
                int puerto_cliente = paquete.getPort();

                System.out.println("Ingrese su mensaje: ");
                Scanner sc = new Scanner(System.in);
                String respuesta = sc.nextLine();
                buffer = respuesta.getBytes();

                DatagramPacket paquete_respuesta = new DatagramPacket(buffer, buffer.length, direccion_cliente, puerto_cliente);

                //Enviar paquete
                socket.send(paquete_respuesta);
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
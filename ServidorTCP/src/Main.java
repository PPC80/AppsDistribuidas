import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            //Crear socket
            ServerSocket socket_servidor = new ServerSocket(8080);
            System.out.println("Esperando conexiones ...");

            while (true){
                //Socket cliente, aceptar conexion
                Socket socket_cliente=socket_servidor.accept();
                System.out.println("Cliente conectado: "+socket_cliente.getInetAddress().getHostAddress());

                //Buffer para Recibir y enviar datos al cliente
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
                PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(),true);

                //Buffer teclado
                BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

                //Datos recibidos
                String datos_recibidos = entrada.readLine();
                System.out.println(datos_recibidos);

                //Enviar datos
                System.out.println("Ingrese su mensaje: ");
                String datos_enviar = teclado.readLine();
                salida.println(datos_enviar);

                //Cerrar conexion
                socket_cliente.close();
                System.out.println("Cliente desconectado");
            }

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
            Socket socket_cliente= new Socket("172.31.116.80",8080);
            System.out.println("Cliente conectado al servidor ");

            //Buffer para Recibir y enviar datos al cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(),true);
            //Buffer teclado
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                // Datos recibidos
                String datos_recibidos = entrada.readLine();
                System.out.println(datos_recibidos);

                if (datos_recibidos.startsWith("Juego termino")) {
                    String respuesta;
                    respuesta = entrada.readLine();
                    System.out.println(respuesta);
                    socket_cliente.close();
                    break;
                }

                // Enviar datos
                System.out.println("Ingrese su respuesta: ");
                String datos_enviar = teclado.readLine();
                salida.println(datos_enviar);

                if (datos_enviar.equals("salir")) {
                    socket_cliente.close();
                    break;
                }

                String siguiente_pregunta = entrada.readLine();
                System.out.println(siguiente_pregunta);
            }

            System.out.println("Cliente desconectado");

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
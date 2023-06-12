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
            Socket socket_cliente= new Socket("localhost",8080);
            System.out.println("Cliente conectado al servidor ");

            //Buffer para Recibir y enviar datos al cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(),true);
            //Buffer teclado
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                //Enviar datos
                System.out.println("Ingrese su mensaje: ");
                String datos_enviar =  teclado.readLine();
                salida.println(datos_enviar);

                if(datos_enviar.equals("salir")){
                    socket_cliente.close();
                    break;
                }
                //Datos recibidos
                String datos_recibidos = entrada.readLine();
                System.out.println(datos_recibidos);

                if(datos_recibidos.equals("salir")){
                    socket_cliente.close();
                    break;
                }

            }
            System.out.println("Cliente desconectado");

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

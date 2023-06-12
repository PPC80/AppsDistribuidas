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
public class HiloCliente extends Thread{
    private Socket socket_cliente;

    public HiloCliente(Socket socket_cliente) {
        this.socket_cliente = socket_cliente;
    }

    public void run(){

        try {
            //Buffer para Recibir y enviar datos al cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(),true);
            //Buffer teclado
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            while(true){
                //Datos recibidos
                String datos_recibidos = entrada.readLine();
                System.out.println(datos_recibidos);

                if(datos_recibidos.equals("salir")){
                    socket_cliente.close();
                    break;
                }
                //Enviar datos
                System.out.println("Ingrese su mensaje: ");
                String datos_enviar = teclado.readLine();
                salida.println(datos_enviar);

                if(datos_enviar.equals("salir")){
                    socket_cliente.close();
                    break;
                }
            }
            System.out.println("Cliente desconectado ");
        } catch (IOException ex) {
            Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

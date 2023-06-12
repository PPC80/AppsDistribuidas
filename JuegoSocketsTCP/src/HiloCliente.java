import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gueva
 */
public class HiloCliente extends Thread{
    private Socket socket_cliente;
    private LinkedHashMap<String, Pregunta> preguntas = new LinkedHashMap<>();

    public HiloCliente(Socket socket_cliente) {
        this.socket_cliente = socket_cliente;
    }

    public void run(){

        try {
            //Buffer para Recibir y enviar datos al cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(),true);

            preguntas.put("¿Cuál es la capital de Perú?", new Pregunta("Lima", 50));
            preguntas.put("¿Cuál es la montaña más alta del mundo?", new Pregunta("Everest", 100));
            preguntas.put("¿Cuál es el río más largo del mundo?", new Pregunta("Amazonas", 100));
            preguntas.put("¿Cuál es la capital de Ecuador?", new Pregunta("Quito", 50));
            preguntas.put("¿Cuál es la moneda oficial de España?", new Pregunta("Euro", 100));

            int puntaje = 0;

            for (Map.Entry<String, Pregunta> entry : preguntas.entrySet()) {
                String preguntaTexto = entry.getKey();
                Pregunta pregunta = entry.getValue();

                salida.println(preguntaTexto);

                // Recibe respuesta
                String respuestaRecibida = entrada.readLine();
                if (!respuestaRecibida.equals(pregunta.getRespuesta())) {
                    salida.println("Respuesta incorrecta :(");
                } else {
                    salida.println("Respuesta correcta!");
                    puntaje += pregunta.getPuntaje();
                }
            }
            salida.println("Juego termino \nTus puntos son: " + puntaje);

            System.out.println("Cliente desconectado ");
        } catch (IOException ex) {
            Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

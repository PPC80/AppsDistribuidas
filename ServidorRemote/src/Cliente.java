import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args){

        try {
            //Obtener el registro RMI en el puerto especificado
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);

            String serviceName = "rmi://localhost:1099";

            //Crear una instancia de la implementacion de la interaz
            MensajeInterface objetoremoto = (MensajeInterface) registro.lookup("ServidorMensaje");

            System.out.println("Ingrese su nombre: ");
            Scanner sc = new Scanner(System.in);
            String respuesta = objetoremoto.saludar(sc.nextLine());
            System.out.println(respuesta);

        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }
}

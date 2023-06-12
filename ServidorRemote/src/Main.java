import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {

        try {
            //Crear una instancia de la implementacion remota (Interfaz)
            MensajeInterface objetoRemoto = new RMI();

            //Crear  y obtener el registro RMI
            Registry registro = LocateRegistry.createRegistry(1099);

            //Vincular la implementacion remota al registro RMI con un nombre
            registro.rebind("ServidorMensaje", objetoRemoto);

            System.out.println("Servidor remoto iniciado...");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
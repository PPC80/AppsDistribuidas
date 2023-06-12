import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args){

        try {
            //Obtener el registro RMI en el puerto especificado
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);

            //Crear una instancia de la implementacion de la interaz
            MensajeInterface objetoremoto = (MensajeInterface) registro.lookup("ServidorMensaje");

            String respuesta = objetoremoto.saludar();
            System.out.println(respuesta);

            System.out.println("La suma es: " + objetoremoto.sumar(5, 10));
            System.out.println("La resta es: " + objetoremoto.restar(20, 9));
            System.out.println("La multiplicacion es: " + objetoremoto.multiplicar(3, 6));

        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }
}

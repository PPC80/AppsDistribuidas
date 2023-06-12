import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MensajeInterface extends Remote {
    String saludar() throws RemoteException;
    double sumar(double a, double b) throws RemoteException;
    double restar(double a, double b) throws RemoteException;
    double multiplicar(double a, double b) throws RemoteException;
}

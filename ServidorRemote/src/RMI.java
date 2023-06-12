import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMI extends UnicastRemoteObject implements MensajeInterface {

    protected RMI() throws RemoteException {
        super();
    }

    @Override
    public String saludar() throws RemoteException {
        return "Hola desde el servidor remoto";
    }

    @Override
    public double sumar(double a, double b) throws RemoteException {
        return (a + b);
    }

    @Override
    public double restar(double a, double b) throws RemoteException {
        return (a - b);
    }

    @Override
    public double multiplicar(double a, double b) throws RemoteException {
        return (a * b);
    }
}

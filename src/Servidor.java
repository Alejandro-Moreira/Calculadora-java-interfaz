import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Calculadora calculadora = new implementacion();
            Naming.rebind("Calculadora", calculadora);
            System.out.println("Calculadora en ejecución");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}

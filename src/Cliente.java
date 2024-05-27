import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.getRegistry("172.29.132.200", 1099);
            Calculadora calculadora = (Calculadora) registro.lookup("Calculadora");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el primer número:");
            double num1 = scanner.nextDouble();

            System.out.println("Ingrese el segundo número:");
            double num2 = scanner.nextDouble();

            System.out.println("Seleccione la operación :");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            int opcion = scanner.nextInt();

            double resultado = 0;
            switch (opcion) {
                case 1:
                    resultado = calculadora.sumar(num1, num2);
                    break;
                case 2:
                    resultado = calculadora.restar(num1, num2);
                    break;
                case 3:
                    resultado = calculadora.multiplicar(num1, num2);
                    break;
                case 4:
                    resultado = calculadora.dividir(num1, num2);
                    break;
                default:
                    System.out.println("Opción no válida");
                    System.exit(1);
            }

            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}

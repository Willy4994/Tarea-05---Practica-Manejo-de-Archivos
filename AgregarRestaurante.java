import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AgregarRestaurante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String archivo = "Restaurants.csv";

        System.out.print("Nombre del restaurante: ");
        String nombre = sc.nextLine();
        System.out.print("Direccion: ");
        String direccion = sc.nextLine();
        System.out.print("Codigo postal: ");
        String codigoPostal = sc.nextLine();
        System.out.print("Telefono: ");
        String telefono = sc.nextLine();

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            pw.println(nombre + "," + direccion + "," + codigoPostal + "," + telefono);
            System.out.println("Restaurante agregado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
        sc.close();
    }
}

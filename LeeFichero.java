import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeeFichero {
    public static void main(String[] args) {
        File archivo = new File("archivo.txt");

        try (BufferedReader buffer = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

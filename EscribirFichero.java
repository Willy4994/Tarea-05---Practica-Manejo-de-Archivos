import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class EscribirFichero {
    public static void main(String[] args) {
        File fichero = new File("archivo.txt");

        try (PrintWriter pw = new PrintWriter(new FileWriter(fichero))) {
            for (int i = 1; i <= 10; i++) {
                pw.println("Linea " + i);
            }
            System.out.println("Archivo escrito correctamente.");
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}

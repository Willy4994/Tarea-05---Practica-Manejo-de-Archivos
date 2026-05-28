import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopiarSinCodigo6 {
    public static void main(String[] args) {
        String origen = "Restaurants.csv";
        String destino = "Restaurants2.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(origen));
             PrintWriter pw = new PrintWriter(new FileWriter(destino))) {

            String linea;
            boolean primera = true;
            while ((linea = br.readLine()) != null) {
                if (primera) {
                    pw.println(linea);
                    primera = false;
                    continue;
                }

                String[] datos = linea.split(",");
                if (datos.length >= 3 && !datos[2].trim().startsWith("6")) {
                    pw.println(linea);
                }
            }
            System.out.println("Copia creada correctamente: " + destino);
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}

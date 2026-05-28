import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RestaurantesCodigo6 {
    public static void main(String[] args) {
        String archivo = "Restaurants.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean primera = true;

            while ((linea = br.readLine()) != null) {
                if (primera) {
                    System.out.println(linea);
                    primera = false;
                    continue;
                }

                String[] datos = linea.split(",");
                if (datos.length >= 3 && datos[2].trim().startsWith("6")) {
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

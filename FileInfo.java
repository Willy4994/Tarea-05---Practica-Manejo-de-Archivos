import java.io.File;
import java.util.Scanner;

public class FileInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la ruta del fichero o directorio: ");
        String ruta = sc.nextLine();

        File archivo = new File(ruta);

        if (archivo.exists()) {
            System.out.println("El fichero existe.");
            if (archivo.isDirectory()) {
                System.out.println("Es un directorio.");
            } else if (archivo.isFile()) {
                System.out.println("Es un fichero.");
                System.out.println("Nombre: " + archivo.getName());
                System.out.println("Tamano: " + archivo.length() + " bytes");
                System.out.println("Permiso de lectura: " + archivo.canRead());
                System.out.println("Permiso de escritura: " + archivo.canWrite());
            }
        } else {
            System.out.println("El fichero no existe.");
        }
        sc.close();
    }
}

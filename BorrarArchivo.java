import java.io.File;
import java.util.Scanner;

public class BorrarArchivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la ruta del archivo a borrar: ");
        String ruta = sc.nextLine();

        File archivo = new File(ruta);
        if (!archivo.exists()) {
            System.out.println("El archivo no existe.");
        } else if (archivo.isDirectory()) {
            System.out.println("La ruta corresponde a un directorio, no a un archivo.");
        } else if (archivo.delete()) {
            System.out.println("Archivo borrado correctamente.");
        } else {
            System.out.println("No se pudo borrar el archivo.");
        }
        sc.close();
    }
}

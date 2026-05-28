import java.io.*;
import java.util.*;

public class LibreriaArchivos {
    private static final String ARCHIVO_BINARIO = "libreria.dat";
    private static final Scanner sc = new Scanner(System.in);
    private static ArrayList<Registro> registros = new ArrayList<>();

    static class Registro implements Serializable {
        private static final long serialVersionUID = 1L;
        int numero;
        String tipo;
        String titulo;
        String detalle;
        String genero;

        Registro(int numero, String tipo, String titulo, String detalle, String genero) {
            this.numero = numero;
            this.tipo = tipo;
            this.titulo = titulo;
            this.detalle = detalle;
            this.genero = genero;
        }

        public String toString() {
            return numero + " | " + tipo + " | " + titulo + " | " + detalle + " | " + genero;
        }
    }

    public static void main(String[] args) {
        cargarDatos();
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione su opcion: ");
            switch (opcion) {
                case 1: registrar(); break;
                case 2: borrar(); break;
                case 3: corregir(); break;
                case 4: listadoGeneral(); break;
                case 5: listadoOrdenadoPorTitulo(); break;
                case 6: buscarPorTitulo(); break;
                case 7: buscarPorNumero(); break;
                case 8: guardarDatos(); System.out.println("Gracias por usar la libreria."); break;
                default: System.out.println("Opcion no valida.");
            }
        } while (opcion != 8);
    }

    private static void mostrarMenu() {
        System.out.println("\n========== LIBRERIA DE ARCHIVOS ==========");
        System.out.println("1. Registrar datos o informacion");
        System.out.println("2. Borrar datos o informacion");
        System.out.println("3. Corregir datos o informacion");
        System.out.println("4. Listado general de acuerdo al numero");
        System.out.println("5. Listado ordenado por titulo");
        System.out.println("6. Buscar por titulo");
        System.out.println("7. Buscar por numero");
        System.out.println("8. Salir");
    }

    private static void registrar() {
        System.out.println("\nTipos: 1.Pelicula  2.Musica  3.PDF  4.Fotografia  5.Programa");
        int tipoNum = leerEntero("Seleccione el contenido del archivo: ");
        String tipo = obtenerTipo(tipoNum);
        if (tipo.equals("Desconocido")) {
            System.out.println("Tipo no valido.");
            return;
        }

        System.out.print("Ingrese el titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Ingrese detalles: ");
        String detalle = sc.nextLine();
        System.out.print("Ingrese genero o tipo: ");
        String genero = sc.nextLine();

        int numero = registros.size() + 1;
        registros.add(new Registro(numero, tipo, titulo, detalle, genero));
        guardarDatos();
        System.out.println("Registro agregado correctamente.");
    }

    private static void borrar() {
        int numero = leerEntero("Ingrese el numero del registro a borrar: ");
        Registro encontrado = buscarNumero(numero);
        if (encontrado == null) {
            System.out.println("No existe ese registro.");
            return;
        }
        registros.remove(encontrado);
        renumerar();
        guardarDatos();
        System.out.println("Registro borrado correctamente.");
    }

    private static void corregir() {
        int numero = leerEntero("Ingrese el numero del registro a corregir: ");
        Registro r = buscarNumero(numero);
        if (r == null) {
            System.out.println("No existe ese registro.");
            return;
        }
        System.out.print("Nuevo titulo: ");
        r.titulo = sc.nextLine();
        System.out.print("Nuevo detalle: ");
        r.detalle = sc.nextLine();
        System.out.print("Nuevo genero o tipo: ");
        r.genero = sc.nextLine();
        guardarDatos();
        System.out.println("Registro corregido correctamente.");
    }

    private static void listadoGeneral() {
        if (registros.isEmpty()) {
            System.out.println("No hay registros.");
            return;
        }
        for (Registro r : registros) {
            System.out.println(r);
        }
    }

    private static void listadoOrdenadoPorTitulo() {
        ArrayList<Registro> copia = new ArrayList<>(registros);
        copia.sort(Comparator.comparing(r -> r.titulo.toLowerCase()));
        for (Registro r : copia) {
            System.out.println(r);
        }
    }

    private static void buscarPorTitulo() {
        System.out.print("Ingrese el titulo o parte del titulo: ");
        String texto = sc.nextLine().toLowerCase();
        boolean encontrado = false;
        for (Registro r : registros) {
            if (r.titulo.toLowerCase().contains(texto)) {
                System.out.println(r);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No se encontraron resultados.");
    }

    private static void buscarPorNumero() {
        int numero = leerEntero("Ingrese el numero: ");
        Registro r = buscarNumero(numero);
        if (r == null) System.out.println("No existe ese registro.");
        else System.out.println(r);
    }

    private static Registro buscarNumero(int numero) {
        for (Registro r : registros) {
            if (r.numero == numero) return r;
        }
        return null;
    }

    private static void renumerar() {
        for (int i = 0; i < registros.size(); i++) {
            registros.get(i).numero = i + 1;
        }
    }

    private static String obtenerTipo(int tipo) {
        switch (tipo) {
            case 1: return "Pelicula";
            case 2: return "Musica";
            case 3: return "PDF";
            case 4: return "Fotografia";
            case 5: return "Programa";
            default: return "Desconocido";
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void cargarDatos() {
        File archivo = new File(ARCHIVO_BINARIO);
        if (!archivo.exists()) return;
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
            registros = (ArrayList<Registro>) entrada.readObject();
        } catch (Exception e) {
            System.out.println("No se pudieron cargar los datos: " + e.getMessage());
        }
    }

    private static void guardarDatos() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ARCHIVO_BINARIO))) {
            salida.writeObject(registros);
        } catch (IOException e) {
            System.out.println("No se pudieron guardar los datos: " + e.getMessage());
        }
    }
}

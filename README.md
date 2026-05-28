# Modulo 07 - Manejo de Archivos en Java

Este repositorio contiene los programas solicitados para el modulo 07 visto en clase.

## Archivos incluidos

- `FileInfo.java`: verifica si una ruta existe, si es archivo o directorio y muestra datos del archivo.
- `LeeFichero.java`: ejemplo de lectura de archivo de texto.
- `EscribirFichero.java`: ejemplo de escritura de archivo de texto.
- `RestaurantesCodigo6.java`: muestra restaurantes cuyo codigo postal empieza con 6.
- `AgregarRestaurante.java`: agrega un restaurante al archivo CSV.
- `CopiarSinCodigo6.java`: crea `Restaurants2.csv` sin restaurantes cuyo codigo postal empieza con 6.
- `BorrarArchivo.java`: borra un archivo indicado por el usuario.
- `LibreriaArchivos.java`: programa de libreria con manejo de archivo binario y excepciones.
- `Restaurants.csv`: archivo CSV de ejemplo.

## Como compilar

```bash
javac src/*.java
```

## Como ejecutar

Ejemplo:

```bash
java -cp src FileInfo
java -cp src EscribirFichero
java -cp src LeeFichero
java -cp src RestaurantesCodigo6
java -cp src AgregarRestaurante
java -cp src CopiarSinCodigo6
java -cp src BorrarArchivo
java -cp src LibreriaArchivos
```

## Entrega en GitHub

1. Crear un repositorio nuevo en GitHub.
2. Subir todos los archivos de este proyecto.
3. En GitHub, entrar a `Settings > Collaborators`.
4. Invitar al usuario `mlpcumg`.
5. Entregar la URL del repositorio.

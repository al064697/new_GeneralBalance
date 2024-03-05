package src.resources;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TextFile {
    File file;

    public TextFile(String pathname) {
        try {
            file = new File(pathname);
/*            if (file.createNewFile())  System.out.println("Archivo creado: " + file.getName());
            else System.out.println("El archivo ya existe, por lo tanto se sobreescribirá en este");*/
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public void updateTextFile(String param) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(param  + "\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    void deleteTextFile() {
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static void menuOpciones() {
        System.out.println("1. Crear archivo de texto");
        System.out.println("2. Escribir en archivo de texto");
        System.out.println("3. Leer archivo de texto");
        System.out.println("4. Borrar archivo de texto");
        System.out.println("5. Salir");
    }
}
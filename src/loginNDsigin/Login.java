package src.loginNDsigin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Login {
    public void login() {
        Scanner src = new Scanner(System.in);
        System.out.println("Ingresa tu usuario: ");
        String username = src.next();
        System.out.println("Ingresa tu contraseña: ");
        String password = src.next();
    }

    public void readTextFile() {
        try {
            FileReader reader = new FileReader("users.txt");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

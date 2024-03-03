package src.loginNDsigin;

import java.util.ArrayList;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LogIn {
    private ArrayList<User> users;
    private Scanner scanner;

    public LogIn(ArrayList<User> users) {
        this.users = users;
        this.scanner = new Scanner(System.in);
    }

    public void login() {
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();

        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        password = encryptPassword(password); // Encrypt the entered password

        User user = findUser(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Inicio de sesión exitoso!");
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }
    }

    private User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
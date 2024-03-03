package src;

import src.Accounts.CapitalContable;

public class GeneralBalance {
    String readEntry(String message) {
        System.out.print(message);
        return new java.util.Scanner(System.in).nextLine();
    }

    String header() {
        String nameEntity = readEntry("Nombre de la entidad: ");
        String initialDate = readEntry("Fecha inicial: ");
        String finalDate = readEntry("Fecha final: ");

        return nameEntity + "\nBalance general del " + initialDate + " al " + finalDate + "\n";
    }

    String footer() {
        String CEO = readEntry("Autorizado por: ");
        String author = readEntry("Elaborado por: ");

        return "Autorizado por: " + CEO + "\t" + "Elaborado por: " + author;
    }

    public static void main(String[] args) {
        try {
            TextFile textFile = new TextFile("balanceGeneral.txt");
            textFile.updateTextFile(new GeneralBalance().header());
            String totalCapital = new CapitalContable().total();
            String footer = new GeneralBalance().footer();

        } catch (Exception e) {
            System.out.println("Se produjo un error: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

}

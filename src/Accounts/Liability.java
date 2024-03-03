package src.Accounts;

import src.Components.Accounts;
import src.resources.TextFile;

import java.util.ArrayList;

public class Liability extends Accounts {

    double floating() {
        ArrayList<Accounts> currentLiability = createAccounts(
                "Proveedores",
                "Documentos por pagar",
                "Acreedores diversos",
                "Anticipo de clientes",
                "Gastos pendientes de pago, gastos por pagar o gastos acumulados",
                "Impuestos pendientes de pago, impuestos por pagar o impuestos acumulados"
        );
        return account(currentLiability, "Pasivo", "Flotante");
    }

    double fixed() {
        ArrayList<Accounts> fixedLiability = createAccounts(
                "Hipotecas por pagar o acreedores hipotecarios",
                "Documentos por pagar a largo plazo",
                "Cuentas por pagar a largo plazo"
        );
        return account(fixedLiability, "Pasivo", "Fijo");
    }

    double deferredCredits() {
        ArrayList<Accounts> deferredLiability = createAccounts(
                "Rentas cobradas por anticipado",
                "Intereses cobrados por anticipado"
        );
        return account(deferredLiability, "Pasivo", "Diferido");
    }

    public double totalLiability() {
        double total = floating() + fixed() + deferredCredits();
        System.out.println("Total de pasivo: $" + total);
        new TextFile("balanceGeneral.txt").updateTextFile("Total de pasivo: $" + total );

        return total;
    }

}
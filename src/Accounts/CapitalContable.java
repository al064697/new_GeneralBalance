package src.Accounts;

import src.resources.TextFile;

public class CapitalContable {
    public String total() {
        double total = new Assed().totalAsset() - new Liability().totalLiability();
        String capital =  "Total capital: $" + total + '\n';
        System.out.println(capital);

        new TextFile("balanceGeneral.txt").updateTextFile("Total capital: $" + total);

        return capital;
    }
}
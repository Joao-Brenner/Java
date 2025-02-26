package controle;

import javax.swing.JOptionPane;

public class BonusSalario {

    public static void main(String[] args) {

        double salariobase, bonus, salariocombonus = 0;
        int desempenho, cont, entre = 0;

        for (cont = 0; cont < 5; cont++) {
            salariobase = Double.valueOf(JOptionPane.showInputDialog("Qual o salário base do funcionário?\n"));
            desempenho = Integer.valueOf(JOptionPane.showInputDialog("De 1 a 10, qual a pontuação referente ao desempenho do funcionário?\n"));

            if (desempenho >= 1 && desempenho < 5) {
                JOptionPane.showMessageDialog(null, "Como a pontuação pelo desempenho foi abaixo de 5, infelizmente, este funcionário não tem direito a bônus nenhum.\n");
                JOptionPane.showMessageDialog(null, "O salário final deste funcionário é: R$" + (salariocombonus = salariobase + 0) + "\n");

            } else if (desempenho >= 5 && desempenho <= 7) {
                JOptionPane.showMessageDialog(null, "Como a pontuação pelo desempenho ficou entre 5 e 7, este funcionário tem direito a um bônus equivalente a 5% do seu salário base.\n");
                JOptionPane.showMessageDialog(null, "O valor do bônus deste funcionário é: R$" + (bonus = salariobase * 0.05) + "\n");
                JOptionPane.showMessageDialog(null, "O salário final deste funcionário é: R$" + (salariocombonus = salariobase + bonus) + "\n");

            } else if (desempenho >= 8 && desempenho <= 10) {
                JOptionPane.showMessageDialog(null, "Como a pontuação pelo desempenho ficou entre 8 e 10, este funcionário tem direito a um bônus equivalente a 10% do seu salário base.\n");
                JOptionPane.showMessageDialog(null, "O valor do bônus deste funcionário é: R$" + (bonus = salariobase * 0.1) + "\n");
                JOptionPane.showMessageDialog(null, "O salário final deste funcionário é: R$" + (salariocombonus = salariobase + bonus) + "\n");

            } else {
                JOptionPane.showMessageDialog(null, "Erro no sistema, tente outra vez.\n");
            }
            if ((salariocombonus >= 1000) && (salariocombonus <= 1500)) {
                entre = entre + 1;
            }
        }
        JOptionPane.showMessageDialog(null, "A quantidade de salários com o respectivo bônus, entre R$1.000,00 e R$1.500,00 é: " + entre + ".\n");

    }
}

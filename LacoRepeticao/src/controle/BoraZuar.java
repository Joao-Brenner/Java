package controle;

import javax.swing.JOptionPane;

public class BoraZuar {

    public static void main(String[] args) {
        double num, som = 0;
        int cont;
        for (cont = 0; cont < 5; cont++) {
            num = (Double.valueOf(JOptionPane.showInputDialog(null, "Mete um number aí boy:")));
            som = som + num;
        }
        JOptionPane.showMessageDialog(null, "A soma dos números, meu mano, dá: " + som + ".\n");
        JOptionPane.showMessageDialog(null, "Já a média, meu caro, é: " + (som / cont) + ".\n");

    }
}

package visao;

import controle.ControleEnquanto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VisaoEnquanto {

    public static void main(String[] args) {

        ControleEnquanto ce = new ControleEnquanto();
        int cont = 0, conf = 1;

        ArrayList<String> lista = new ArrayList<>();

        while (conf != 0) {
            cont++;
            ce.setNum(Integer.valueOf(JOptionPane.showInputDialog("Digite um number aí brother:")));
            lista.add(String.valueOf(ce.getNum()));
            conf = (Integer.valueOf(JOptionPane.showInputDialog("Digite "
                    + "1 para Continuar ou "
                    + "0 para Parar:")));
        }
        JOptionPane.showMessageDialog(null, "Os números que você digitou são: " + lista.toString());
        JOptionPane.showMessageDialog(null, "Voce digitou " + cont + " numbers.");
        JOptionPane.showMessageDialog(null, "O Soma dos números é: " + ce.getSum());
        JOptionPane.showMessageDialog(null, "A média é: " + (ce.getSum() / cont));

    }
}

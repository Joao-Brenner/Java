package visao;

import controle.Altura;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Tela {

    public static void main(String[] args) {
        Altura a = new Altura();
        int cont;
        double maior = 0;
        ArrayList<String> lista = new ArrayList<>();

        for (cont = 0; cont < 5; cont++) {
            a.setAltura(Double.valueOf(JOptionPane.showInputDialog("Digite uma altura:\n")));
            lista.add(String.valueOf(a.getAltura()));
            if (maior < a.getAltura()) {
                maior = a.getAltura();
            }
        }
        JOptionPane.showMessageDialog(null, lista.toString());
        JOptionPane.showMessageDialog(null, "A maior altura é: " + maior + "\n");
    }
}

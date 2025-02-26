package controle;

import javax.swing.JOptionPane;

public class DobroValor {

    public class Dobro {

        public static void main(String[] args) {
            int V;
            V = Integer.valueOf(JOptionPane.showInputDialog("Digite um número:"));
            JOptionPane.showMessageDialog(null, "O dobro foi: " + V * 2);
        }
    }
}

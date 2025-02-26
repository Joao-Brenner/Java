package controle;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Cadastrando {

    public static void main(String[] args) {

        String nome, sobrenome, dado = null;
        int cont, cod, idade;
        ArrayList<String> cadastro = new ArrayList<>(), cadastro2 = new ArrayList<>();

        for (cont = 0; cont < 3; cont++) {
            nome = JOptionPane.showInputDialog("Digite o nome");
            sobrenome = JOptionPane.showInputDialog("Digite o sobrenome");
            cadastro.add(nome);
            cadastro.add(sobrenome);
        }

        JOptionPane.showMessageDialog(null, cadastro.toString());

        for (cont = 0; cont < 5; cont++) {
            nome = JOptionPane.showInputDialog("Digite o nome:");
            idade = Integer.valueOf(JOptionPane.showInputDialog("Digite a idade:"));
            cod = Integer.valueOf(JOptionPane.showInputDialog("Digite o código:"));
            cadastro2.add(nome);
            cadastro2.add(String.valueOf(idade));
            cadastro2.add(String.valueOf(cod));
        }

        JOptionPane.showMessageDialog(null, cadastro2.toString());
        JOptionPane.showMessageDialog(null, "Entre os cadastros tem o nome Ana? " + cadastro2.contains("Ana"));
        dado = JOptionPane.showInputDialog(null, "Digite o que você quer que seja apagado? ");
        cadastro2.remove(dado);
        JOptionPane.showMessageDialog(null, cadastro2.toString());
    }
}

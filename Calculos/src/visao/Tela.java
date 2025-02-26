package visao;

import controle.Calculos;
import javax.swing.JOptionPane;

public class Tela {

    public static void main(String[] args) {
        Calculos c = new Calculos();
        c.setNota1(Double.valueOf(JOptionPane.showInputDialog(null, "Digite a primeira nota irmãozinho!")));
        c.setNota2(Double.valueOf(JOptionPane.showInputDialog(null, "Coloca a segunda nota irmãozão!")));
        JOptionPane.showMessageDialog(null, "A médias das notas é:" + c.getMedia());

        JOptionPane.showMessageDialog(null, "Bem vindo ao nosso sistema de compras!");
        JOptionPane.showMessageDialog(null, "Vamos somar os valores das suas compras?");
        c.setCompra1(Double.valueOf(JOptionPane.showInputDialog(null, "Digite o preço da primeira compra:")));
        c.setCompra2(Double.valueOf(JOptionPane.showInputDialog(null, "Digite o preço da segunda compra:")));
        c.setCompra3(Double.valueOf(JOptionPane.showInputDialog(null, "Digite o preço da terceira compra:")));
        c.setCompra4(Double.valueOf(JOptionPane.showInputDialog(null, "Digite o preço da quarta compra:")));
        c.setCompra5(Double.valueOf(JOptionPane.showInputDialog(null, "Digite o preço da quinta compra:")));
        JOptionPane.showMessageDialog(null, "A soma das compras da: R$" + c.getSoma());
        JOptionPane.showMessageDialog(null, "A média das compras é: " + c.getMedia2());

    }

}

package controle;

import javax.swing.JOptionPane;

public class Loja {

    public static void main(String[] args) {
        double valor, compra;
        int pagamento;
        valor = Double.valueOf(JOptionPane.showInputDialog("Coloca um valor aí:"));
        JOptionPane.showMessageDialog(null, "O número digitado é: " + valor);
        if (valor > 50) {
            JOptionPane.showMessageDialog(null, "O valor digitado é maior que 50.");
        } else if (valor < 50) {
            JOptionPane.showMessageDialog(null, "O valor digitado é menor que 50.");
        } else {
            JOptionPane.showMessageDialog(null, "O valor digitado é 50.");
        }

        JOptionPane.showMessageDialog(null, "Bem vindo a loja Star, nosso lema é: Aqui os Descontos São Interestelares!");
        JOptionPane.showMessageDialog(null, "Na nossa loja se você pagar à vista terá um desconto de 5%.");
        JOptionPane.showMessageDialog(null, "Na nossa loja se você pagar parcelado terá um adicional de 10% de juros.");
        compra = Double.valueOf(JOptionPane.showInputDialog("Qual o valor da sua compra?"));
        JOptionPane.showMessageDialog(null, "O valor da sua compra é: R$" + compra);
        pagamento = Integer.valueOf(JOptionPane.showInputDialog("Qual será a forma de pagamento:\n (1)Vista ou, \n (2)Parcelado."));
        if (pagamento == 1) {
            JOptionPane.showMessageDialog(null, "O preço da sua compra depois de aplicado o desconto de 5% é: R$" + (compra - compra * 0.05) + ".");
        } else if (pagamento == 2) {
            JOptionPane.showMessageDialog(null, "O preço da sua compra com o adicional de 10% de juros é: R$" + (compra + compra * 0.1) + ".");
        } else {
            JOptionPane.showMessageDialog(null, "A opção escolhida é inválida.");
        }
    }
}

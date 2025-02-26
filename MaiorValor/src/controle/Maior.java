package controle;

import javax.swing.JOptionPane;

public class Maior {

    public static void main(String[] args) {

        double n1, n2, n3;
        int na, nb, nc, nd, ne;

        JOptionPane.showMessageDialog(null, "Vamos descobrir qual número é o maior?");
        JOptionPane.showMessageDialog(null, "Vamos comparar três numbers, então coloca eles aí em baixo:");
        n1 = Double.valueOf(JOptionPane.showInputDialog("Digite o primeiro n°:"));
        n2 = Double.valueOf(JOptionPane.showInputDialog("Digite o segundo n°:"));
        n3 = Double.valueOf(JOptionPane.showInputDialog("Digite o number three:"));

        if ((n1 > n2 && n1 > n3) || (n1 == n2 && n1 > n3) || (n1 == n3 && n1 > n2)) {
            JOptionPane.showMessageDialog(null, "Dentre os 3 números dados o maior é o: " + n1 + ".\n");
        } else if ((n2 > n1 && n2 > n3) || (n2 == n3 && n2 > n1)) {
            JOptionPane.showMessageDialog(null, "Dentre os 3 números dados o maior é o: " + n2 + ".\n");
        } else if (n3 > n1 && n3 > n2) {
            JOptionPane.showMessageDialog(null, "Dentre os 3 números dados o maior é o : " + n3 + ".\n");
        } else if (n1 == n2 && n2 == n3) {
            JOptionPane.showMessageDialog(null, "Aparentemente todos os 3 números são iguais.\n");
        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro, por favor recomesse.\n");
        }

        /*}else if ((n1 == n2) && (n1 > n3))   
    {
    JOptionPane.showMessageDialog(null, "O primeiro e o segundo são iguais, e são os maiores, então o maior é o :"+n1+".\n");
    }else if ((n1 == n3) && (n1 > n2))   
    {
    JOptionPane.showMessageDialog(null, "O primeiro e o terceiro são iguais, e são os maiores, então o maior é o :"+n1+".\n");
    }else if ((n2 == n3) && (n2 > n1))   
    {
    JOptionPane.showMessageDialog(null, "O segundo e o terceiro são iguais, e são os maiores, então o maior é o :"+n2+".\n");
    }else if ((n1 == n2)&&( n2  == n3)){
    JOptionPane.showMessageDialog(null, "Aparentemente todos os 3 números são iguais.\n");
    }else{
    JOptionPane.showMessageDialog(null, "Ocorreu algum erro, por favor recomeçe.\n");
    }*/
        JOptionPane.showMessageDialog(null, "Vamos descobrir qual número inteiro e par é o top entre 5 opções, à sua escolha?");
        na = Integer.valueOf(JOptionPane.showInputDialog("Digite o primeiro n°:"));
        nb = Integer.valueOf(JOptionPane.showInputDialog("Digite o segundo n°:"));
        nc = Integer.valueOf(JOptionPane.showInputDialog("Digite o number three:"));
        nd = Integer.valueOf(JOptionPane.showInputDialog("Digite o quarto n°:"));
        ne = Integer.valueOf(JOptionPane.showInputDialog("Digite o último number:"));

        if ((na % 2 == 0) && (na > nb && na > nc && na > nd && na > ne)) {
            JOptionPane.showMessageDialog(null, "O maior número par é o: " + na + ".\n");
        } else if ((nb % 2 == 0) && (nb > na && nb > nc && nb > nd && nb > ne)) {
            JOptionPane.showMessageDialog(null, "O maior número par é o: " + nb + ".\n");
        } else if ((nc % 2 == 0) && (nc > na && nc > nb && nc > nd && nc > ne)) {
            JOptionPane.showMessageDialog(null, "O maior número par é o: " + nc + ".\n");
        } else if ((nd % 2 == 0) && (nd > na && nd > nb && nd > nc && nd > ne)) {
            JOptionPane.showMessageDialog(null, "O maior número par é o: " + nd + ".\n");
        } else if ((ne % 2 == 0) && (ne > na && ne > nb && ne > nc && ne > nd)) {
            JOptionPane.showMessageDialog(null, "O maior número par é o: " + ne + ".\n");
        } else {
            JOptionPane.showMessageDialog(null, "Erro no sistema, erro no sistema, tente de novo.\n");
        }

    }
}

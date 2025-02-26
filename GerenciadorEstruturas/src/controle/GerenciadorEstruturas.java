package controle;

import java.util.Arrays;
import javax.swing.JOptionPane;

class EstruturaDados {

    private int[] v = new int[5];
    private int valor, op;
    EstruturaDados no;

    public void setV(int[] v) {
        this.v = v;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setNo(EstruturaDados no) {
        this.no = no;
    }

    public int[] Escolher(int op) {
        if (op == 1) {
            return v;
        } else {
            return new int[0];
        }
    }

    public int Escolher(int op, boolean unicoValor) {
        if (op == 2) {
            return valor;
        } else {
            return 0;
        }
    }
}

public class GerenciadorEstruturas {

    public static void main(String[] args) {

        EstruturaDados next1 = new EstruturaDados();
        EstruturaDados next2 = new EstruturaDados();
        EstruturaDados next3 = new EstruturaDados();
        EstruturaDados next4 = new EstruturaDados();
        EstruturaDados next5 = new EstruturaDados();

        next1.setValor(15);
        next1.setNo(next2);

        next2.setValor(45);
        next2.setNo(next3);

        next3.setValor(39);
        next3.setNo(next4);

        next4.setValor(59);
        next4.setNo(next5);

        next5.setValor(78);
        next5.setNo(null);

        next1.setV(new int[]{1, 2, 3, 4, 5});
        int op;
        op = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n"
                + "1°_ Array\n"
                + "2_Lista Ligada"));

        if (op == 1) {
            System.out.println("Vetor: " + Arrays.toString(next1.Escolher(op)));

        } else if (op == 2) {
            EstruturaDados next = next1;

            while (next != null) {

                System.out.println("Fila: " + next.Escolher(op, true));

                next = next.no;

            }
        }
    }
}

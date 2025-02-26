package controle;

public class Calculos {

    private double nota1, nota2, compra1, compra2, compra3, compra4, compra5;

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota2() {
        return nota2;
    }

    public double getMedia() {
        return (this.nota1 + this.nota2) / 2;
    }

    public void setCompra1(double compra1) {
        this.compra1 = compra1;
    }

    public double getCompra1() {
        return compra1;
    }

    public void setCompra2(double compra2) {
        this.compra2 = compra2;
    }

    public double getCompra2() {
        return compra2;
    }

    public void setCompra3(double compra3) {
        this.compra3 = compra3;
    }

    public double getCompra3() {
        return compra3;
    }

    public void setCompra4(double compra4) {
        this.compra4 = compra4;
    }

    public double getCompra4() {
        return compra4;
    }

    public void setCompra5(double compra5) {
        this.compra5 = compra5;
    }

    public double getCompra5() {
        return compra5;
    }

    public double getSoma() {
        return this.compra1 + this.compra2 + this.compra3 + this.compra4 + this.compra5;
    }

    public double getMedia2() {
        return (this.compra1 + this.compra2 + this.compra3 + this.compra4 + this.compra5) / 5;
    }

}

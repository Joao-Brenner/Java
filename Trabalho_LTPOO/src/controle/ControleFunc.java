/* O projeto só funciona se inicializado pela Home*/
package controle;

public class ControleFunc {

    private String nome;
    private int idade;
    private String cargo;
    private String CPF;
    private String email;
    private String formacao;
    private double remuneracao;
    private int departamento_id;
    double r;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public double getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(double remuneracao) {

        if (cargo.equals("aprendiz")) {
            r = 800;
        } else if (cargo.equals("estagio")) {
            r = 1412.00;
        } else if (cargo.equals("junior")) {
            r = 3000;
        } else if (cargo.equals("pleno")) {
            r = 5000.00;
        } else if (cargo.equals("senior")) {
            r = 7000.00;
        }

        if (formacao.equals("pos")) {
            r += 1000;
        } else if (formacao.equals("mestrado")) {
            r += 2000;
        } else if (formacao.equals("doutorado")) {
            r += 3000;
        }

        this.remuneracao = r;
    }

    public int getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(int departamento_id) {
        this.departamento_id = departamento_id;
    }

}

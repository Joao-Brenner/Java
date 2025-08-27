public class Processo  implements Comparable<Processo> {


    public String nome;
    public int tempoExecucao;
    public int prioridade;

    public Processo(String nome, int tempoExecucao, int prioridade) {
        this.nome = nome;
        this.tempoExecucao = tempoExecucao;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }
    
    

    @Override
    public int compareTo(Processo outro) {
        return Integer.compare(this.tempoExecucao, outro.tempoExecucao); // usado no SJF
    }

    @Override
    public String toString() {
        return nome + " [Tempo: " + tempoExecucao + ", Prioridade: " + prioridade + "]";
    }
}
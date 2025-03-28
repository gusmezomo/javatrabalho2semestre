//TRABALHO GRAU B - Gustavo Mezomo e Vinicius Bergmann
public class Cliente {
    private final int id;
    private final String nome;
    private final boolean prioridade;

    //construtor
    public Cliente(int id, String nome, boolean prioridade) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
    }

    // metodo para verificar se o cliente tem prioridade.
    public boolean temPrioridade() {
        return prioridade;
    }

    // metodo para obter o nome do cliente.
    public String getNome() {
        return nome;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Cliente " + id + " " + nome + (prioridade ? " (Prioridade)" : "");
    }
}
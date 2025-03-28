import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
//TRABALHO GRAU B - Gustavo Mezomo e Vinicius Bergmann
public class Supermercado {
    private final List<Caixa> caixas;
    private final int numClientes;
    private final Random random;
    private final String[] nomes = {"Duda", "Gustavo", "Vini", "História", "Bestetti", "Vanin", "JV", "Augusto", "VG", "JVzinho", "Lucas", "Eduardo"};

    // Construtor para inicializar o supermercado com uma quantidade de caixas normais e de prioridade, e um número de clientes.
    public Supermercado(int numCaixasNormais, int numClientesPrioridade, int numClientes) {
        this.caixas = new ArrayList<>();
        for (int i = 0; i < numClientesPrioridade; i++) {
            caixas.add(new Caixa(true)); // Adiciona caixas de prioridade.
        }
        for (int i = 0; i < numCaixasNormais; i++) {
            caixas.add(new Caixa(false)); // Adiciona caixas normais.
        }
        this.numClientes = numClientes;
        this.random = new Random();
    }

    // Método para iniciar a simulação do supermercado.
    public void iniciarSimulacao() {
        for (int i = 0; i < numClientes; i++) {
            String nome = nomes[random.nextInt(nomes.length)];
            Cliente cliente = new Cliente(i, nome, random.nextBoolean());
            Caixa caixa = escolherCaixa(cliente);
            caixa.adicionarCliente(cliente);
            System.out.println(cliente + " entrou na fila do caixa " + (caixas.indexOf(caixa) + 1));
        }

        // Inicia o processo de atendimento
        List<Caixa> caixasDisponiveis = new ArrayList<>(caixas);
        while (!caixasDisponiveis.isEmpty()) {
            int index = random.nextInt(caixasDisponiveis.size());
            Caixa caixa = caixasDisponiveis.get(index);
            if (!caixa.estaVazio()) {
                // Atende o cliente e imprime o tempo de atendimento.
                caixa.atenderCliente(index + 1);
            } else {
                // Remove o caixa da lista de disponíveis se não houver mais clientes na fila.
                caixasDisponiveis.remove(caixa);
            }
        }
    }

    // Método para escolher um caixa para o cliente entrar na fila.
    private Caixa escolherCaixa(Cliente cliente) {
        if (cliente.temPrioridade()) {
            // Retorna o caixa de prioridade.
            return caixas.stream().filter(Caixa::temPrioridade).findFirst().orElse(null);
        } else {
            // Retorna o caixa normal com a menor fila.
            return caixas.stream().filter(c -> !c.temPrioridade())
                    .min(Comparator.comparingInt(c -> c.getFila().size()))
                    .orElse(null);
        }
    }

    // Método MAIN
    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado(2, 1, 30);
        supermercado.iniciarSimulacao();
    }
}
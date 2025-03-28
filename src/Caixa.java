import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
//TRABALHO GRAU B - Gustavo Mezomo e Vinicius Bergmann
public class Caixa {
    private final Queue<Cliente> fila;
    private final boolean prioridade;
    private final Random random;

    //construtor
    public Caixa(boolean prioridade) {
        this.fila = new LinkedList<>();
        this.prioridade = prioridade;
        this.random = new Random();
    }

    // metodo para adicionar clientes à fila do caixa.
    public void adicionarCliente(Cliente cliente) {
        fila.offer(cliente);
    }

    // metodo para atender um cliente da fila.
    public void atenderCliente(int numeroCaixa) {
        Cliente cliente = fila.poll();
        // Simula o tempo de atendimento 
        int tempoAtendimento = 35000 + random.nextInt(50000);
        // Imprime o tempo de atendimento convertido para segundos.
        System.out.println("Caixa " + numeroCaixa + " atendeu " + cliente + " em " + (tempoAtendimento / 1000) + " segundos");
    }

    // metodo para verificar se o caixa é de prioridade.
    public boolean temPrioridade() {
        return prioridade;
    }

    // metodo para verificar se a fila do caixa está vazia.
    public boolean estaVazio() {
        return fila.isEmpty();
    }

    // metodo para obter a fila de clientes de um caixa.
    public Queue<Cliente> getFila() {
        return fila;
    }
}
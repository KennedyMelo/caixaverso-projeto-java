import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        gerenciador.cadastrarTarefa("Estudar Java", "Revisar Streams", LocalDate.now().plusDays(1), StatusTarefa.PENDENTE);
        gerenciador.cadastrarTarefa("Reunião", "Sprint Planning", LocalDate.now().plusDays(2), StatusTarefa.EM_ANDAMENTO);

        System.out.println("Todas as tarefas:");
        gerenciador.listarTodas().forEach(System.out::println);

        System.out.println("\nTarefas pendentes:");
        gerenciador.filtrarPorStatus(StatusTarefa.PENDENTE).forEach(System.out::println);

        System.out.println("\nTarefas ordenadas por data limite:");
        gerenciador.listarOrdenadasPorDataLimite().forEach(System.out::println);

        // Notificação extra
        NotificadorTarefas.notificarTarefasProximas(gerenciador, 2);
    }
}
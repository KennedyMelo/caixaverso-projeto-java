import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class NotificadorTarefas {
    public static void notificarTarefasProximas(GerenciadorTarefas gerenciador, int dias) {
        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2); // Simula delay
                List<Tarefa> proximas = gerenciador.tarefasProximasDoPrazo(dias);
                if (!proximas.isEmpty()) {
                    System.out.println("Tarefas próximas do prazo:");
                    proximas.forEach(System.out::println);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}
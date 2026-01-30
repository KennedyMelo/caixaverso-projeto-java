import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GerenciadorTarefas {
    private final List<Tarefa> tarefas = new ArrayList<>();

    public boolean cadastrarTarefa(String titulo, String descricao, LocalDate dataLimite, StatusTarefa status) {
        Predicate<String> tituloValido = t -> Optional.ofNullable(t).filter(s -> s.length() >= 5).isPresent();
        Predicate<LocalDate> dataValida = d -> Optional.ofNullable(d).filter(date -> !date.isBefore(LocalDate.now())).isPresent();
        Predicate<StatusTarefa> statusValido = s -> Optional.ofNullable(s).isPresent();

        if (!tituloValido.test(titulo)) return false;
        if (!dataValida.test(dataLimite)) return false;
        if (!statusValido.test(status)) return false;

        Tarefa tarefa = new Tarefa(titulo, descricao, dataLimite, status);
        tarefas.add(tarefa);
        return true;
    }

    public List<Tarefa> listarTodas() {
        return Optional.of(tarefas)
                .map(ArrayList::new)
                .orElse(new ArrayList<>());
    }

    public List<Tarefa> filtrarPorStatus(StatusTarefa status) {
        Predicate<Tarefa> statusPredicate = t -> t.getStatus() == status;
        return Optional.of(tarefas)
                .orElse(Collections.emptyList())
                .stream()
                .filter(statusPredicate)
                .collect(Collectors.toList());
    }

    public List<Tarefa> listarOrdenadasPorDataLimite() {
        return Optional.of(tarefas)
                .orElse(Collections.emptyList())
                .stream()
                .sorted(Comparator.comparing(Tarefa::getDataLimite))
                .collect(Collectors.toList());
    }

    public List<Tarefa> tarefasProximasDoPrazo(int dias) {
        LocalDate hoje = LocalDate.now();
        return tarefas.stream()
                .filter(t -> !t.getStatus().equals(StatusTarefa.CONCLUIDO))
                .filter(t -> !t.getDataLimite().isBefore(hoje) && !t.getDataLimite().isAfter(hoje.plusDays(dias)))
                .collect(Collectors.toList());
    }
}
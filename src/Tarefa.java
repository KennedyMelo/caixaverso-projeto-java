import java.time.LocalDate;

public class Tarefa {
    private String titulo;
    private String descricao;
    private LocalDate dataLimite;
    private StatusTarefa status;

    public Tarefa(String titulo, String descricao, LocalDate dataLimite, StatusTarefa status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataLimite = dataLimite;
        this.status = status;
    }

    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public LocalDate getDataLimite() { return dataLimite; }
    public StatusTarefa getStatus() { return status; }

    @Override
    public String toString() {
        return "Tarefa{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataLimite=" + dataLimite +
                ", status=" + status +
                '}';
    }
}
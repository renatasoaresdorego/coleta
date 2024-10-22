package br.com.fiap.coleta.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "T_REC_AGENDA")
public class Agenda {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_AGENDA"
    )
    @SequenceGenerator(
            name = "SEQ_AGENDA",
            sequenceName = "SEQ_AGENDA",
            allocationSize = 1
    )
    private Long idAgenda;

    @ManyToOne
    @JoinColumn(name = "id_rota")
    private Rota rota;

//    @ManyToOne
//    @JoinColumn(name = "id_ponto_coleta")
//    private Ponto ponto;

    @Column(name = "dt_prox_coleta")
    private LocalDate dataProximaColeta;

    @Column(name = "dt_ult_coleta")
    private LocalDate dataUltimaColeta;

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Long getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Long id) {
        this.idAgenda = id;
    }

    public LocalDate getDataProximaColeta() {
        return dataProximaColeta;
    }

    public void setDataProximaColeta(LocalDate dataProximaColeta) {
        this.dataProximaColeta = dataProximaColeta;
    }

    public LocalDate getDataUltimaColeta() {
        return dataUltimaColeta;
    }

    public void setDataUltimaColeta(LocalDate dataUltimaColeta) {
        this.dataUltimaColeta = dataUltimaColeta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenda agenda = (Agenda) o;
        return Objects.equals(idAgenda, agenda.idAgenda) && Objects.equals(dataProximaColeta, agenda.dataProximaColeta) && Objects.equals(dataUltimaColeta, agenda.dataUltimaColeta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAgenda, dataProximaColeta, dataUltimaColeta);
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id=" + idAgenda +
                ", dataProximaColeta=" + dataProximaColeta +
                ", dataUltimaColeta=" + dataUltimaColeta +
                '}';
    }
}

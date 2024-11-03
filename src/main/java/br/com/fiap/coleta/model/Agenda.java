package br.com.fiap.coleta.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "T_REC_AGENDA")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AGENDA")
    @SequenceGenerator(name = "SEQ_AGENDA", sequenceName = "SEQ_AGENDA", allocationSize = 1)
    @Column(name = "id_agenda")
    private Long idAgenda;

    @Column(name = "dt_prox_coleta")
    private LocalDate dataProximaColeta;

    @Column(name = "dt_ult_coleta")
    private LocalDate dataUltimaColeta;

    @ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rota")
    private Rota rota;

    @ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.EAGER)
    private PontoDeColeta pontoDeColeta;
}

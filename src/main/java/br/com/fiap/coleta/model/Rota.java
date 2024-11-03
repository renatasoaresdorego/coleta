package br.com.fiap.coleta.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "T_REC_ROTA")
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ROTA")
    @SequenceGenerator(name = "SEQ_ROTA", sequenceName = "SEQ_ROTA", allocationSize = 1)
    @Column(name = "id_rota")
    private Long idRota;

    @Column(name = "nm_rota")
    private String nome;

    @Column(name = "ds_inicio")
    private String inicio;

    @Column(name = "ds_final")
    private String fim;

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<Caminhao> caminhoes;

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<Agenda> agendas;
}

package br.com.fiap.coleta.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class PontoDeColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COLETA")
    @SequenceGenerator(name = "SEQ_COLETA", sequenceName = "SEQ_COLETA", allocationSize = 1)
    @Column(name = "id_ponto_coleta")
    private Long idPontoDeColeta;

    @Column(name = "ds_endereco")
    private String endereco;

    @Column(name = "dt_prox_coleta")
    private Double capacidadeMaxima;

    @Column(name = "dt_ult_coleta")
    private Double capacidadeAtual;

    @Enumerated(EnumType.STRING)
    private Residuo residuo;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Agenda> agendamentosDeColeta;

}

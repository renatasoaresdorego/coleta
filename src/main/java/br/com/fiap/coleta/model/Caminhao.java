package br.com.fiap.coleta.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "T_REC_CAMINHAO")
public class Caminhao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CAMINHAO")
    @SequenceGenerator(name = "SEQ_CAMINHAO", sequenceName = "SEQ_CAMINHAO", allocationSize = 1)
    @Column(name = "id_caminhao")
    private Long idCaminhao;

    @Column(name = "nr_capacidade")
    private Long capacidade;

    @Column(name = "tx_local_temp_real")
    private String localizacaoEmTempoReal;

    @Column(name = "tx_placa")
    private String placa;

    @Column(name = "st_servico")
    private Boolean statusServico;

    @ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rota")
    private Rota rota;
}

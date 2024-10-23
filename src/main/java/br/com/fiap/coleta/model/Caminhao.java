package br.com.fiap.coleta.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "T_REC_CAMINHAO")
public class Caminhao {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CAMINHAO"
    )
    @SequenceGenerator(
            name = "SEQ_CAMINHAO",
            sequenceName = "SEQ_CAMINHAO",
            allocationSize = 1
    )

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

    @ManyToOne
    @JoinColumn(name = "id_rota", referencedColumnName = "id_rota")
    //@JoinColumn: Especifica a coluna de chave estrangeira id_rota na tabela T_REC_CAMINHAO, que referencia a coluna id_rota na tabela T_REC_ROTA
    private Rota idRota;

    public Long getIdCaminhao() {
        return idCaminhao;
    }

    public void setIdCaminhao(Long id) {
        this.idCaminhao = id;
    }

    public Long getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Long capacidade) {
        this.capacidade = capacidade;
    }

    public String getLocalizacaoEmTempoReal() {
        return localizacaoEmTempoReal;
    }

    public void setLocalizacaoEmTempoReal(String localizacaoEmTempoReal) {
        this.localizacaoEmTempoReal = localizacaoEmTempoReal;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Boolean getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(Boolean statusServico) {
        this.statusServico = statusServico;
    }

    public Rota getIdRota() {
        return idRota;
    }

    public void setIdRota(Rota idRota) {
        this.idRota = idRota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caminhao caminhao = (Caminhao) o;
        return Objects.equals(idCaminhao, caminhao.idCaminhao) &&
                Objects.equals(capacidade, caminhao.capacidade) &&
                Objects.equals(localizacaoEmTempoReal, caminhao.localizacaoEmTempoReal) &&
                Objects.equals(placa, caminhao.placa) &&
                Objects.equals(statusServico, caminhao.statusServico) &&
                Objects.equals(idRota, caminhao.idRota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCaminhao, capacidade, localizacaoEmTempoReal, placa, statusServico);
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "id=" + idCaminhao +
                ", capacidade=" + capacidade +
                ", localizacaoEmTempoReal='" + localizacaoEmTempoReal + '\'' +
                ", placa='" + placa + '\'' +
                ", statusServico=" + statusServico +
                ", rota=" + idRota +
                '}';
    }

    public void setRota(Rota rota) {
        this.idRota = rota;
    }
}

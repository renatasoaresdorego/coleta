package br.com.fiap.coleta.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "T_REC_ROTA")
public class Rota {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ROTA"
    )
    @SequenceGenerator(
            name = "SEQ_ROTA",
            sequenceName = "SEQ_ROTA",
            allocationSize = 1
    )
    @Column(name = "id_rota")
    private Long idRota;

    @Column(name = "nm_rota")
    private String nome;

    @Column(name = "ds_inicio")
    private String inicio;

    @Column(name = "ds_final")
    private String fim;

    public Long getIdRota() {
        return idRota;
    }

    public void setIdRota(Long id) {
        this.idRota = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rota rota = (Rota) o;
        return Objects.equals(idRota, rota.idRota) && Objects.equals(nome, rota.nome) && Objects.equals(inicio, rota.inicio) && Objects.equals(fim, rota.fim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRota, nome, inicio, fim);
    }

    @Override
    public String toString() {
        return "Rota{" +
                "id=" + idRota +
                ", nome='" + nome + '\'' +
                ", inicio='" + inicio + '\'' +
                ", fim='" + fim + '\'' +
                '}';
    }
}

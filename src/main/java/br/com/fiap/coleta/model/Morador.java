package br.com.fiap.coleta.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "T_REC_MORADOR")
public class Morador {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_MORADOR"
    )
    @SequenceGenerator(
            name = "SEQ_MORADOR",
            sequenceName = "SEQ_MORADOR",
            allocationSize = 1
    )
    @Column(name = "id_morador")
    private Long idMorador;

    @Column(name = "nm_morador")
    private String nome;

    @Column(name = "st_rec_notif")
    private Boolean statusNotificacao;

    @Column(name = "tx_telefone")
    private String telefone;

    @Column(name = "tx_email")
    private String email;

    public Long getIdMorador() {
        return idMorador;
    }

    public void setIdMorador(Long id) {
        this.idMorador = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getStatusNotificacao() {
        return statusNotificacao;
    }

    public void setStatusNotificacao(Boolean statusNotificacao) {
        this.statusNotificacao = statusNotificacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Morador morador = (Morador) o;
        return Objects.equals(idMorador, morador.idMorador) && Objects.equals(nome, morador.nome) && Objects.equals(statusNotificacao, morador.statusNotificacao) && Objects.equals(telefone, morador.telefone) && Objects.equals(email, morador.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMorador, nome, statusNotificacao, telefone, email);
    }

    @Override
    public String toString() {
        return "Morador{" +
                "id=" + idMorador +
                ", nome='" + nome + '\'' +
                ", statusNotificacao=" + statusNotificacao +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

package br.com.fiap.coleta.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
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

    @Override
    public String toString() {
        return "Morador = "
                + "\nId: " + idMorador
                + "\nNome do morador: " + nome
                + "\nNotificação recebida?: " + statusNotificacao
                + "\nTelefone: " + telefone
                + "\nEmail='" + email;
    }

}

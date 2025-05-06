package br.com.fiap.fase5.capitulo4.coleta.model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class UsuarioFeatureModel {
    @Expose(serialize = false)
    private String id;
    @Expose
    private String cpf;
    @Expose
    private String nome;
    @Expose
    private String telefone;
    @Expose
    private String email;
    @Expose
    private String senha;
}

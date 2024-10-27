package br.com.fiap.coleta.model;

public enum Role {
    ADMIN("admin"),
    USER("usuario");

    private String role;


    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}

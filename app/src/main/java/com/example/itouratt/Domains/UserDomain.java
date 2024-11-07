package com.example.itouratt.Domains;

public class UserDomain {

    private String UUID;
    private String nome;
    private String email;
    private String password;

    public UserDomain() {
    }

    public UserDomain(String UUID, String nome, String email, String password) {
        this.UUID = UUID;
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

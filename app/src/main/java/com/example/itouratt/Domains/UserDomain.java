package com.example.itouratt.Domains;

import java.util.List;

public class UserDomain {

    private String nome;
    private String email;
    private String password;
    private List<DestinationsDomain> travels;

    public UserDomain() {
    }

    public UserDomain(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public UserDomain(String nome, String email, String password, List<DestinationsDomain> travels) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.travels = travels;
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

    public List<DestinationsDomain> getTravels() {
        return travels;
    }

    public void setTravels(List<DestinationsDomain> travels) {
        this.travels = travels;
    }
}

package br.com.cadastro.usuario;

import java.util.Date;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String endereco;
    private int num_endereco;
    private Date data_cadastro;

    public Usuario(int id ,String nome, String email , String endereco, int num_endereco ,Date data_cadastro){
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.num_endereco = num_endereco;
        this.data_cadastro = data_cadastro;
    }

    public Usuario(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNum_endereco() {
        return num_endereco;
    }

    public void setNum_endereco(int num_endereco) {
        this.num_endereco = num_endereco;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
}

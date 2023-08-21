package upe.poli.games;

public class Jogador {
    private String nome;
    private int cor;
    private int jogadas;
    private  String modo;
    public Jogador(String nome, int cor) {
        this.nome = nome;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public int getCor() {
        return cor;
    }
    public int getJogadas() {
        return jogadas;
    }

    public void setJogadas(int jogadas) {
        this.jogadas = jogadas;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }



}
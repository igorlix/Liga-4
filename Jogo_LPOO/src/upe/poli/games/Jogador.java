package upe.poli.games;

public class Jogador {
    private String nome;
    private char cor;
    private int jogadas;
    public Jogador(String nome, char cor) {
        this.nome = nome;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public char getCor() {
        return cor;
    }
    public int getJogadas() {
        return jogadas;
    }

    public void setJogadas(int jogadas) {
        this.jogadas = jogadas;
    }


}
package upe.poli.games;

public class Jogador {
    private String nome;
    private char cor;
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

    public boolean verificarDisponibilidade(int coluna, char cor, int tamanhoTabuleiro, Tabuleiro tabuleiro) {
        if (coluna < 0 || coluna >= tamanhoTabuleiro) {
            return false;
        }
        else{
            for (int i = tamanhoTabuleiro - 1; i >= 0; i--) {
                if (tabuleiro.getCelula()[i][coluna] == 0) {
                    tabuleiro.getCelula()[i][coluna] = cor;
                    return true;
                }
            }
        }
        return true;
    }

}
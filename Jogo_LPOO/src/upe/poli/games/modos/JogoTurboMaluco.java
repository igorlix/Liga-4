package upe.poli.games.modos;

import upe.poli.games.Jogador;

public class JogoTurboMaluco extends Jogo implements Modo {

    public JogoTurboMaluco(Jogador jogador1, Jogador jogador2, int tamanhoTabuleiro) {
        super(jogador1, jogador2, tamanhoTabuleiro);
    }

    public void start() {
        super.start();
    }

    //@override
    public boolean verificarDisponibilidade(int coluna, char cor) {
        if (coluna < 0 || coluna >= tamanhoTabuleiro) {
            return false;
        }
        else{
            for (int i = tamanhoTabuleiro - 1; i >= 0; i--) {
                if (tabuleiro.getCelula()[i][coluna] == 0) {
                    tabuleiro.getCelula()[i][coluna] = cor;

                    // Verificação das colunas
                    if(coluna + 1 < tamanhoTabuleiro && tabuleiro.getCelula()[i][coluna+1] != 0){
                        tabuleiro.getCelula()[i][coluna+1] = cor;
                    }
                    if(coluna -1 >= 0 && tabuleiro.getCelula()[i][coluna-1] != 0 ){
                        tabuleiro.getCelula()[i][coluna-1] = cor;
                    }

                    // Verificação das linhas
                    if(i+1 < tamanhoTabuleiro && tabuleiro.getCelula()[i+1][coluna] != 0){
                        tabuleiro.getCelula()[i+1][coluna] = cor;
                    }
                    if(i -1 >= 0 && tabuleiro.getCelula()[i-1][coluna] != 0 ){
                        tabuleiro.getCelula()[i-1][coluna] = cor;
                    }

                    // Verificação das diagonais
                    if (i - 1 >= 0 && coluna - 1 >= 0 && tabuleiro.getCelula()[i - 1][coluna - 1] != 0) {
                        tabuleiro.getCelula()[i - 1][coluna - 1] = cor;
                    }
                    if (i - 1 >= 0 && coluna + 1 < tamanhoTabuleiro && tabuleiro.getCelula()[i - 1][coluna + 1] != 0) {
                        tabuleiro.getCelula()[i - 1][coluna + 1] = cor;
                    }
                    if (i + 1 < tamanhoTabuleiro && coluna - 1 >= 0 && tabuleiro.getCelula()[i + 1][coluna - 1] != 0) {
                        tabuleiro.getCelula()[i + 1][coluna - 1] = cor;
                    }
                    if (i + 1 < tamanhoTabuleiro && coluna + 1 < tamanhoTabuleiro && tabuleiro.getCelula()[i + 1][coluna + 1] != 0) {
                        tabuleiro.getCelula()[i + 1][coluna + 1] = cor;
                    }
                    return true;
                }
            }
        }
        return true;
    }
}

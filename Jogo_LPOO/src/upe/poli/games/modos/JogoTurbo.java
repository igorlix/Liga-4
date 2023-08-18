package upe.poli.games.modos;

import upe.poli.games.Jogador;

public class JogoTurbo extends Jogo implements Modo {
    public JogoTurbo(Jogador jogador1, Jogador jogador2, int tamanhoTabuleiro) {
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
                    if(coluna + 1 < tamanhoTabuleiro && tabuleiro.getCelula()[i][coluna+1] != 0){
                        tabuleiro.getCelula()[i][coluna+1] = cor;
                    }
                    if(coluna -1 >= 0 && tabuleiro.getCelula()[i][coluna-1] != 0 ){
                        tabuleiro.getCelula()[i][coluna-1] = cor;
                    }
                    return true;
                }
            }
        }
        return true;
    }
}
    
   


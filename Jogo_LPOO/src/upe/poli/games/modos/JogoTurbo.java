package upe.poli.games.modos;

import upe.poli.games.Jogador;
import upe.poli.games.ranking.Ranking;

public class JogoTurbo extends Jogo {
    public JogoTurbo(Jogador jogador1, Jogador jogador2, int tamanhoTabuleiro, Ranking ranking) {
        super(jogador1, jogador2, tamanhoTabuleiro, ranking);
    }

    @Override
    public void atualizarTabuleiro(int col) {
        String modo = "Turbo";
        jogador1.setModo("Turbo");
        for (int row = tamanhoTabuleiro - 1; row >= 0; row--) {
            if (tabuleiro.getCelula()[row][col] == 0) {
                tabuleiro.getCelula()[row][col] = jogador1.getCor();
                updateButtonAppearance(row, col, jogador1.getCor());
                int jogadas = jogador1.getJogadas();
                jogadas++;
                jogador1.setJogadas(jogadas);

                if (col + 1 < tamanhoTabuleiro && tabuleiro.getCelula()[row][col + 1] != 0) {
                    tabuleiro.getCelula()[row][col + 1] = jogador1.getCor();
                    updateButtonAppearance(row, col + 1, jogador1.getCor());
                }

                if (col - 1 >= 0 && tabuleiro.getCelula()[row][col - 1] != 0) {
                    tabuleiro.getCelula()[row][col - 1] = jogador1.getCor();
                    updateButtonAppearance(row, col - 1, jogador1.getCor());
                }

                break;
            }
        }
    }
}

package upe.poli.games.modos;

import upe.poli.games.Jogador;
import upe.poli.games.ranking.Ranking;

public class JogoTurboMaluco extends Jogo {
    public JogoTurboMaluco(Jogador jogador1, Jogador jogador2, int tamanhoTabuleiro, Ranking ranking) {
        super(jogador1, jogador2, tamanhoTabuleiro, ranking);
    }

    @Override
    public void atualizarTabuleiro(int col) {
        String modo = "Turbo Maluco";
        jogador1.setModo("Turbo Maluco");
        for (int row = tamanhoTabuleiro - 1; row >= 0; row--) {
            if (tabuleiro.getCelula()[row][col] == 0) {
                int cor = jogador1.getCor();
                tabuleiro.getCelula()[row][col] = cor;
                updateButtonAppearance(row, col, cor);
                int jogadas = jogador1.getJogadas();
                jogadas++;
                jogador1.setJogadas(jogadas);

                // Update horizontally
                for (int c = col - 1; c >= 0 && tabuleiro.getCelula()[row][c] != 0 && c >= col - 1; c--) {
                    tabuleiro.getCelula()[row][c] = cor;
                    updateButtonAppearance(row, c, cor);
                }
                for (int c = col + 1; c < tamanhoTabuleiro && tabuleiro.getCelula()[row][c] != 0 && c <= col + 1; c++) {
                    tabuleiro.getCelula()[row][c] = cor;
                    updateButtonAppearance(row, c, cor);
                }

                // Update diagonally (top-left to bottom-right)
                for (int r = row - 1, c = col - 1; r >= 0 && c >= 0 && tabuleiro.getCelula()[r][c] != 0 && c >= col - 1; r--, c--) {
                    tabuleiro.getCelula()[r][c] = cor;
                    updateButtonAppearance(r, c, cor);
                }
                for (int r = row + 1, c = col + 1; r < tamanhoTabuleiro && c < tamanhoTabuleiro && tabuleiro.getCelula()[r][c] != 0 && c <= col + 1; r++, c++) {
                    tabuleiro.getCelula()[r][c] = cor;
                    updateButtonAppearance(r, c, cor);
                }

                // Update diagonally (bottom-left to top-right)
                for (int r = row + 1, c = col - 1; r < tamanhoTabuleiro && c >= 0 && tabuleiro.getCelula()[r][c] != 0 && c >= col - 1; r++, c--) {
                    tabuleiro.getCelula()[r][c] = cor;
                    updateButtonAppearance(r, c, cor);
                }
                for (int r = row - 1, c = col + 1; r >= 0 && c < tamanhoTabuleiro && tabuleiro.getCelula()[r][c] != 0 && c <= col + 1; r--, c++) {
                    tabuleiro.getCelula()[r][c] = cor;
                    updateButtonAppearance(r, c, cor);
                }

                break;
            }
        }
    }
}


package upe.poli.games;

public class Vitoria{

    public static boolean jogadorVenceu(Tabuleiro tabuleiro, Jogador jogadorAtual, int tamanhoTabuleiro) {
        char cor = jogadorAtual.getCor();

        // Verifica linhas
        for (int i = 0; i < tamanhoTabuleiro; i++) {
            int count = 0;
            for (int j = 0; j < tamanhoTabuleiro; j++) {
                if (tabuleiro.celula[i][j] == cor) {
                    count++;
                    if (count == 4) {
                        for (int k = j - 3; k <= j; k++) {
                            if(cor == 'X'){
                                tabuleiro.celula[i][k] = 'Z';
                            }
                            else if (cor == 'Y'){
                                tabuleiro.celula[i][k] = 'W';
                            }
                        }
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Verifica colunas
        for (int j = 0; j < tamanhoTabuleiro; j++) {
            int count = 0;
            for (int i = 0; i < tamanhoTabuleiro; i++) {
                if (tabuleiro.celula[i][j] == cor) {
                    count++;
                    if (count == 4) {
                        for (int k = i - 3; k <= i; k++) {
                            tabuleiro.celula[k][j] = 'Z'; // Marca as 4 peças vencedoras
                        }
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Verifica diagonais \
        for (int i = 0; i <= tamanhoTabuleiro - 4; i++) {
            for (int j = 0; j <= tamanhoTabuleiro - 4; j++) {
                boolean venceu = true;
                for (int k = 0; k < 4; k++) {
                    if (tabuleiro.celula[i + k][j + k] != cor) {
                        venceu = false;
                        break;
                    }
                }
                if (venceu) {
                    for (int k = 0; k < 4; k++) {
                        tabuleiro.celula[i + k][j + k] = 'Z'; // Marca as 4 peças vencedoras
                    }
                    return true;
                }
            }
        }

        // Verifica diagonais /
        for (int i = 3; i < tamanhoTabuleiro; i++) {
            for (int j = 0; j <= tamanhoTabuleiro - 4; j++) {
                boolean venceu = true;
                for (int k = 0; k < 4; k++) {
                    if (tabuleiro.celula[i - k][j + k] != cor) {
                        venceu = false;
                        break;
                    }
                }
                if (venceu) {
                    for (int k = 0; k < 4; k++) {
                        tabuleiro.celula[i - k][j + k] = 'Z'; // Marca as 4 peças vencedoras
                    }
                    return true;
                }
            }
        }

        return false;
    }
}
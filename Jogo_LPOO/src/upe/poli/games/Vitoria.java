package upe.poli.games;

public abstract class Vitoria{

    public static boolean jogadorVenceu(Tabuleiro tabuleiro, Jogador jogadorAtual, int tamanhoTabuleiro) {
        int cor = jogadorAtual.getCor();

        char marcaVitoria;
        if (cor == 1) {
            marcaVitoria = 'Z';
        } else if (cor == 2) {
            marcaVitoria = 'W';
        } else {
            return false;
        }

        // Verificar linhas
        for (int i = 0; i < tamanhoTabuleiro; i++) {
            int count = 0;
            for (int j = 0; j < tamanhoTabuleiro; j++) {
                if (tabuleiro.celula[i][j] == cor) {
                    count++;
                    if (count == 4) {
                        for (int k = j - 3; k <= j; k++) {
                            tabuleiro.celula[i][k] = marcaVitoria;
                        }
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Verificar colunas
        for (int j = 0; j < tamanhoTabuleiro; j++) {
            int count = 0;
            for (int i = 0; i < tamanhoTabuleiro; i++) {
                if (tabuleiro.celula[i][j] == cor) {
                    count++;
                    if (count == 4) {
                        for (int k = i - 3; k <= i; k++) {
                            tabuleiro.celula[k][j] = marcaVitoria;
                        }
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Verificar diagonais \
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
                        tabuleiro.celula[i + k][j + k] = marcaVitoria;
                    }
                    return true;
                }
            }
        }

        // Verificar diagonais /
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
                        tabuleiro.celula[i - k][j + k] = marcaVitoria;
                    }
                    return true;
                }
            }
        }

        return false;

    }
}

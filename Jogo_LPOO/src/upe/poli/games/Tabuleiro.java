package upe.poli.games;

public class Tabuleiro {
    private int tamanho;
    int [][] celula;

    public Tabuleiro (int tamanho) {
        this.tamanho= tamanho;
        celula = new int [tamanho][tamanho];
        for (int i=0; i<tamanho;i++) {
            for(int j=0; j<tamanho;j++) {
                celula[i][j] = 0;
            }
        }
    }
    public void printTabuleiro() {
        System.out.print("  ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();

        for (int i = 0; i < tamanho; i++) {
            System.out.print((char) ('|') + " ");
            for (int j = 0; j < tamanho; j++) {
                if (celula[i][j] == 'X') {
                    System.out.print("X   ");
                } else if (celula[i][j] == 'Y') {
                    System.out.print("Y   ");
                } else if(celula[i][j] == 0){
                    System.out.print("  ");
                }
                else if(celula[i][j] == 'Z' ) { //peças vencedoras X
                    System.out.print("(X) ");
                }
                else if(celula[i][j] == 'W' ) { //peças vencedoras Y
                    System.out.print("(Y) ");
                }
            }
            System.out.println();
        }
        System.out.println("\u001B[0m");
    }

    public int[][] getCelula() {
        return celula;
    }
}
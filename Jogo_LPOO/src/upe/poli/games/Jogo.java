package upe.poli.games;

import java.util.Scanner;
public class Jogo {
    private Jogador jogador1;
    private Jogador jogador2;
    private int tamanhoTabuleiro;
    private Tabuleiro tabuleiro;

    public Jogo(Jogador jogador1, Jogador jogador2, int tamanhoTabuleiro) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tamanhoTabuleiro = tamanhoTabuleiro;
        this.tabuleiro = new Tabuleiro(tamanhoTabuleiro);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int jogadas = 0;
        boolean jogoFinalizado = false;

        while (!jogoFinalizado) {
            System.out.println("=== Vez do jogador: " + jogador1.getNome() + "  | Cor: " + jogador1.getCor() +  " ===");

            boolean jogadaValida = false;
            do {
                tabuleiro.printTabuleiro(); // Imprimir o tabuleiro aqui

                System.out.print("Informe a coluna onde deseja jogar (0-" + (tamanhoTabuleiro - 1) + "): ");
                int coluna = scanner.nextInt();

                if (jogador1.verificarDisponibilidade(coluna, jogador1.getCor(), tamanhoTabuleiro, tabuleiro)) {
                    jogadaValida = true; // Atualizado para true
                    jogadas++;

                    if (Vitoria.jogadorVenceu(tabuleiro, jogador1, tamanhoTabuleiro)) {
                        System.out.println("Parabéns, " + jogador1.getNome() + "! Você venceu!");
                        jogoFinalizado = true;
                        tabuleiro.printTabuleiro();
                    } else if (jogadas == tamanhoTabuleiro * tamanhoTabuleiro) {
                        System.out.println("O jogo terminou em empate!");
                        jogoFinalizado = true;
                        tabuleiro.printTabuleiro();
                    }
                } else {
                    System.out.println("Posição inválida, tente novamente.");
                }
            } while (!jogadaValida);

            Jogador atual = jogador1;
            jogador1 = jogador2;
            jogador2 = atual;
        }
    }
}
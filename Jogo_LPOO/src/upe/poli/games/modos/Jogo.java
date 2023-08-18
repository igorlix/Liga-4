package upe.poli.games.modos;

import upe.poli.games.Jogador;
import upe.poli.games.Tabuleiro;
import upe.poli.games.Vitoria;

import java.util.Scanner;
public class Jogo implements Modo {
    protected Jogador jogador1;
    protected Jogador jogador2;
    protected int tamanhoTabuleiro;
    protected Tabuleiro tabuleiro;

    public Jogo(Jogador jogador1, Jogador jogador2, int tamanhoTabuleiro) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tamanhoTabuleiro = tamanhoTabuleiro;
        this.tabuleiro = new Tabuleiro(tamanhoTabuleiro);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean jogoFinalizado = false;

        while (!jogoFinalizado) {
            System.out.println("=== Vez do jogador: " + jogador1.getNome() + "  | Cor: " + jogador1.getCor() +  " ===");

            boolean jogadaValida = false;
            do {
                tabuleiro.printTabuleiro(); // Imprimir o tabuleiro aqui

                System.out.print("Informe a coluna onde deseja jogar (0-" + (tamanhoTabuleiro - 1) + "): ");
                int coluna = scanner.nextInt();

                if (verificarDisponibilidade(coluna, jogador1.getCor())) {
                    jogadaValida = true; // Atualizado para true
                    int jogadas = jogador1.getJogadas();
                    jogadas++;
                    jogador1.setJogadas(jogadas);

                    if (Vitoria.jogadorVenceu(tabuleiro, jogador1, tamanhoTabuleiro)) {
                        System.out.println("Parabéns, " + jogador1.getNome() + "! Você venceu em " + jogador1.getJogadas() + " rodadas!");
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
    public boolean verificarDisponibilidade(int coluna, char cor) {
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
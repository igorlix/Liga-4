package upe.poli.games.main;

import upe.poli.games.Jogador;
import upe.poli.games.modos.Jogo;
import upe.poli.games.modos.JogoTurbo;
import upe.poli.games.modos.JogoTurboMaluco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tamanhoTabuleiro = 0;
        boolean tamanhoValido = false;

        do {
            System.out.print("Informe o tamanho do tabuleiro (Entre 4 e 10): ");
            String input = scanner.nextLine();

            if (isInteger(input)) {
                tamanhoTabuleiro = Integer.parseInt(input);

                if (tamanhoTabuleiro >= 4 && tamanhoTabuleiro <= 10) {
                    tamanhoValido = true;
                } else {
                    System.out.println("Tamanho fora do intervalo permitido.");
                }
            } else {
                System.out.println("Entrada inválida. Insira um número inteiro.");
            }
        } while (!tamanhoValido);

        System.out.print("Informe o nome do jogador 1: ");
        String nomeJogador1 = scanner.nextLine();

        System.out.print("Informe o nome do jogador 2: ");
        String nomeJogador2 = scanner.nextLine();



        Jogador jogador1 = new Jogador(nomeJogador1, 'X');
        Jogador jogador2 = new Jogador(nomeJogador2, 'Y');
        Jogo jogo = new Jogo(jogador1, jogador2, tamanhoTabuleiro);
        JogoTurbo jogoTurbo = new JogoTurbo(jogador1, jogador2, tamanhoTabuleiro);
        JogoTurboMaluco jogoTurboMaluco = new JogoTurboMaluco(jogador1, jogador2, tamanhoTabuleiro);


        System.out.println("Selecione o modo de jogo: ");
        System.out.println("(1) Modo Clássico");
        System.out.println("(2) Modo Turbo");
        System.out.println("(3) Modo Turbo Maluco");
        int modo = scanner.nextInt();
        switch (modo){
            case 1:
                System.out.println("! Modo Clássico !");
                jogo.start();
                break;
            case 2:
                System.out.println("! Modo Turbo !");
                jogoTurbo.start();
                break;

            case 3:
                System.out.println("! Modo Turbo Maluco !");
                jogoTurboMaluco.start();
                break;

        }

        scanner.close();
    }
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

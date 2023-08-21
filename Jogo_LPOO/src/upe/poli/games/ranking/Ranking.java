package upe.poli.games.ranking;

import java.io.*;
import java.util.*;

public class Ranking {
    private Map<String, Integer> classicRanking;
    private Map<String, Integer> turboRanking;
    private Map<String, Integer> turboCrazyRanking;

    public Ranking() {
        classicRanking = new HashMap<>();
        turboRanking = new HashMap<>();
        turboCrazyRanking = new HashMap<>();
        carregarRanking();
    }

    public void adicionarVitoria(String jogador, int jogadas, String modo) {
        if (modo.equalsIgnoreCase("Clássico")) {
            classicRanking.put(jogador, jogadas);
        } else if (modo.equalsIgnoreCase("Turbo")) {
            turboRanking.put(jogador, jogadas);
        } else if (modo.equalsIgnoreCase("Turbo Maluco")) {
            turboCrazyRanking.put(jogador, jogadas);
        }
    }
    public int getPosicao(String jogador, String modo) {
        Map<String, Integer> rankingMap = getRankingMap(modo);
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(rankingMap.entrySet());
        Collections.sort(sortedEntries, (entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()));

        int posicao = 1;
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            if (entry.getKey().equals(jogador)) {
                return posicao;
            }
            posicao++;
        }
        return -1;
    }

    private Map<String, Integer> getRankingMap(String modo) {
        if (modo.equalsIgnoreCase("Clássico")) {
            return classicRanking;
        } else if (modo.equalsIgnoreCase("Turbo")) {
            return turboRanking;
        } else if (modo.equalsIgnoreCase("Turbo Maluco")) {
            return turboCrazyRanking;
        }
        return null;
    }

    private void carregarRanking() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("ranking.txt"), "UTF-8"))) {
            String linha;
            String modo = null;
            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("Modo")) {
                    modo = linha.substring(5).trim();
                } else {
                    String[] partes = linha.split("-");
                    if (partes.length == 2) {
                        String jogador = partes[0].trim();
                        int jogadas = Integer.parseInt(partes[1].split(" ")[1]);
                        adicionarVitoria(jogador, jogadas, modo);
                    }
                }
            }
        } catch (IOException e) {
        }
    }

    public void salvarRanking() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ranking.txt"))) {
            salvarRanking(writer, "Modo Clássico", classicRanking);
            salvarRanking(writer, "Modo Turbo", turboRanking);
            salvarRanking(writer, "Modo Turbo Maluco", turboCrazyRanking);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void salvarRanking(BufferedWriter writer, String modo, Map<String, Integer> ranking) throws IOException {
        writer.write(modo + "\n");
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(ranking.entrySet());
        sortedEntries.sort((entry1, entry2) -> {
            int comparison = entry2.getValue().compareTo(entry1.getValue());
            return comparison != 0 ? comparison : entry1.getKey().compareTo(entry2.getKey());
        });

        int posicao = 1;

        for (int i = 0; i < sortedEntries.size(); i++) {
            Map.Entry<String, Integer> entry = sortedEntries.get(i);

            if (i > 0 && entry.getValue() != sortedEntries.get(i - 1).getValue()) {
                posicao = i + 1;
            }

            // Verificar se é o mesmo jogador do que o anterior
            if (i > 0 && entry.getKey().equals(sortedEntries.get(i - 1).getKey())) {
                writer.write(posicao - 1 + ". ");
            } else {
                writer.write(posicao + ". ");
            }

            writer.write(entry.getKey() + " - " + entry.getValue() + " jogadas\n");
            posicao++;
        }

        writer.write("\n");
    }


}

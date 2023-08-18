package upe.poli.games.modos;

public interface Modo {
    public void start();

    public boolean verificarDisponibilidade(int coluna, char cor);
}

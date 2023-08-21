package upe.poli.games.modos;

import upe.poli.games.Jogador;
import upe.poli.games.Tabuleiro;
import upe.poli.games.Vitoria;
import upe.poli.games.ranking.Ranking;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class Jogo implements Modo {
    protected Jogador jogador1;
    protected Jogador jogador2;
    protected int tamanhoTabuleiro;
    protected Tabuleiro tabuleiro;
    protected JButton[][] botoesTabuleiro;
    protected boolean jogoFinalizado;
    protected Ranking ranking;


    public Jogo(Jogador jogador1, Jogador jogador2, int tamanhoTabuleiro, Ranking ranking) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tamanhoTabuleiro = tamanhoTabuleiro;
        this.tabuleiro = new Tabuleiro(tamanhoTabuleiro);
        this.ranking = ranking;
        this.jogoFinalizado = false;
    }


    public void start() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Liga 4");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel contentPane = new JPanel(new BorderLayout());
            contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Define a 20-pixel margin
            contentPane.setBackground(new Color(0, 0, 255)); // Set the background color

            // Add an icon label at the top of the contentPane
            ImageIcon icon = new ImageIcon("C:\\Users\\igorl\\Documents\\Java\\Liga-4\\Jogo_LPOO\\src\\upe\\poli\\games\\Imagens\\Lig4.png"); // Make sure the path is correct
            JLabel iconLabel = new JLabel(icon);
            iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            contentPane.add(iconLabel, BorderLayout.NORTH);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(tamanhoTabuleiro, tamanhoTabuleiro));
            panel.setBackground(new Color(0, 0, 255)); // Set the same background color as the contentPane
            int buttonSize = 100;

            botoesTabuleiro = new JButton[tamanhoTabuleiro][tamanhoTabuleiro];
            for (int row = 0; row < tamanhoTabuleiro; row++) {
                for (int col = 0; col < tamanhoTabuleiro; col++) {
                    JButton button = new JButton();
                    button.setPreferredSize(new Dimension(buttonSize, buttonSize));
                    button.setBorder(BorderFactory.createEmptyBorder());
                    button.setContentAreaFilled(false);

                    final int finalCol = col;
                    button.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (!jogoFinalizado) {
                                realizarJogada(finalCol);
                            }
                        }
                    });

                    button.setUI(new EllipseButtonUI());

                    panel.add(button);
                    botoesTabuleiro[row][col] = button;
                }
            }

            contentPane.add(panel, BorderLayout.CENTER);
            frame.setContentPane(contentPane);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    class EllipseButtonUI extends BasicButtonUI {
        @Override
        protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
            g.setFont(new Font("Arial", Font.BOLD, 16)); // Adjust the font size as needed
            super.paintText(g, c, textRect, text);
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            AbstractButton button = (AbstractButton) c;
            Graphics2D g2 = (Graphics2D) g;
            Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, button.getWidth() - 1, button.getHeight() - 1);

            if (button.getModel().isArmed()) {
                g2.setColor(button.getBackground().darker());
            } else {
                g2.setColor(button.getBackground());
            }

            g2.fill(shape);
            super.paint(g2, c);
        }
    }
     private void realizarJogada(int coluna) {
        final int col = coluna;

        if (verificarDisponibilidade(col, jogador1.getCor())) {
            atualizarTabuleiro(coluna);
            if (Vitoria.jogadorVenceu(tabuleiro, jogador1, tamanhoTabuleiro)) {
                mostrarResultado(jogador1);
            } else if (tabuleiroCheio()) {
                mostrarResultado(null);
            } else {
                trocarJogador();
            }
        }
    }

    @Override
    public void atualizarTabuleiro(int col) {
        String modo = "Clássico";
        jogador1.setModo("Clássico");
        for (int row = tamanhoTabuleiro - 1; row >= 0; row--) {
            if (tabuleiro.getCelula()[row][col] == 0) {
                tabuleiro.getCelula()[row][col] = jogador1.getCor();
                updateButtonAppearance(row, col, jogador1.getCor());
                int jogadas = jogador1.getJogadas();
                jogadas++;
                jogador1.setJogadas(jogadas);
                break;
            }
        }
    }

    protected void updateButtonAppearance(int row, int col, int cor) {
        Color buttonColor;

        if (cor == 1) {
            buttonColor = Color.RED;
        } else if (cor == 2) {
            buttonColor = Color.YELLOW;
        } else {
            buttonColor = Color.WHITE;
        }

        botoesTabuleiro[row][col].setBackground(buttonColor);
        botoesTabuleiro[row][col].setEnabled(false);
    }



    private boolean tabuleiroCheio() {
        for (int col = 0; col < tamanhoTabuleiro; col++) {
            if (tabuleiro.getCelula()[0][col] == 0) {
                return false;
            }
        }
        return true;
    }

    private void trocarJogador() {
        Jogador temp = jogador1;
        jogador1 = jogador2;
        jogador2 = temp;
    }

    private void mostrarResultado(Jogador vencedor) {
        jogoFinalizado = true;
        if (vencedor != null) {
            ranking.adicionarVitoria(vencedor.getNome(), vencedor.getJogadas(), vencedor.getModo());
            ranking.salvarRanking();
            int posicao = ranking.getPosicao(vencedor.getNome(), vencedor.getModo());
            JOptionPane.showMessageDialog(null, "Parabéns, (" + vencedor.getNome() + "). Você venceu em (" + vencedor.getJogadas() + ") jogadas no Modo (" + vencedor.getModo()+ ") !" + "Sua posição no ranking é: #" + posicao);

        } else {
            JOptionPane.showMessageDialog(null, "O jogo terminou em empate!");
        }
    }


    public boolean verificarDisponibilidade(int coluna, int cor) {
        if (coluna < 0 || coluna >= tamanhoTabuleiro) {
            return false;
        }

        for (int row = tamanhoTabuleiro - 1; row >= 0; row--) {
            if (tabuleiro.getCelula()[row][coluna] == 0) {
                return true;
            }
        }
        return false;
    }
}

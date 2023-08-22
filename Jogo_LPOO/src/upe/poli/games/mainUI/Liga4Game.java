package upe.poli.games.mainUI;

import upe.poli.games.Jogador;
import upe.poli.games.modos.Jogo;
import upe.poli.games.modos.JogoTurbo;
import upe.poli.games.modos.JogoTurboMaluco;
import upe.poli.games.ranking.Ranking;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Liga4Game {
    private JFrame frame;
    private JPanel panel;
    private JLabel tamanhoTabuleiroLabel;
    private JTextField nomeJogador1Field;
    private JTextField nomeJogador2Field;
    private int tamanhoTabuleiro = 4;
    private Ranking ranking;

    public Liga4Game() {
        setupGameScreen();
        setApplicationIcon();
        ranking = new Ranking();
    }
    private void setApplicationIcon() {
        ImageIcon appIcon = new ImageIcon("C:\\Users\\igorl\\Documents\\Java\\Liga-4\\Jogo_LPOO\\src\\upe\\poli\\games\\Imagens\\icon (2).png");
        frame.setIconImage(appIcon.getImage());
    }

    private void setupGameScreen() {
        frame = new JFrame("Liga 4 - Tela Inicial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 800);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(0, 0, 255)); //////////////


        ImageIcon logoIcon = new ImageIcon("C:\\Users\\igorl\\Documents\\Java\\Liga-4\\Jogo_LPOO\\src\\upe\\poli\\games\\Imagens\\Lig4.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoLabel.setBorder(new EmptyBorder(20, 40, 20, 40));
        panel.add(logoLabel);


        JPanel tamanhoTabuleiroPanel = new JPanel();
        tamanhoTabuleiroPanel.setBackground(Color.BLUE);


        FlowLayout tamanhoTabuleiroLayout = new FlowLayout(FlowLayout.CENTER, 10, 5);
        tamanhoTabuleiroPanel.setLayout(tamanhoTabuleiroLayout);

        tamanhoTabuleiroLabel = new JLabel(new ImageIcon("C:\\Users\\igorl\\Documents\\Java\\Liga-4\\Jogo_LPOO\\src\\upe\\poli\\games\\Imagens\\tamanho (2).png"));
        tamanhoTabuleiroLabel.setText(String.valueOf(tamanhoTabuleiro));
        tamanhoTabuleiroLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        tamanhoTabuleiroLabel.setForeground(Color.WHITE);
        tamanhoTabuleiroPanel.add(tamanhoTabuleiroLabel);

        JButton decreaseButton = createImageButton(
                "C:\\Users\\igorl\\Documents\\Java\\Liga-4\\Jogo_LPOO\\src\\upe\\poli\\games\\Imagens\\-.png"
        );
        JButton increaseButton = createImageButton(
                "C:\\Users\\igorl\\Documents\\Java\\Liga-4\\Jogo_LPOO\\src\\upe\\poli\\games\\Imagens\\+.png"
        );


        tamanhoTabuleiroPanel.add(decreaseButton);
        tamanhoTabuleiroPanel.add(increaseButton);




        tamanhoTabuleiroPanel.add(decreaseButton);
        tamanhoTabuleiroPanel.add(increaseButton);

        tamanhoTabuleiroPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tamanhoTabuleiroPanel);

        nomeJogador1Field = new JTextField();
        nomeJogador1Field.setPreferredSize(new Dimension(300, 40));
        nomeJogador1Field.setBackground(Color.BLUE);
        nomeJogador1Field.setForeground(Color.WHITE);
        nomeJogador1Field.setFont(new Font("Arial", Font.BOLD, 32));
        nomeJogador1Field.setHorizontalAlignment(JTextField.CENTER);

        nomeJogador2Field = new JTextField();
        nomeJogador2Field.setPreferredSize(new Dimension(300, 40));
        nomeJogador2Field.setBackground(Color.BLUE);
        nomeJogador2Field.setForeground(Color.WHITE);
        nomeJogador2Field.setFont(new Font("Arial", Font.BOLD, 32));
        nomeJogador2Field.setHorizontalAlignment(JTextField.CENTER);

        panel.add(Box.createVerticalStrut(20));

        JLabel jogador1Label = new JLabel(new ImageIcon("C:\\Users\\igorl\\Documents\\Java\\Liga-4\\Jogo_LPOO\\src\\upe\\poli\\games\\Imagens\\nome1.png"));
        jogador1Label.setForeground(Color.WHITE);
        jogador1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        jogador1Label.setFont(new Font("Arial", Font.PLAIN, 32));


        JPanel jogador1Panel = new JPanel();
        jogador1Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        jogador1Panel.setBackground(new Color(0, 0, 255));
        jogador1Panel.add(jogador1Label);
        jogador1Panel.add(nomeJogador1Field);

        panel.add(jogador1Panel);

        JLabel jogador2Label = new JLabel(new ImageIcon("C:\\Users\\igorl\\Documents\\Java\\Liga-4\\Jogo_LPOO\\src\\upe\\poli\\games\\Imagens\\nome2.png"));
        jogador2Label.setForeground(Color.WHITE);
        jogador2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        jogador2Label.setFont(new Font("Arial", Font.PLAIN, 32));


        JPanel jogador2Panel = new JPanel();
        jogador2Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        jogador2Panel.setBackground(new Color(0, 0, 255));
        jogador2Panel.add(jogador2Label);
        jogador2Panel.add(nomeJogador2Field);

        panel.add(jogador2Panel);

        JPanel modePanel = new JPanel();
        modePanel.setBackground(new Color(0, 0, 255));
        modePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 10, 0);


        JRadioButton classicModeButton = createRadioButton(
                "C:\\Users\\igorl\\Documents\\Java\\Liga-4\\Jogo_LPOO\\src\\upe\\poli\\games\\Imagens\\classico (2).png",
                "C:\\Users\\igorl\\Documents\\Java\\Liga-4\\Jogo_LPOO\\src\\upe\\poli\\games\\Imagens\\classico_select.png"
        );
        JRadioButton turboModeButton = createRadioButton(
                "C:\\Users\\igorl\\Documents\\Java\\Liga-4\\Jogo_LPOO\\src\\upe\\poli\\games\\Imagens\\turbo (2).png",
                "C:\\Users\\igorl\\Documents\\Java\\Liga-4\\Jogo_LPOO\\src\\upe\\poli\\games\\Imagens\\turbo_select.png"
        );
        JRadioButton turboCrazyModeButton = createRadioButton(
                "C:\\Users\\igorl\\Documents\\Java\\Liga-4\\Jogo_LPOO\\src\\upe\\poli\\games\\Imagens\\maluco.png",
                "C:\\Users\\igorl\\Documents\\Java\\Liga-4\\Jogo_LPOO\\src\\upe\\poli\\games\\Imagens\\maluco_select.png"
        );


        ButtonGroup modeButtonGroup = new ButtonGroup();
        modeButtonGroup.add(classicModeButton);
        modeButtonGroup.add(turboModeButton);
        modeButtonGroup.add(turboCrazyModeButton);

        modePanel.add(classicModeButton, gbc);
        modePanel.add(turboModeButton, gbc);
        modePanel.add(turboCrazyModeButton, gbc);


        panel.add(modePanel);


        JButton startButton = new JButton(new ImageIcon("C:\\Users\\igorl\\Documents\\Java\\Liga-4\\Jogo_LPOO\\src\\upe\\poli\\games\\Imagens\\Iniciar.png"));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.addActionListener(e -> {
            String nomeJogador1 = nomeJogador1Field.getText();
            String nomeJogador2 = nomeJogador2Field.getText();

            if (nomeJogador1.isEmpty() || nomeJogador2.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Digite os nomes de ambos os jogadores.");
                return;
            }

            int selectedSize = tamanhoTabuleiro;
            int selectedMode = 0;

            if (classicModeButton.isSelected()) {
                selectedMode = 1;
            } else if (turboModeButton.isSelected()) {
                selectedMode = 2;
            } else if (turboCrazyModeButton.isSelected()) {
                selectedMode = 3;
            }

            Jogador jogador1 = new Jogador(nomeJogador1, 1);
            Jogador jogador2 = new Jogador(nomeJogador2, 2);
            Jogo jogo = new Jogo(jogador1, jogador2, selectedSize, ranking);
             JogoTurbo jogoTurbo = new JogoTurbo(jogador1, jogador2, selectedSize, ranking);
            JogoTurboMaluco jogoTurboMaluco = new JogoTurboMaluco(jogador1, jogador2, selectedSize, ranking);


            switch (selectedMode) {
                case 1:
                    System.out.println("! Modo Clássico !");
                    jogo.start();
                    frame.dispose();
                    break;
                case 2:
                    System.out.println("! Modo Turbo !");
                    jogoTurbo.start();
                    frame.dispose();
                    break;
                case 3:
                    System.out.println("! Modo Turbo Maluco !");
                    jogoTurboMaluco.start();
                    frame.dispose();
                    break;
            }


        });

        panel.add(Box.createVerticalStrut(0));
        panel.add(startButton);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        increaseButton.addActionListener(e -> {
            if (tamanhoTabuleiro < 10) {
                tamanhoTabuleiro++;
                tamanhoTabuleiroLabel.setText(String.valueOf(tamanhoTabuleiro));
            }
        });

        decreaseButton.addActionListener(e -> {
            if (tamanhoTabuleiro > 4) {
                tamanhoTabuleiro--;
                tamanhoTabuleiroLabel.setText(String.valueOf(tamanhoTabuleiro));
            }
        });
    }

    private JButton createImageButton(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JButton imageButton = new JButton(imageIcon);
        imageButton.setContentAreaFilled(false);
        imageButton.setBorderPainted(false);
        imageButton.setFocusPainted(false);
        imageButton.setFocusable(false);
        imageButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        return imageButton;
    }


    private JRadioButton createRadioButton(String defaultImagePath, String selectedImagePath) {
        ImageIcon defaultIcon = new ImageIcon(defaultImagePath);
        ImageIcon selectedIcon = new ImageIcon(selectedImagePath);
        JRadioButton radioButton = new JRadioButton(defaultIcon);
        radioButton.setContentAreaFilled(false);
        radioButton.setBorderPainted(false);
        radioButton.setFocusPainted(false);
        radioButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        radioButton.setSelectedIcon(selectedIcon);

        return radioButton;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Liga4Game());
    }
}
package risk;

import java.awt.*;

import javax.swing.*;

public class GUI {

    ImageIcon imageIcon;
    Icon icon;
    java.awt.Image temp;

    public void init() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        JFrame frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        imageIcon = new ImageIcon("gui.jpg");
        temp = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        imageIcon.setImage(temp);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0, 0, width, height);

        imageIcon = new ImageIcon("two.png");
        temp = imageIcon.getImage().getScaledInstance(210, 60, Image.SCALE_DEFAULT);
        imageIcon.setImage(temp);
        JButton twoPlayers = new JButton(imageIcon);
        twoPlayers.setContentAreaFilled(false);
        twoPlayers.setFocusPainted(false);
        twoPlayers.setBorderPainted(false);
        twoPlayers.setBounds(150, 290, 210, 60);
        twoPlayers.addActionListener((t) -> {
            frame.setVisible(false);
            frame.removeAll();
            TwoPlayersGame p = new TwoPlayersGame();
            p.init();
        });

        imageIcon = new ImageIcon("three.png");
        temp = imageIcon.getImage().getScaledInstance(210, 60, Image.SCALE_DEFAULT);
        imageIcon.setImage(temp);
        JButton threePlayers = new JButton(imageIcon);
        threePlayers.setContentAreaFilled(false);
        threePlayers.setFocusPainted(false);
        threePlayers.setBorderPainted(false);
        threePlayers.setBounds(150, 350, 210, 60);
        threePlayers.addActionListener((e) -> {
            frame.setVisible(false);
            frame.removeAll();
            ThreePlayersGame three = new ThreePlayersGame();
            three.init();
        });
        imageIcon = new ImageIcon("four.png");
        temp = imageIcon.getImage().getScaledInstance(210, 60, Image.SCALE_DEFAULT);
        imageIcon.setImage(temp);
        JButton fourPlayers = new JButton(imageIcon);
        fourPlayers.setContentAreaFilled(false);
        fourPlayers.setFocusPainted(false);
        fourPlayers.setBorderPainted(false);
        fourPlayers.setBounds(870, 410, 210, 60);
        fourPlayers.addActionListener((e) -> {
            frame.setVisible(false);
            frame.removeAll();
            FourPlayersGame four = new FourPlayersGame();
            four.init();
        });
        imageIcon = new ImageIcon("ex.png");
        temp = imageIcon.getImage().getScaledInstance(210, 60, Image.SCALE_DEFAULT);
        imageIcon.setImage(temp);
        JButton exitButton = new JButton(imageIcon);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.setBorderPainted(false);
        exitButton.setBounds(870, 470, 210, 60);
        exitButton.addActionListener((e) -> {
            switch (JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", null, JOptionPane.YES_NO_OPTION)) {
                case JOptionPane.YES_OPTION:
                    System.exit(0);
            }
        });
        frame.add(twoPlayers);
        frame.add(threePlayers);
        frame.add(fourPlayers);
        frame.add(exitButton);
        frame.add(label);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}

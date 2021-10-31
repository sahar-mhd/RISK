package risk;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level1 extends Levels {

    JButton next1;
    boolean passLevel1 = false;
    boolean passLevel2 = false;
    ActionListener listener1;
    JPanel panel;
    JLabel addSoldierNo;
    JLabel soldiers;

    public void level1(JFrame frame, int noPlayers, Map map,
            Continent Africa, Continent Asia, Continent Europe, Continent America,
            Player[] players, int turn, JLabel set,
            Level2 level2, Level1 level1, Level3 level3) {
        levelSelected = new ImageIcon("wood1.jpg");
        selected = levelSelected.getImage().getScaledInstance(200, 80, Image.SCALE_DEFAULT);
        levelSelected.setImage(selected);
        levelImage = new JLabel(levelSelected);
        levelImage.setBounds(200, (int) screenSize.height - 120, 200, 80);
        frame.add(levelImage);
        Turn = turn;
        ImageIcon image = new ImageIcon("next.png");
        Image temp = image.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        image.setImage(temp);
        next1 = new JButton(image);
        next1.setBounds(400, (int) screenSize.height - 120, 80, 80);
        frame.add(next1);
        if (label != null) {
            frame.remove(label);
        }
        frame.add(whoseTurn(Turn));
        frame.repaint();
        for (int i = 0; i < 6; i++) {
            for (Button currentButton : map.map[i]) {
                if (currentButton != null) {
                    for (ActionListener al : currentButton.getActionListeners()) {
                        currentButton.removeActionListener(al);
                    }
                }
            }
        }
        //set soldier picture and show number of soldiers can add *************
        panel = new JPanel();
        numberOfSoldiersCanAdd(Africa, Asia, Europe, America, players, turn);
        addSoldierNo = new JLabel();
        addSoldierNo.setForeground(Color.white);
        soldiers = players[turn].picture;
        panel.setBounds((int) screenSize.width - 220,
                (int) screenSize.height - 300, 220, 300);
        panel.add(soldiers);
        panel.add(addSoldierNo, BorderLayout.PAGE_START);
        panel.setOpaque(true);
        panel.setBackground(Color.BLACK);
        frame.add(panel);
        addSoldierNo.setText("I can add "
                + players[turn].getAddSoldier() + " soldier(s)!");
        addSoldierNo.setFont(new Font(null, Font.PLAIN, 20));
        if (players[turn].getAddSoldier() == 0) {
            passLevel1 = true;
        }
        // finished ***********************************************************
        listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Button button = (Button) e.getSource();
                map.name = button.getName();
                if (players[turn].getAddSoldier() > 0) {
                    int i = map.name.charAt(0) - 48;
                    int j = map.name.charAt(1) - 48;
                    if (map.map[i][j].getState().getOwner().getColor().equals(players[turn].getColor())) {
                        map.map[i][j].getState().setSoldierNo(
                                map.map[i][j].getState().getSoldierNo() + 1);
                        players[turn].setSoldierNo(players[turn].getSoldierNo() + 1);
                        map.map[i][j].setText(" "
                                + map.map[i][j].getState().getSoldierNo());
                        players[turn].setAddSoldier(players[turn].getAddSoldier() - 1);
                        addSoldierNo.setText("I can add " + players[turn].getAddSoldier() + " soldier(s)!");
                    }
                }
                if (players[turn].getAddSoldier() == 0) {
                    addSoldierNo.setText("I cannot add soldier!");
                    passLevel1 = true;
                }
            }
        };
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (map.map[i][j] != null) {
                    map.map[i][j].addActionListener(listener1);
                }
            }
        }
        next1.addActionListener((e) -> {
            if (passLevel1) {
                for (int i = 0; i < 6; i++) {
                    for (Button currentButton : map.map[i]) {
                        if (currentButton != null) {
                            for (ActionListener al : currentButton.getActionListeners()) {
                                currentButton.removeActionListener(al);
                            }
                        }
                    }
                }
                frame.remove(panel);
                frame.repaint();
                passLevel1 = false;
                passLevel2 = true;
                frame.remove(levelImage);
                frame.remove(next1);
                level2.level2(frame, noPlayers, map, players, Turn, set, passLevel2,
                        Africa, Asia, Europe, America, level1, level2, level3);
            }
        }
        );
    }
}

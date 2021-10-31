package risk;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Level3 extends Levels {

    boolean is;
    int x1, x2, y1, y2;
    int[][] copy;
    ActionListener listener31, listener3;
    Button b2;
    Player[] player;
    boolean passLevel3;
    JButton next3;
    int setN = 1;

    public void isAWayToX2Y2(int a1, int b1, int a2, int b2, Player[] players, int turn) {
        if (a1 == a2 && b1 == b2) {
            is = true;
            return;
        }
        if (!is && a1 - 1 >= 0 && copy[a1 - 1][b1] == players[turn].getNumber()) {
            copy[a1 - 1][b1] = 0;
            isAWayToX2Y2(a1 - 1, b1, a2, b2, players, turn);
        }
        if (!is && a1 + 1 < 6 && copy[a1 + 1][b1] == players[turn].getNumber()) {
            copy[a1 + 1][b1] = 0;
            isAWayToX2Y2(a1 + 1, b1, a2, b2, players, turn);
        }
        if (!is && b1 - 1 >= 0 && copy[a1][b1 - 1] == players[turn].getNumber()) {
            copy[a1][b1 - 1] = 0;
            isAWayToX2Y2(a1, b1 - 1, a2, b2, players, turn);
        }
        if (!is && b1 + 1 < 7 && copy[a1][b1 + 1] == players[turn].getNumber()) {
            copy[a1][b1 + 1] = 0;
            isAWayToX2Y2(a1, b1 + 1, a2, b2, players, turn);
        }
    }

    public void level3(JFrame frame, int noPlayers, Map map, Player[] players,
            int turn, JLabel set, boolean passLevelThree,
            Continent Africa, Continent Asia, Continent Europe, Continent America,
            Level1 level1, Level2 level2, Level3 level3) {
        levelSelected = new ImageIcon("wood3.jpg");
        selected = levelSelected.getImage().getScaledInstance(200, 80, Image.SCALE_DEFAULT);
        levelSelected.setImage(selected);
        levelImage = new JLabel(levelSelected);
        levelImage.setBounds(760, (int) screenSize.height - 120, 200, 80);
        frame.add(levelImage);
        ImageIcon image = new ImageIcon("next.png");
        Image temp = image.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        image.setImage(temp);
        next3 = new JButton(image);
        next3.setBounds(960, (int) screenSize.height - 120, 80, 80);
        frame.add(next3);
        passLevel3 = passLevelThree;
        player = players;
        Turn = turn;
        listener31 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b2 = (Button) e.getSource();
                if (b2.getState().getOwner().getColor().equals(player[Turn].getColor())) {
                    x2 = b2.getName().charAt(0) - 48;
                    y2 = b2.getName().charAt(1) - 48;
                    copy = new int[6][7];
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 7; j++) {
                            if (map.map[i][j] == null) {
                                copy[i][j] = 0;
                            } else {
                                copy[i][j] = map.map[i][j].getState().getOwner().getNumber();
                            }
                        }
                    }
                    is = false;
                    isAWayToX2Y2(x1, y1, x2, y2, player, Turn);
                    if (is) {
                        map.map[x1][y1].getState().setSoldierNo(
                                map.map[x1][y1].getState().getSoldierNo() - 1);
                        map.map[x1][y1].setText(" " + map.map[x1][y1]
                                .getState().getSoldierNo());
                        map.map[x2][y2].getState().setSoldierNo(
                                map.map[x2][y2].getState().getSoldierNo() + 1);
                        map.map[x2][y2].setText(" " + map.map[x2][y2]
                                .getState().getSoldierNo());
                    }
                    for (int l = 0; l < 6; l++) {
                        for (int m = 0; m < 7; m++) {
                            if (map.map[l][m] != null) {
                                map.map[l][m].removeActionListener(listener31);
                                map.map[l][m].addActionListener(listener3);
                            }
                        }
                    }
                }
            }

        };
        listener3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Button b1 = (Button) e.getSource();
                if (b1.getState().getOwner().getColor().equals(player[Turn].getColor())
                        && b1.getState().getSoldierNo() > 1) {
                    x1 = b1.getName().charAt(0) - 48;
                    y1 = b1.getName().charAt(1) - 48;
                    for (int l = 0; l < 6; l++) {
                        for (int m = 0; m < 7; m++) {
                            if (map.map[l][m] != null) {
                                map.map[l][m].removeActionListener(listener3);
                                map.map[l][m].addActionListener(listener31);
                            }
                        }
                    }
                }
            }
        };
        for (int v = 0; v < 6; v++) {
            for (int m = 0; m < 7; m++) {
                if (map.map[v][m] != null) {
                    map.map[v][m].addActionListener(listener3);
                }
            }
        }
        next3.addActionListener((e) -> {
            if (passLevel3) {
                switch (JOptionPane.showConfirmDialog(frame,
                        "This is the last level! Do you want to continue?",
                        null, JOptionPane.YES_NO_OPTION)) {
                    case JOptionPane.YES_OPTION:
                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j < 7; j++) {
                                if (map.map[i][j] != null) {
                                    map.map[i][j].removeActionListener(listener3);
                                }
                            }
                        }
                        if (Turn == noPlayers - 1) {
                            setN++;
                            set.setText("set : " + setN);
                            set.setForeground(Color.white);
                        }
                        Turn = (Turn + 1) % noPlayers;
                        passLevel3 = false;
                        frame.remove(levelImage);
                        frame.remove(next3);
                        level1.level1(frame, noPlayers, map, Africa,
                                Asia, Europe, America, players, Turn, set, level2, level1, level3);
                }
            }
        });
    }
}

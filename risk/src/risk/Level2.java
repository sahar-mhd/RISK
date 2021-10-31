package risk;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.*;

public class Level2 extends Levels {

    JLabel addSoldierNo, dice1, dice2, dice3, dice4, dice5, dice6;
    int i, j, g, h;
    JLabel[] diceNo = new JLabel[7];
    int[] info = new int[10];
    State origin = new State(), destination = new State();
    ActionListener listener2, listener25, N;
    boolean passLevel2, passLevel3 = false;
    JButton next2;
    JLabel q;
    JTextField n;
    String text = new String();
    JLabel[] crowns;
    JPanel playerList;
    int numberP;
    Player lost;

    public Level2(JLabel[] crowns, JPanel playerList) {
        this.crowns = crowns;
        this.playerList = playerList;
    }

    public JLabel Dice(int no) {
        ImageIcon image = new ImageIcon("dice1.jpg");
        Image temp = image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        image.setImage(temp);
        dice1 = new JLabel(image);
        image = new ImageIcon("dice2.jpg");
        temp = image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        image.setImage(temp);
        dice2 = new JLabel(image);
        image = new ImageIcon("dice3.jpg");
        temp = image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        image.setImage(temp);
        dice3 = new JLabel(image);
        image = new ImageIcon("dice4.jpg");
        temp = image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        image.setImage(temp);
        dice4 = new JLabel(image);
        image = new ImageIcon("dice5.jpg");
        temp = image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        image.setImage(temp);
        dice5 = new JLabel(image);
        image = new ImageIcon("dice6.jpg");
        temp = image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        image.setImage(temp);
        dice6 = new JLabel(image);
        switch (no) {
            case 1:
                return dice1;
            case 2:
                return dice2;
            case 3:
                return dice3;
            case 4:
                return dice4;
            case 5:
                return dice5;
            default:
                return dice6;
        }
    }

    public void reverse(int[] array) {
        int i = 0, j = array.length - 1, tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    public int[] attack(int s1S, int s2S) {
        int[] info = new int[10];
        Random r = new Random();
        int R;
        int offensiveSoldiers;
        int defensiveSoldiers;
        if (s1S > 3) {
            offensiveSoldiers = 3;
        } else {
            offensiveSoldiers = s1S - 1;
        }
        if (s2S > 1) {
            defensiveSoldiers = 2;
        } else {
            defensiveSoldiers = 1;
        }
        int[] offensive = new int[offensiveSoldiers];
        int[] defensive = new int[defensiveSoldiers];
        for (int k = 0; k < offensive.length; k++) {
            R = r.nextInt();
            if (R < 0) {
                R *= -1;
            }
            offensive[k] = R % 6;
        }
        for (int k = 0; k < defensive.length; k++) {
            R = r.nextInt();
            if (R < 0) {
                R *= -1;
            }
            defensive[k] = R % 6;
        }
        Arrays.sort(offensive);
        reverse(offensive);
        Arrays.sort(defensive);
        reverse(defensive);
        for (int k = 0; k < offensive.length; k++) {
            info[5 + k] = offensive[k] + 1;
        }
        for (int k = 0; k < defensive.length; k++) {
            info[8 + k] = defensive[k] + 1;
        }
        for (int k = 0; k < offensive.length && k < defensive.length; k++) {
            if (offensive[k] > defensive[k]) {
                s2S--;
                info[1]++;
            } else {
                s1S--;
                info[0]++;
            }
        }
        if (!(s2S > 0)) {
            s2S = offensiveSoldiers;
            s1S -= offensiveSoldiers;
            info[4] = 1;
        }
        info[2] = s1S;
        info[3] = s2S;
        return info;
    }

    public void level2(JFrame frame, int noPlayers, Map map, Player[] players, int turn,
            JLabel set, boolean passLevel2c,
            Continent Africa, Continent Asia, Continent Europe, Continent America,
            Level1 level1, Level2 level2, Level3 level3) {
        numberP = noPlayers;
        levelSelected = new ImageIcon("wood2.jpg");
        selected = levelSelected.getImage().getScaledInstance(200, 80, Image.SCALE_DEFAULT);
        levelSelected.setImage(selected);
        levelImage = new JLabel(levelSelected);
        levelImage.setBounds(480, (int) screenSize.height - 120, 200, 80);
        frame.add(levelImage);
        Turn = turn;
        ImageIcon image = new ImageIcon("next.png");
        Image temp = image.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        image.setImage(temp);
        next2 = new JButton(image);
        next2.setBounds(680, (int) screenSize.height - 120, 80, 80);
        frame.add(next2);
        frame.repaint();
        this.passLevel2 = passLevel2c;
        N = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = n.getText();
                if (info[3] > 1) {
                    if ("1".equals(text)) {
                        map.map[g][h].getState().setSoldierNo(1);
                        map.map[i][j].getState().setSoldierNo(origin.getSoldierNo() + info[3] - 1);
                    } else if ("2".equals(text)) {
                        map.map[g][h].getState().setSoldierNo(2);
                        map.map[i][j].getState().setSoldierNo(origin.getSoldierNo() + info[3] - 2);
                    }
                }
                map.map[i][j].setText(" " + map.map[i][j].getState().getSoldierNo());
                map.map[g][h].setText(" " + map.map[g][h].getState().getSoldierNo());
                n.setText("");
                frame.remove(q);
                frame.remove(n);
                frame.repaint();
            }
        };
        listener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Button button = (Button) e.getSource();
                map.name = button.getName();
                i = map.name.charAt(0) - 48;
                j = map.name.charAt(1) - 48;
                if (map.map[i][j].getState().getOwner().getColor().equals(players[turn].getColor())) {
                    if (map.map[i][j].getState().getSoldierNo() > 1) {
                        origin = map.map[i][j].getState();
                        for (int i = 0; i < 6; i++) {
                            for (Button currentButton : map.map[i]) {
                                if (currentButton != null) {
                                    for (ActionListener al : currentButton.getActionListeners()) {
                                        currentButton.removeActionListener(al);
                                    }
                                }
                            }
                        }
                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j < 7; j++) {
                                if (map.map[i][j] != null) {
                                    map.map[i][j].addActionListener(listener25);
                                }
                            }
                        }
                        for (int q = 0; q < 7; q++) {
                            if (diceNo[q] != null) {
                                frame.remove(diceNo[q]);
                            }
                        }
                        frame.remove(q);
                        frame.remove(n);
                        frame.repaint();
                    }
                }
            }
        };
        listener25 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Button button = (Button) e.getSource();
                map.name = button.getName();
                g = map.name.charAt(0) - 48;
                h = map.name.charAt(1) - 48;
                if ((i == g && j == h + 1) || (i == g && j == h - 1) || (i == g + 1 && j == h) || (i == g - 1 && j == h)) {
                    if (!(map.map[g][h].getState().getOwner().getColor().equals(players[turn].getColor()))) {
                        destination = map.map[g][h].getState();
                        for (int i = 0; i < 6; i++) {
                            for (Button currentButton : map.map[i]) {
                                if (currentButton != null) {
                                    for (ActionListener al : currentButton.getActionListeners()) {
                                        currentButton.removeActionListener(al);
                                    }
                                }
                            }
                        }
                        //info is the information that attack gives
                        //info[0]:No of origin's owner died soldiers
                        //info[1]:No of destination's owner died soldiers
                        //info[2]:No of origin soldiers
                        //info[3]:No of destination soldiers
                        //info[4]=1 if origin got new state
                        info = attack(origin.getSoldierNo(), destination.getSoldierNo());
                        origin.setSoldierNo(info[2]);
                        origin.getOwner().setSoldierNo(origin.getOwner().getSoldierNo() - info[0]);
                        destination.setSoldierNo(info[3]);
                        destination.getOwner().setSoldierNo(origin.getOwner().getSoldierNo() - info[1]);
                        if (info[4] == 1) {
                            destination.getOwner().setStateNo(destination.getOwner().getStateNo() - 1);
                            lost = destination.getOwner();
                            destination.setOwner(origin.getOwner());
                            origin.getOwner().setStateNo(origin.getOwner().getStateNo() + 1);
                            q.setText("how many soldiers in your new state?");
                            for (int l = 1; l <= info[3]; l++) {
                                q.setText(q.getText() + l + " ");
                            }
                            n.addActionListener(N);
                            frame.add(q);
                            frame.add(n);
                            frame.repaint();
                        }
                        map.map[i][j].setState(origin);
                        map.map[g][h].setState(destination);
                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j < 7; j++) {
                                if (map.map[i][j] != null) {
                                    map.map[i][j].addActionListener(listener2);
                                }
                            }
                        }
                        map.map[i][j].setIcon(map.map[i][j].getState().getOwner().icon);
                        map.map[i][j].setText(" " + map.map[i][j].getState().getSoldierNo());
                        map.map[g][h].setIcon(map.map[g][h].getState().getOwner().icon);
                        map.map[g][h].setText(" " + map.map[g][h].getState().getSoldierNo());
                        //info[5]:origin first soldier diceNo
                        //info[6]:origin second soldier diceNo
                        //info[7]:origin third soldier dicNo
                        //info[8]:destination first soldier diceNo
                        //info[9]:destination second soldier diceNo
                        diceNo[5].setBounds(5, 290, 150, 20);
                        diceNo[6].setBounds(100, 290, 200, 20);
                        diceNo[0] = Dice(info[5]);
                        diceNo[0].setBounds(5, 315, 50, 50);
                        if (info[6] != 0) {
                            diceNo[1] = Dice(info[6]);
                            diceNo[1].setBounds(5, 370, 50, 50);
                            if (info[7] != 0) {
                                diceNo[2] = Dice(info[7]);
                                diceNo[2].setBounds(5, 425, 50, 50);
                            } else {
                                diceNo[2] = null;
                            }
                        } else {
                            diceNo[1] = null;
                            diceNo[2] = null;
                        }
                        diceNo[3] = Dice(info[8]);
                        diceNo[3].setBounds(100, 315, 50, 50);
                        if (info[9] != 0) {
                            diceNo[4] = Dice(info[9]);
                            diceNo[4].setBounds(100, 370, 50, 50);
                        } else {
                            diceNo[4] = null;
                        }
                        for (int q = 0; q < 7; q++) {
                            if (diceNo[q] != null) {
                                frame.add(diceNo[q]);
                                frame.repaint();
                            }
                        }
                    } else {
                        for (int i = 0; i < 6; i++) {
                            for (Button currentButton : map.map[i]) {
                                if (currentButton != null) {
                                    for (ActionListener al : currentButton.getActionListeners()) {
                                        currentButton.removeActionListener(al);
                                    }
                                }
                            }
                        }
                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j < 7; j++) {
                                if (map.map[i][j] != null) {
                                    map.map[i][j].addActionListener(listener2);
                                }
                            }
                        }
                    }
                    if (players[turn].isWinner()) {
                        JOptionPane.showMessageDialog(frame,
                                players[turn].getColor() + " won!",
                                null, JOptionPane.OK_OPTION);
                        frame.removeAll();
                        frame.setVisible(false);
                        GUI gui = new GUI();
                        gui.init();
                    }
                    if (lost != null && lost.getStateNo() == 0) {
                        numberP--;
                        players[lost.getNumber() - 1] = null;
                        for (int i = lost.getNumber() - 1; i + 1 < players.length; i++) {
                            players[i] = players[i + 1];
                        }
                        playerList.remove(crowns[lost.getNumber() - 1]);
                        frame.repaint();
                    }
                    lost = null;
                } else {
                    for (int i = 0; i < 6; i++) {
                        for (Button currentButton : map.map[i]) {
                            if (currentButton != null) {
                                for (ActionListener al : currentButton.getActionListeners()) {
                                    currentButton.removeActionListener(al);
                                }
                            }
                        }
                    }
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 7; j++) {
                            if (map.map[i][j] != null) {
                                map.map[i][j].addActionListener(listener2);
                            }
                        }
                    }
                }
            }
        };
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (map.map[i][j] != null) {
                    map.map[i][j].addActionListener(listener2);
                }
            }
        }
        diceNo[5] = new JLabel("You : ");
        diceNo[6] = new JLabel("Competitor : ");
        diceNo[5].setForeground(Color.white);
        diceNo[6].setForeground(Color.white);
        q = new JLabel();
        q.setBounds(500, 5, 400, 30);
        q.setForeground(Color.white);
        n = new JTextField();
        n.setBounds(600, 30, 30, 30);
        next2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passLevel2) {

                    switch (JOptionPane.showConfirmDialog(frame,
                            "Do you want to go to level 3 ?", null, JOptionPane.YES_NO_OPTION)) {
                        case JOptionPane.YES_OPTION:
                            for (int i = 0; i < 6; i++) {
                                for (Button currentButton : map.map[i]) {
                                    if (currentButton != null) {
                                        for (ActionListener al : currentButton.getActionListeners()) {
                                            currentButton.removeActionListener(al);
                                        }
                                    }
                                }
                            }
                            for (int q = 0; q < 7; q++) {
                                if (diceNo[q] != null) {
                                    frame.remove(diceNo[q]);
                                }
                            }
                            frame.remove(q);
                            frame.remove(n);
                            frame.repaint();
                            passLevel2 = false;
                            passLevel3 = true;
                            frame.remove(levelImage);
                            frame.remove(next2);
                            level3.level3(frame, numberP, map, players, Turn, set,
                                    passLevel3, Africa, Asia, Europe, America, level1, level2, level3);
                    }
                }
            }
        });
        frame.add(next2);
    }
}

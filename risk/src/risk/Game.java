package risk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Game {

    boolean firstFinished = false, passLevel1 = false, passLevel2 = false, passLevel3 = false;
    Player p1 = new Player("greenPlayer");
    Player p2 = new Player("redPlayer");
    Player p3 = new Player("bluePlayer");
    Player p4 = new Player("yellowPlayer");
    Player[] players;
    JPanel p;//players' list
    JLabel[] crowns;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame frame = new JFrame();
    Map map = new Map();
    Continent Africa, Asia, Europe, America;
    ImageIcon image = new ImageIcon();
    Image temp;
    JButton next3;
    ActionListener l;
    int turn, sw;
    JPanel panel1;
    Level1 level1;
    Level2 level2;
    Level3 level3;
    JLabel set;

    public void stateSpreader(int noPlayers) {

        Random r = new Random();
        for (int u = 0; u < Africa.getStateNo(); u++) {
            int R = r.nextInt();
            if (R < 0) {
                R *= -1;
            }
            R = (R % noPlayers) + 1;
            int m = 0;
            boolean swi;
            while (m < noPlayers) {
                swi = true;
                if (R == players[m].getNumber()) {
                    if (0 < players[m].getAddState()) {
                        Africa.getState()[u].setOwner(players[m]);
                        players[m].setAddSoldier(players[m].getAddSoldier() - 1);
                        players[m].setSoldierNo(players[m].getSoldierNo() + 1);
                        players[m].setStateNo(players[m].getStateNo() + 1);
                        players[m].setAddState(players[m].getAddState() - 1);
                        break;
                    } else {
                        R = (R % noPlayers) + 1;
                        m = 0;
                        swi = false;
                    }
                }
                if (swi) {
                    m++;
                }
            }
        }
        for (int u = 0; u < Asia.getStateNo(); u++) {
            int R = r.nextInt();
            if (R < 0) {
                R *= -1;
            }
            R = (R % noPlayers) + 1;
            int m = 0;
            boolean swi;
            while (m < noPlayers) {
                swi = true;
                if (R == players[m].getNumber()) {
                    if (0 < players[m].getAddState()) {
                        Asia.getState()[u].setOwner(players[m]);
                        players[m].setAddSoldier(players[m].getAddSoldier() - 1);
                        players[m].setSoldierNo(players[m].getSoldierNo() + 1);
                        players[m].setStateNo(players[m].getStateNo() + 1);
                        players[m].setAddState(players[m].getAddState() - 1);
                        break;
                    } else {
                        R = (R % noPlayers) + 1;
                        m = 0;
                        swi = false;
                    }
                }
                if (swi) {
                    m++;
                }
            }
        }
        for (int u = 0; u < America.getStateNo(); u++) {
            int R = r.nextInt();
            if (R < 0) {
                R *= -1;
            }
            R = (R % noPlayers) + 1;
            int m = 0;
            boolean swi;
            while (m < noPlayers) {
                swi = true;
                if (R == players[m].getNumber()) {
                    if (0 < players[m].getAddState()) {
                        America.getState()[u].setOwner(players[m]);
                        players[m].setAddSoldier(players[m].getAddSoldier() - 1);
                        players[m].setSoldierNo(players[m].getSoldierNo() + 1);
                        players[m].setStateNo(players[m].getStateNo() + 1);
                        players[m].setAddState(players[m].getAddState() - 1);
                        break;
                    } else {
                        R = (R % noPlayers) + 1;
                        m = 0;
                        swi = false;
                    }
                }
                if (swi) {
                    m++;
                }
            }
        }
        for (int u = 0; u < Europe.getStateNo(); u++) {
            int R = r.nextInt();
            if (R < 0) {
                R *= -1;
            }
            R = (R % noPlayers) + 1;
            int m = 0;
            boolean swi;
            while (m < noPlayers) {
                swi = true;
                if (R == players[m].getNumber()) {
                    if (0 < players[m].getAddState()) {
                        Europe.getState()[u].setOwner(players[m]);
                        players[m].setAddSoldier(players[m].getAddSoldier() - 1);
                        players[m].setSoldierNo(players[m].getSoldierNo() + 1);
                        players[m].setStateNo(players[m].getStateNo() + 1);
                        players[m].setAddState(players[m].getAddState() - 1);
                        break;
                    } else {
                        R = (R % noPlayers) + 1;
                        m = 0;
                        swi = false;
                    }
                }
                if (swi) {
                    m++;
                }
            }
        }
    }

    public void makeContinents() {

        Africa = new Continent("Africa", 6);
        Asia = new Continent("Asia", 8);
        Europe = new Continent("Europe", 6);
        America = new Continent("America", 9);

        State[] africa = new State[6];
        State[] asia = new State[8];
        State[] europe = new State[6];
        State[] america = new State[9];

        for (int i = 0; i < Africa.getStateNo(); i++) {
            africa[i] = new State(Asia.getName());
        }
        for (int i = 0; i < Asia.getStateNo(); i++) {
            asia[i] = new State(Asia.getName());
        }
        for (int i = 0; i < Europe.getStateNo(); i++) {
            europe[i] = new State(Europe.getName());
        }
        for (int i = 0; i < America.getStateNo(); i++) {
            america[i] = new State(America.getName());
        }

        Africa.setState(africa);
        Asia.setState(asia);
        Europe.setState(europe);
        America.setState(america);
    }

    public void setStatesForButtons() {
        //america***********************************************
        for (int i = 0; i < 6; i++) {
            map.map[0][i].setState(America.getState()[i]);
            map.map[0][i].setIcon(America.getState()[i].getOwner().icon);
            map.map[0][i].setText(" " + America.getState()[i].getSoldierNo());
            map.map[0][i].setForeground(Color.white);
        }
        for (int i = 0; i < 2; i++) {
            map.map[1][i].setState(America.getState()[i + 6]);
            map.map[1][i].setIcon(America.getState()[i + 6].getOwner().icon);
            map.map[1][i].setText(" " + America.getState()[i + 6].getSoldierNo());
            map.map[1][i].setForeground(Color.white);
        }
        map.map[1][5].setState(America.getState()[8]);
        map.map[1][5].setIcon(America.getState()[8].getOwner().icon);
        map.map[1][5].setText(" " + America.getState()[8].getSoldierNo());
        map.map[1][5].setForeground(Color.white);
        //europe ***********************************************
        for (int i = 0; i < 3; i++) {
            map.map[2][i].setState(Europe.getState()[i]);
            map.map[2][i].setIcon(Europe.getState()[i].getOwner().icon);
            map.map[2][i].setText(" " + Europe.getState()[i].getSoldierNo());
        }
        for (int i = 0; i < 3; i++) {
            map.map[3][i].setState(Europe.getState()[i + 3]);
            map.map[3][i].setIcon(Europe.getState()[i + 3].getOwner().icon);
            map.map[3][i].setText(" " + Europe.getState()[i + 3].getSoldierNo());
        }
        //africa **********************************************
        for (int i = 4; i < 7; i++) {
            map.map[2][i].setState(Africa.getState()[i - 4]);
            map.map[2][i].setIcon(Africa.getState()[i - 4].getOwner().icon);
            map.map[2][i].setText(" " + Africa.getState()[i - 4].getSoldierNo());
        }
        for (int i = 3; i < 6; i++) {
            map.map[3][i].setState(Africa.getState()[i]);
            map.map[3][i].setIcon(Africa.getState()[i].getOwner().icon);
            map.map[3][i].setText(" " + Africa.getState()[i].getSoldierNo());
        }
        //asia ************************************************
        for (int i = 0; i < 4; i++) {
            map.map[4][i].setState(Asia.getState()[i]);
            map.map[4][i].setIcon(Asia.getState()[i].getOwner().icon);
            map.map[4][i].setText(" " + Asia.getState()[i].getSoldierNo());
        }
        for (int i = 0; i < 4; i++) {
            map.map[5][i].setState(Asia.getState()[i + 4]);
            map.map[5][i].setIcon(Asia.getState()[i + 4].getOwner().icon);
            map.map[5][i].setText(" " + Asia.getState()[i + 4].getSoldierNo());
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (map.map[i][j] != null) {
                    map.map[i][j].setName(i + "" + j);
                }
            }
        }

    }

    public void setLevelButtons(int noPlayers) {
        level1 = new Level1();
        level2 = new Level2(crowns, p);
        level3 = new Level3();
        ImageIcon image = new ImageIcon("source.gif");
        Image temp = image.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        image.setImage(temp);
        JLabel labe = new JLabel(image);
        labe.setBounds(0, 75, 75, 75);
        frame.add(labe);
        set = new JLabel("set : 1");
        set.setForeground(Color.white);
        set.setFont(new Font("", Font.PLAIN, 26));
        set.setBounds(80, 75, 200, 75);
        frame.add(set);
        level1.level1(frame, noPlayers, map, Africa, Asia, Europe, America,
                players, turn, set, level2, level1, level3);
    }
    JLabel label;
    JLabel howMany;

    public void firstTurn(int noPlayers) {
        howMany = new JLabel();
        players[turn].picture.setBounds((int) screenSize.width - 150, (int) screenSize.height - 250, 150, 250);
        frame.add(players[turn].picture);
        howMany.setBounds((int) screenSize.width / 2 - 300, (int) screenSize.height - 200, 600, 200);
        howMany.setText("I can add " + players[turn].getAddSoldier() + " soldiers!");
        howMany.setFont(new Font("name", Font.PLAIN, 40));
        howMany.setForeground(Color.white);
        frame.add(howMany);
        if (label != null) {
            frame.remove(label);
        }
        frame.add(whoseTurn(turn));
        frame.repaint();
        l = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Button button = (Button) e.getSource();
                map.name = button.getName();
                if (label != null) {
                    frame.remove(label);
                }
                if (players[turn].getAddSoldier() > 0) {
                    int i = map.name.charAt(0) - 48;
                    int j = map.name.charAt(1) - 48;
                    if (map.map[i][j].getState().getOwner().getColor().equals(players[turn].getColor())) {
                        map.map[i][j].getState().setSoldierNo(
                                map.map[i][j].getState().getSoldierNo() + 1);
                        players[turn].setSoldierNo(players[turn].getSoldierNo() + 1);
                        map.map[i][j].setText(" " + map.map[i][j].getState().getSoldierNo());
                        players[turn].setAddSoldier(players[turn].getAddSoldier() - 1);
                        frame.add(whoseTurn((turn + 1) % noPlayers));
                        frame.repaint();
                        frame.remove(players[turn].picture);
                        if (players[turn].getAddSoldier() != 0) {
                            turn = (turn + 1) % noPlayers;
                            players[turn].picture.setBounds((int) screenSize.width - 150,
                                    (int) screenSize.height - 250, 150, 250);
                            frame.add(players[turn].picture);
                            howMany.setText("I can add "
                                    + players[turn].getAddSoldier() + " soldiers!");
                        }
                    }
                }
                if (players[turn].getAddSoldier() == 0) {
                    players[turn].setFirstTurn(false);
                    turn = (turn + 1) % noPlayers;
                    players[turn].picture.setBounds((int) screenSize.width - 150,
                            (int) screenSize.height - 250, 150, 250);
                    frame.add(players[turn].picture);
                }
                for (sw = 0; sw < noPlayers; sw++) {
                    if (players[turn].isFirstTurn()) {
                        break;
                    }
                }
                if (sw == noPlayers) {
                    firstFinished = true;
                }
                if (firstFinished) {
                    frame.remove(players[turn].picture);
                    turn = 0;
                    if (label != null) {
                        frame.remove(label);
                    }
                    label.removeAll();
                    howMany.removeAll();
                    frame.remove(howMany);
                    setLevelButtons(noPlayers);
                }
            }
        };
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (map.map[i][j] != null) {
                    map.map[i][j].addActionListener(l);
                }
            }
        }
    }

    public JLabel whoseTurn(int turn) {
        label = new JLabel();
        ImageIcon image = new ImageIcon("giphy.gif");
        Image temp = image.getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT);
        image.setImage(temp);
        label.setIcon(image);
        switch (turn) {
            case 0:
                label.setBounds((int) screenSize.width - 280, 60, 100, 70);
                break;
            case 1:
                label.setBounds((int) screenSize.width - 280, 140, 100, 70);
                break;
            case 2:
                label.setBounds((int) screenSize.width - 280, 225, 100, 70);
                break;
            case 3:
                label.setBounds((int) screenSize.width - 280, 310, 100, 70);
                break;
            default:
                break;
        }
        return label;
    }
}

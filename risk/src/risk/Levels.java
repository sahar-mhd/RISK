package risk;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

public abstract class Levels {

    int Turn;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    ImageIcon levelSelected;
    Image selected;
    JLabel levelImage;
    JLabel label;

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

    public void numberOfSoldiersCanAdd(Continent Africa, Continent Asia,
            Continent Europe, Continent America, Player[] players, int turn) {
        boolean s = true;
        for (State africa1 : Africa.getState()) {
            if (africa1.getOwner() != players[turn]) {
                s = false;
                break;
            }
        }
        if (s) {
            players[turn].setAddSoldier(players[turn].getAddSoldier() + 2);
        }
        s = true;
        for (State america1 : America.getState()) {
            if (america1.getOwner() != players[turn]) {
                s = false;
                break;
            }
        }
        if (s) {
            players[turn].setAddSoldier(players[turn].getAddSoldier() + 3);
        }
        s = true;
        for (State asia1 : Asia.getState()) {
            if (asia1.getOwner() != players[turn]) {
                s = false;
                break;
            }
        }
        if (s) {
            players[turn].setAddSoldier(players[turn].getAddSoldier() + 4);
        }
        s = true;
        for (State europe1 : Europe.getState()) {
            if (europe1.getOwner() != players[turn]) {
                s = false;
                break;
            }
        }
        if (s) {
            players[turn].setAddSoldier(players[turn].getAddSoldier() + 4);
        }
        players[turn].setAddSoldier(players[turn].getAddSoldier() + (players[turn].getStateNo() / 3));
    }
}

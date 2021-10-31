package risk;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player {

    private int number;
    private String color;
    private int stateNo;
    private int soldierNo;
    private int addSoldier = 0;
    private boolean firstTurn = true;
    private int addState = 0;
    public JLabel picture;
    public ImageIcon icon;

    public Player() {
    }

    public Player(String color) {
        this.color = color;
    }

    public boolean isWinner() {
        if (this.getStateNo() == 29) {
            this.setColor(this.getColor());
            return true;
        }
        return false;
    }

    public int getStateNo() {
        return stateNo;
    }

    public void setStateNo(int stateNo) {
        this.stateNo = stateNo;
    }

    public int getSoldierNo() {
        return soldierNo;
    }

    public void setSoldierNo(int soldeirNo) {
        this.soldierNo = soldeirNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAddSoldier() {
        return addSoldier;
    }

    public void setAddSoldier(int addSoldier) {
        this.addSoldier = addSoldier;
    }

    public boolean isFirstTurn() {
        return firstTurn;
    }

    public void setFirstTurn(boolean firstTurn) {
        this.firstTurn = firstTurn;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAddState() {
        return addState;
    }

    public void setAddState(int addState) {
        this.addState = addState;
    }

    public void setPicture(String name) {
        this.picture = new JLabel();
        ImageIcon image = new ImageIcon(name);
        Image temp = image.getImage().getScaledInstance(150, 250, Image.SCALE_DEFAULT);
        image.setImage(temp);
        this.picture.setIcon(image);
    }

    public void setIcon(String url) {
        this.icon = new ImageIcon(url);
        Image temp = icon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        this.icon.setImage(temp);
    }

}

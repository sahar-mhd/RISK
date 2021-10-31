package risk;

import java.awt.*;
import javax.swing.*;

public class TwoPlayersGame extends Game {

    boolean won = false;
    ImageIcon image = new ImageIcon();
    Image temp;

    public void init() {
        players = new Player[2];
        p1.setAddSoldier(30);
        p2.setAddSoldier(30);
        p1.setStateNo(0);//14
        p2.setStateNo(0);//15
        p1.setAddState(14);
        p2.setAddState(15);
        p1.setNumber(1);
        p2.setNumber(2);
        p1.setPicture("green.jpg");
        p2.setPicture("red.jpg");
        p1.setIcon("iconGreen.png");
        p2.setIcon("iconRed.png");
        players[0] = p1;
        players[1] = p2;
        int width = (int) screenSize.getWidth();
        makeContinents();
        stateSpreader(2);
        map.drawMap(frame, screenSize.width, screenSize.height);
        setStatesForButtons();
        firstTurn(2);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        image = new ImageIcon("sea.jpg");
        temp = image.getImage().getScaledInstance(780, 490, Image.SCALE_DEFAULT);
        image.setImage(temp);
        JLabel back = new JLabel(image);
        back.setBounds(200, 60, 780, 490);
        //start setting homeIcon **********************************************
        image = new ImageIcon("HomeIcon.png");
        temp = image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        image.setImage(temp);
        JButton homeButton = new JButton(image);
        homeButton.addActionListener((e) -> {
            frame.setVisible(false);
            frame.removeAll();
            GUI openMenu = new GUI();
            openMenu.init();
        });
        homeButton.setBounds(width - 50, 0, 50, 50);
        //homeIcon set
        //start setting players list ******************************************
        crowns = new JLabel[2];
        image = new ImageIcon("greenCrown.jpg");
        temp = image.getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT);
        image.setImage(temp);
        p = new JPanel();
        p.setBounds(width - 150, 50, 150, 160);
        crowns[0] = new JLabel("Player 1");
        crowns[0].setForeground(Color.white);
        crowns[0].setIcon(image);
        crowns[0].setName("green");
        p.add(crowns[0]);
        image = new ImageIcon("redCrown.jpg");
        temp = image.getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT);
        image.setImage(temp);
        crowns[1] = new JLabel("Player 2");
        crowns[1].setForeground(Color.white);
        crowns[1].setIcon(image);
        crowns[1].setName("red");
        p.add(crowns[1]);
        p.setBackground(Color.black);
        //players list set
        //*********************************************************************        
        frame.add(p);
        frame.add(homeButton);
        frame.add(back);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

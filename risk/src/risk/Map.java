package risk;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Map {

    Button[][] map = new Button[6][7];
    String name;

    public void drawMap(JFrame frame, int width, int height) {

        // column 1 ###########################################################
        map[0][0] = new Button();
        map[0][0].setBackground(Color.black);
        map[0][0].setBounds(200, 60, 130, 70);
        map[0][1] = new Button();
        map[0][1].setBackground(Color.black);
        map[0][1].setBounds(200, 130, 130, 70);
        map[0][2] = new Button();
        map[0][2].setBackground(Color.black);
        map[0][2].setBounds(200, 200, 130, 70);
        map[0][3] = new Button();
        map[0][3].setBackground(Color.black);
        map[0][3].setBounds(200, 270, 130, 70);
        map[0][4] = new Button();
        map[0][4].setBackground(Color.black);
        map[0][4].setBounds(200, 340, 130, 70);
        map[0][5] = new Button();
        map[0][5].setBackground(Color.black);
        map[0][5].setBounds(200, 410, 130, 70);
        // column 2 ###########################################################
        map[1][0] = new Button();
        map[1][0].setBackground(Color.black);
        map[1][0].setBounds(330, 60, 130, 70);
        map[1][1] = new Button();
        map[1][1].setBackground(Color.black);
        map[1][1].setBounds(330, 130, 130, 70);
        map[1][5] = new Button();
        map[1][5].setBackground(Color.black);
        map[1][5].setBounds(330, 410, 130, 70);
        //column 3 ############################################################
        map[2][0] = new Button();
        map[2][0].setBackground(Color.red);
        map[2][0].setBounds(460, 60, 130, 70);
        map[2][1] = new Button();
        map[2][1].setBackground(Color.red);
        map[2][1].setBounds(460, 130, 130, 70);
        map[2][2] = new Button();
        map[2][2].setBackground(Color.red);
        map[2][2].setBounds(460, 200, 130, 70);
        map[2][4] = new Button();
        map[2][4].setBackground(Color.yellow);
        map[2][4].setBounds(460, 340, 130, 70);
        map[2][5] = new Button();
        map[2][5].setBackground(Color.yellow);
        map[2][5].setBounds(460, 410, 130, 70);
        map[2][6] = new Button();
        map[2][6].setBackground(Color.yellow);
        map[2][6].setBounds(460, 480, 130, 70);
        //column 4 ############################################################
        map[3][0] = new Button();
        map[3][0].setBackground(Color.red);
        map[3][0].setBounds(590, 60, 130, 70);
        map[3][1] = new Button();
        map[3][1].setBackground(Color.red);
        map[3][1].setBounds(590, 130, 130, 70);
        map[3][2] = new Button();
        map[3][2].setBackground(Color.red);
        map[3][2].setBounds(590, 200, 130, 70);
        map[3][3] = new Button();
        map[3][3].setBackground(Color.yellow);
        map[3][3].setBounds(590, 270, 130, 70);
        map[3][4] = new Button();
        map[3][4].setBackground(Color.yellow);
        map[3][4].setBounds(590, 340, 130, 70);
        map[3][5] = new Button();
        map[3][5].setBackground(Color.yellow);
        map[3][5].setBounds(590, 410, 130, 70);
        //column 5 ############################################################
        map[4][0] = new Button();
        map[4][0].setBackground(Color.green);
        map[4][0].setBounds(720, 60, 130, 70);
        map[4][1] = new Button();
        map[4][1].setBackground(Color.green);
        map[4][1].setBounds(720, 130, 130, 70);
        map[4][2] = new Button();
        map[4][2].setBackground(Color.green);
        map[4][2].setBounds(720, 200, 130, 70);
        map[4][3] = new Button();
        map[4][3].setBackground(Color.green);
        map[4][3].setBounds(720, 270, 130, 70);
        //column 6 ############################################################
        map[5][0] = new Button();
        map[5][0].setBackground(Color.green);
        map[5][0].setBounds(850, 60, 130, 70);
        map[5][1] = new Button();
        map[5][1].setBackground(Color.green);
        map[5][1].setBounds(850, 130, 130, 70);
        map[5][2] = new Button();
        map[5][2].setBackground(Color.green);
        map[5][2].setBounds(850, 200, 130, 70);
        map[5][3] = new Button();
        map[5][3].setBackground(Color.green);
        map[5][3].setBounds(850, 270, 130, 70);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (map[i][j] != null) {
                    map[i][j].setFont(new Font("", Font.PLAIN, 16));
                    frame.add(map[i][j]);
                }
            }
        }
        //set timer ***********************************************************
        TimerTime time = new TimerTime(frame);
        time.start();
        ImageIcon image = new ImageIcon("giphy_3.gif");
        Image temp = image.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        image.setImage(temp);
        JLabel clock = new JLabel(image);
        clock.setBounds(0, 0, 75, 75);
        frame.add(clock);
    }
}

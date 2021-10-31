package risk;

import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TimerTime extends Thread {

    private int second = 0;
    private int minute = 0;
    private int hour = 0;
    JLabel label = new JLabel("");

    public TimerTime(JFrame f) {
        label.setForeground(Color.white);
        label.setFont(new Font("", Font.PLAIN, 26));
        label.setBounds(100, 0, 200, 75);
        f.add(label);
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TimerTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        second++;
        if (second == 60) {
            minute++;
            second = 0;
        }
        if (minute == 60) {
            minute = 0;
            hour++;
        }
        label.setText(hour + " : " + minute + " : " + second);
        run();
    }
}

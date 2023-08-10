import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DigitalClock {
    private static final String[] timeZones = {"GMT", "UTC", "America/New_York", "Asia/Tokyo"};
    private static int currentTimeZoneIndex = 0;
    private static TimeZone currentTimeZone = TimeZone.getTimeZone(timeZones[currentTimeZoneIndex]);

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame( "Digital Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLayout(new FlowLayout());

        // Create the clock label
        JLabel clockLabel = new JLabel();
        clockLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        frame.add(clockLabel);

        // Create buttons for different functionalities
        JButton watchButton = new JButton("Watch");
        JButton stopwatchButton = new JButton("Stopwatch");
        JButton timerButton = new JButton("Timer");


        watchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        stopwatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        timerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Create a button to switch between time zones
        JButton timeZoneButton = new JButton("Switch Time Zone");
        timeZoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTimeZoneIndex = (currentTimeZoneIndex + 1) % timeZones.length;
                currentTimeZone = TimeZone.getTimeZone(timeZones[currentTimeZoneIndex]);
            }
        });

        // Add buttons to the frame
        frame.add(watchButton);
        frame.add(stopwatchButton);
        frame.add(timerButton);
        frame.add(timeZoneButton);

        // Update the clock every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sdf.setTimeZone(currentTimeZone);
                clockLabel.setText(sdf.format(new Date()));
            }
        });
        timer.start();

        // Show the frame
        frame.setVisible(true);
    }
}

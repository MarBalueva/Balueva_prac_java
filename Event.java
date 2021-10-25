import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Event extends JFrame
{
    public int i1 = 0;
    public int i2 = 0;

    Event() {
        JFrame jfr = new JFrame("AC Milan vs Real Madrid");
        jfr.setSize(600, 300);
        jfr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel jlb = new JLabel("Who is winner?");

        JLabel l1 = new JLabel("Result 0 X 0");
        JLabel l2 = new JLabel("Last Scorer: N/A");
        JLabel l3 = new JLabel("Winner: ?");

        JButton j1 = new JButton("AC Milan");
        JButton j2 = new JButton("Real Madrid");

        JPanel[] pnl = new JPanel[12];
        jfr.setLayout(new GridLayout(3,4));
        for (int i= 0; i < pnl.length; i++)
        {
            pnl[i] = new JPanel();
            jfr.add(pnl[i]);
        }
        pnl[1].add(jlb);
        pnl[4].add(j1);
        pnl[5].add(l1);
        pnl[7].add(j2);
        pnl[8].add(l2);
        pnl[10].add(l3);

        j1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    i1++;
                    l1.setText("Result " + i1 + " X " + i2);
                    l2.setText("Last Scorer: AC Milan");
                    if (i1 > i2)
                        l3.setText("Winner: AC Milan");
                    if (i1 == i2)
                        l3.setText("Winner: DRAW");
                }
                catch (Exception exception) {};
            }
        });
        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                     i2++;
                     l1.setText("Result " + i1 + " X " + i2);
                     l2.setText("Last Scorer: Real Madrid");
                     if (i2 > i1)
                         l3.setText("Winner: Real Madrid");
                    if (i1 == i2)
                        l3.setText("Winner: DRAW");
                }
                catch (Exception exception) {};
            }
        });
        jfr.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Event();
            }
        });
    }
}

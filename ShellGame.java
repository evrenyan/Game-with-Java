import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class ShellGame extends JFrame {
    private JButton[] buttons = new JButton[3];
    private int correctButtonIndex;
    public ShellGame() {
        super("Shell Game");
        Random random = new Random();
        correctButtonIndex = random.nextInt(3);

        setLayout(new FlowLayout());
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("trykk her");
            final int index = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (JButton button : buttons) {
                        button.setEnabled(false);
                    }
                    if (index == correctButtonIndex) {
                        JOptionPane.showMessageDialog(null, "ok");
                    } else {
                        JOptionPane.showMessageDialog(null, "nei");
                    }
                }
            });
            add(buttons[i]);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
    }
    public static void main(String[] args) {
        // Run the program
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShellGame();
            }
        });
    }
}

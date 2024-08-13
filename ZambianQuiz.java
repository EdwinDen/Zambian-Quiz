import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import javax.swing.*;

public class ZambianQuiz extends JFrame{
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField answerBox;
    JLabel scoreLabel;

    public void initialize() {
        /* *************Question Page************** */
        JLabel timeLabel = new JLabel("Time: ", SwingConstants.RIGHT);
        timeLabel.setFont(mainFont);

        JLabel timerLabel = new JLabel("13mins 07secs", SwingConstants.LEFT);
        timerLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));

        JLabel empty = new JLabel(" ");

        scoreLabel = new JLabel("Score: ", SwingConstants.RIGHT);
        scoreLabel.setFont(mainFont);

        JLabel scoresLabel = new JLabel("7/10");
        scoresLabel.setHorizontalAlignment(JLabel.LEFT);
        scoresLabel.setFont(new Font("Arial", Font.BOLD, 16));


        /* ************BUTTON LABEL********** */
        JButton play = new JButton("PLAY AGAIN");
        play.setFont(mainFont);

        JButton back = new JButton("EXIT");
        back.setFont(mainFont);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2,5,5));
        buttonsPanel.add(play);
        buttonsPanel.add(back);

        JPanel scorePanel = new JPanel(new GridLayout(3,2,5,5));
        scorePanel.add(timeLabel);
        scorePanel.add(timerLabel);
        scorePanel.add(scoreLabel);
        scorePanel.add(scoresLabel);
        scorePanel.add(play);
        scorePanel.add(back);

        JPanel maiPanel = new JPanel();
        maiPanel.setLayout(new BorderLayout());
        maiPanel.setBackground(new Color(123, 128, 255));
        maiPanel.add(scorePanel, BorderLayout.CENTER);
//        maiPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(maiPanel);

        setTitle("ZAMBIAN QUIZ");
        setSize(500, 400);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        ZambianQuiz zed = new ZambianQuiz();
        zed.initialize();
    }
}

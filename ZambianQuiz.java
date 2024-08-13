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
        JLabel timeLabel = new JLabel("Time: ", SwingConstants.CENTER);
        timeLabel.setFont(mainFont);

        JLabel timerLabel = new JLabel("13:07", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));


        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 1, 5, 5));
        formPanel.add(timeLabel);
        formPanel.add(timerLabel);

        /* ************TITLE LABEL********** */
        scoreLabel = new JLabel();
        scoreLabel.setFont(mainFont);

        /* ************Instructions******** */
        JLabel instruction = new JLabel("Type the correct answer in the text box and press 'NEXT'.");
        instruction.setHorizontalAlignment(JLabel.CENTER);
        instruction.setFont(new Font("Arial", Font.BOLD, 16));

        /* ************BUTTON LABEL********** */
        JButton play = new JButton("PLAY");
        play.setFont(mainFont);
        play.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String ans = answerBox.getText();
                scoreLabel.setText("Your answer is " + ans);
                instruction.setVisible(false);
            }
            
        });

        JButton back = new JButton("BACK");
        back.setFont(mainFont);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                scoreLabel.setText("");
                answerBox.setText("");
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonsPanel.add(back);
        buttonsPanel.add(play);

        JPanel maiPanel = new JPanel();
        maiPanel.setLayout(new BorderLayout());
        maiPanel.setBackground(new Color(123, 128, 255));
        maiPanel.add(formPanel, BorderLayout.NORTH);
        maiPanel.add(scoreLabel, BorderLayout.CENTER);
        maiPanel.add(instruction, BorderLayout.CENTER);
        maiPanel.add(buttonsPanel, BorderLayout.SOUTH);

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

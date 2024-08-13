
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ZambiaQuiz {
    private JFrame frame;
    private JPanel mainPanel;
    private JTextArea questionArea;
    private JRadioButton[] options;
    private ButtonGroup optionsGroup;
    private JButton nextButton;
    private JLabel timerLabel;
    private JLabel questionsAnsweredLabel;
    private int currentQuestionIndex;
    private String[][] questions;
    private List<String[]> selectedQuestions;
    private String[] userAnswers;
    private int score;
    private int questionsAnswered;
    private Timer timer;
    private int secondsElapsed;

    public ZambiaQuiz() {
        // Create the main frame
        frame = new JFrame("Zambian Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Show home screen
        showHomeScreen();

        // Display the frame
        frame.setVisible(true);
    }

    private void showHomeScreen() {
        frame.getContentPane().removeAll();
        JPanel homePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("ZED BRAIN QUIZ GAME");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        homePanel.add(titleLabel, gbc);

        JButton playButton = new JButton("PLAY");
        playButton.setPreferredSize(new Dimension(100, 50));
        gbc.gridy = 1;
        homePanel.add(playButton, gbc);

        JButton exitButton = new JButton("EXIT");
        exitButton.setPreferredSize(new Dimension(100, 50));
        gbc.gridy = 2;
        homePanel.add(exitButton, gbc);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startQuiz();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(homePanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private void startQuiz() {
        frame.getContentPane().removeAll();

        // All 100 questions and answers
        questions = new String[][] {
                { "What is the capital city of Zambia?", "Lusaka", "Ndola", "Kitwe", "Livingstone", "A" },
                { "What is the official language of Zambia?", "Swahili", "French", "English", "Portuguese", "C" },
                { "Which river is the longest in Zambia?", "Zambezi River", "Kafue River", "Luangwa River",
                        "Chambeshi River", "A" },
                { "What is the currency of Zambia?", "Kwacha", "Rand", "Shilling", "Dollar", "A" },
                { "In which year did Zambia gain independence from Britain?", "1950", "1964", "1975", "1980", "B" },
                { "Which is the largest city in Zambia?", "Lusaka", "Kitwe", "Ndola", "Livingstone", "A" },
                { "Which national park in Zambia is known for its walking safaris?", "Kafue National Park",
                        "South Luangwa National Park", "Lower Zambezi National Park", "Mosi-oa-Tunya National Park",
                        "B" },
                { "What is the main export of Zambia?", "Coffee", "Gold", "Copper", "Diamonds", "C" },
                { "Which waterfall is located on the border between Zambia and Zimbabwe?", "Angel Falls",
                        "Niagara Falls", "Victoria Falls", "Iguazu Falls", "C" },
                { "Who was the first president of Zambia?", "Kenneth Kaunda", "Frederick Chiluba", "Levy Mwanawasa",
                        "Michael Sata", "A" },
                { "Which is the largest province in Zambia by area?", "Lusaka Province", "Copperbelt Province",
                        "North-Western Province", "Western Province", "D" },
                { "What is the traditional Zambian dish made from maize flour?", "Ugali", "Sadza", "Nshima", "Fufu",
                        "C" },
                { "Which lake forms part of Zambia's northern border?", "Lake Victoria", "Lake Tanganyika",
                        "Lake Malawi", "Lake Turkana", "B" },
                { "How many provinces are there in Zambia?", "8", "10", "11", "15", "B" },
                { "Which is the main legislative body of Zambia?", "National Assembly", "Senate",
                        "House of Representatives", "Parliament", "A" },
                { "Which Zambian city is known as the 'Copper Capital'?", "Lusaka", "Ndola", "Kitwe", "Chingola", "C" },
                { "What is the highest point in Zambia?", "Mount Kilimanjaro", "Mafinga Central", "Mount Meru",
                        "Mulanje Massif", "B" },
                { "Which body of water is shared by Zambia and Zimbabwe?", "Lake Kariba", "Lake Tanganyika",
                        "Lake Victoria", "Lake Malawi", "A" },
                { "What is the name of the Zambian National Football Team?", "Chipolopolo", "Black Stars",
                        "Indomitable Lions", "Pharaohs", "A" },
                { "Which festival is celebrated by the Lozi people in Zambia?", "N'cwala", "Kuomboka", "Mutomboko",
                        "Umuganura", "B" },
                { "Which city is home to the University of Zambia?", "Lusaka", "Ndola", "Kitwe", "Livingstone", "A" },
                { "What is the main religion in Zambia?", "Islam", "Hinduism", "Christianity", "Buddhism", "C" },
                { "Which is the oldest game park in Zambia?", "Kafue National Park", "South Luangwa National Park",
                        "North Luangwa National Park", "Mosi-oa-Tunya National Park", "A" },
                { "What is Zambia's motto?", "Unity and Freedom", "One Zambia, One Nation", "Peace and Progress",
                        "Strength in Diversity", "B" },
                { "Who is the current president of Zambia (as of 2024)?", "Edgar Lungu", "Michael Sata",
                        "Hakainde Hichilema", "Rupiah Banda", "C" },
                { "Which animal is featured on the Zambian coat of arms?", "Elephant", "Lion", "Eagle", "Buffalo",
                        "C" },
                { "What is the name of Zambia’s legislative capital?", "Lusaka", "Ndola", "Kitwe", "Livingstone", "A" },
                { "Which river is a major tributary of the Zambezi in Zambia?", "Kafue River", "Orange River",
                        "Limpopo River", "Volta River", "A" },
                { "Which city is known as the tourist capital of Zambia?", "Lusaka", "Ndola", "Kitwe", "Livingstone",
                        "D" },
                { "Which traditional ceremony is celebrated by the Ngoni people in Zambia?", "N'cwala", "Kuomboka",
                        "Mutomboko", "Umuganura", "A" },
                { "What is the primary industry in the Copperbelt region of Zambia?", "Agriculture", "Mining",
                        "Tourism", "Manufacturing", "B" },
                { "Which Zambian airport is the largest?", "Kenneth Kaunda International Airport",
                        "Simon Mwansa Kapwepwe International Airport", "Harry Mwanga Nkumbula International Airport",
                        "Mfuwe Airport", "A" },
                { "What is the name of the national airline of Zambia?", "Air Zambia", "Zambezi Airlines",
                        "Proflight Zambia", "Zambia Airways", "D" },
                { "Which city in Zambia is known for its copper mining activities?", "Lusaka", "Ndola", "Kitwe",
                        "Chingola", "D" },
                { "What is the predominant climate in Zambia?", "Tropical", "Desert", "Mediterranean", "Arctic", "A" },
                { "Which is the main port of entry for tourists visiting Victoria Falls?", "Lusaka", "Ndola", "Kitwe",
                        "Livingstone", "D" },
                { "What is the name of the traditional Zambian attire for women?", "Kanga", "Chitenge", "Dashiki",
                        "Sari", "B" },
                { "Which Zambian province is known for its tobacco farming?", "Lusaka Province", "Central Province",
                        "Eastern Province", "Southern Province", "C"

                },
                { "Which river forms the border between Zambia and Zimbabwe?", "Kafue River", "Zambezi River",
                        "Luangwa River", "Chambeshi River", "B" },
                { "Who is Zambia's first female vice president?", "Inonge Wina", "Edith Nawakwi", "Margaret Mwanakatwe",
                        "Dora Siliya", "A" },
                { "Which city is home to the Copperbelt University?", "Lusaka", "Ndola", "Kitwe", "Chingola", "C" },
                { "What is the name of the traditional Zambian drum used in ceremonies?", "Ngoma", "Djembe", "Bongo",
                        "Conga", "A" },
                { "Which is the largest man-made lake in Zambia?", "Lake Tanganyika", "Lake Kariba", "Lake Malawi",
                        "Lake Victoria", "B" },
                { "Which organization regulates Zambia's mining industry?", "Zambia Chamber of Mines",
                        "Ministry of Mines and Minerals Development", "Zambia Environmental Management Agency", "ZESCO",
                        "B" },
                { "Which Zambian city is known for its cement production?", "Lusaka", "Ndola", "Kitwe", "Livingstone",
                        "B" },
                { "Which traditional dance is performed by the Bemba people in Zambia?", "Makishi", "Kalela", "Ingoma",
                        "Malipenga", "B" },
                { "What is the primary source of electricity in Zambia?", "Coal", "Hydro power", "Solar power",
                        "Nuclear power", "B" },
                { "Which is the highest court in Zambia?", "High Court", "Constitutional Court", "Supreme Court",
                        "Court of Appeal", "C" },
                { "Which city is known as the gateway to the Northern Circuit tourist attractions in Zambia?", "Lusaka",
                        "Ndola", "Kitwe", "Kasama", "D" },
                { "Which river is associated with the Barotse Floodplain in Zambia?", "Zambezi River", "Kafue River",
                        "Luangwa River", "Chambeshi River", "A" },
                { "Which is the most popular sport in Zambia?", "Rugby", "Cricket", "Football", "Basketball", "C" },
                { "Which Zambian province is known for its tourism and wildlife?", "Lusaka Province",
                        "Western Province", "Southern Province", "Eastern Province", "C" },
                { "Which ethnic group is the largest in Zambia?", "Bemba", "Tonga", "Lozi", "Ngoni", "A" },
                { "Which Zambian city hosts the annual Zambia Agricultural and Commercial Show?", "Lusaka", "Ndola",
                        "Kitwe", "Livingstone", "A" },
                { "What is the name of the Zambian national anthem?", "Nkosi Sikelel' iAfrika",
                        "Stand and Sing of Zambia, Proud and Free", "God Bless Zambia", "Arise, O Compatriots", "B" },
                { "Which is the main export destination for Zambian copper?", "China", "USA", "India", "South Africa",
                        "A" },
                { "Which Zambian city is known for its sugar production?", "Lusaka", "Ndola", "Mazabuka", "Kitwe",
                        "C" },
                { "Which river is a major tributary of the Kafue River in Zambia?", "Luangwa River", "Lufupa River",
                        "Lunga River", "Chambeshi River", "B" },
                { "Which is the largest ethnic group in Zambia’s Eastern Province?", "Ngoni", "Lozi", "Bemba", "Tonga",
                        "A" },
                { "Which Zambian city is famous for its annual Mutomboko ceremony?", "Lusaka", "Ndola", "Mansa",
                        "Livingstone", "C" },
                { "Which Zambian city is the commercial and industrial hub of the country?", "Lusaka", "Ndola", "Kitwe",
                        "Livingstone", "A" },
                { "Which Zambian national park is a UNESCO World Heritage Site?", "Kafue National Park",
                        "South Luangwa National Park", "Mosi-oa-Tunya National Park", "Lower Zambezi National Park",
                        "C" },
                { "Which river forms part of the border between Zambia and Namibia?", "Zambezi River", "Okavango River",
                        "Limpopo River", "Kunene River", "A" },
                { "Which city in Zambia is known for its textile industry?", "Lusaka", "Ndola", "Livingstone", "Kabwe",
                        "D" },
                { "What is the traditional Zambian fishing method using reeds and grass?", "Trawl fishing",
                        "Gillnetting", "Bundu fishing", "Basket fishing", "D" },
                { "Which is the main staple food of Zambia?", "Maize", "Rice", "Wheat", "Cassava", "A" },
                { "Which Zambian province is known for its gemstones, particularly emeralds?", "Lusaka Province",
                        "Copperbelt Province", "Central Province", "North-Western Province", "B" },
                { "Which traditional ceremony is celebrated by the Bemba people in Zambia?", "N'cwala", "Kuomboka",
                        "Mutomboko", "Chibwelamushi", "D" },
                { "Which is the main livestock reared in Zambia?", "Cattle", "Sheep", "Goats", "Pigs", "A" },
                { "Which is the main Zambian celebration of independence?", "Heroes Day", "Unity Day",
                        "Independence Day", "Africa Freedom Day", "C" },
                { "Which Zambian province is known for its maize production?", "Lusaka Province", "Copperbelt Province",
                        "Central Province", "North-Western Province", "C" },
                { "Which is the main fruit grown in Zambia’s Eastern Province?", "Mango", "Banana", "Pineapple",
                        "Orange", "A" },
                { "Which is the largest hydroelectric dam in Zambia?", "Kafue Gorge Dam", "Kariba Dam",
                        "Itezhi-Tezhi Dam", "Victoria Falls Dam", "B" },
                { "Which Zambian province is known for its traditional crafts and pottery?", "Lusaka Province",
                        "Western Province", "Southern Province", "Northern Province", "B" },
                { "Which is the main road linking Zambia to Tanzania?", "Great East Road", "Great North Road",
                        "Great West Road", "Great South Road", "B" },
                { "Which traditional Zambian instrument is similar to a xylophone?", "Mbira", "Kalimba", "Marimba",
                        "Balafon", "C" },
                { "Which Zambian city is known for its annual beer festival?", "Lusaka", "Ndola", "Kitwe",
                        "Livingstone", "A" },
                { "Which Zambian province is known for its coffee production?", "Lusaka Province",
                        "Copperbelt Province", "Northern Province", "Eastern Province", "C" },
                { "Which is the main Zambian cultural festival celebrating unity?", "N'cwala", "Kuomboka", "Mutomboko",
                        "Umuganura", "A" },
                { "Which Zambian city is known for its annual agriculture show?", "Lusaka", "Ndola", "Kitwe",
                        "Livingstone", "A" },
                { "Which is the main export crop of Zambia?", "Maize", "Tobacco", "Cotton", "Sugarcane", "B" },
                { "Which Zambian province is known for its traditional fish farming?", "Lusaka Province",
                        "Western Province", "Southern Province", "Northern Province", "B" },
                { "Which Zambian city is known for its traditional dance festival?", "Lusaka", "Ndola", "Kitwe",
                        "Livingstone", "A" },
                { "Which is the main economic activity in Zambia’s Northern Province?", "Agriculture", "Mining",
                        "Tourism", "Manufacturing", "A" },
                { "Which Zambian river is famous for its tiger fishing?", "Zambezi River", "Kafue River",
                        "Luangwa River", "Chambeshi River", "A" },
                { "Which traditional ceremony is celebrated by the Lozi people in Zambia?", "N'cwala", "Kuomboka",
                        "Mutomboko", "Umuganura", "B" },
                { "Which is the main food crop grown in Zambia’s Southern Province?", "Maize", "Rice", "Wheat",
                        "Cassava", "A" },
                { "Which Zambian city is known for its traditional pottery industry?", "Lusaka", "Ndola", "Kitwe",
                        "Livingstone", "D" },
                { "Which is the main cash crop grown in Zambia’s Eastern Province?", "Maize", "Tobacco", "Cotton",
                        "Sugarcane", "B" },
                { "Which Zambian river is famous for its canoeing and rafting activities?", "Zambezi River",
                        "Kafue River", "Luangwa River", "Chambeshi River", "A" },
                { "Which Zambian city is known for its traditional wood carving industry?", "Lusaka", "Ndola", "Kitwe",
                        "Livingstone", "D" },
                { "Which is the main export destination for Zambian tobacco?", "China", "USA", "India", "South Africa",
                        "B" },
                { "Which Zambian province is known for its traditional basket weaving?", "Lusaka Province",
                        "Western Province", "Southern Province", "Northern Province", "B" },
                { "Which traditional ceremony is celebrated by the Lunda people in Zambia?", "N'cwala", "Kuomboka",
                        "Mutomboko", "Umuganura", "C" },
                { "Which Zambian city is known for its traditional bead making industry?", "Lusaka", "Ndola", "Kitwe",
                        "Livingstone", "D" },
                { "Which is the main export destination for Zambian cotton?", "China", "USA", "India", "South Africa",
                        "C" },
                { "Which Zambian province is known for its traditional canoe making?", "Lusaka Province",
                        "Western Province", "Southern Province", "Northern Province", "B" },
                { "Which traditional ceremony is celebrated by the Tonga people in Zambia?", "Lwiindi", "Kuomboka",
                        "Mutomboko", "Umuganura", "A" },
                { "Which Zambian city is known for its traditional mask making industry?", "Lusaka", "Ndola", "Kitwe",
                        "Livingstone", "D" },
                { "Which is the main export destination for Zambian maize?", "China", "USA", "India", "South Africa",
                        "D" }
        };

        // Shuffle and select 10 questions
        List<String[]> questionList = new ArrayList<>(Arrays.asList(questions));
        Collections.shuffle(questionList);
        selectedQuestions = questionList.subList(0, 10);

        userAnswers = new String[selectedQuestions.size()];
        currentQuestionIndex = 0;
        score = 0;
        questionsAnswered = 0;
        secondsElapsed = 0;

        // Create the timer and questions answered labels
        timerLabel = new JLabel("00:00");
        questionsAnsweredLabel = new JLabel("Questions Answered: 0/10");

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("\u23F1"));
        topPanel.add(timerLabel);
        topPanel.add(Box.createHorizontalStrut(20)); // Spacing
        topPanel.add(questionsAnsweredLabel);
        frame.add(topPanel, BorderLayout.NORTH);

        // Create the main panel to hold question and options
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the question area
        questionArea = new JTextArea(3, 50);
        questionArea.setEditable(false);
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        mainPanel.add(new JScrollPane(questionArea), BorderLayout.NORTH);

        // Create the options
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(2, 2));
        options = new JRadioButton[4];
        optionsGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            optionsGroup.add(options[i]);
            optionsPanel.add(options[i]);
        }
        mainPanel.add(optionsPanel, BorderLayout.CENTER);

        frame.add(mainPanel, BorderLayout.CENTER);

        // Create the next button
        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (optionsGroup.getSelection() != null) {
                    userAnswers[currentQuestionIndex] = optionsGroup.getSelection().getActionCommand();
                    optionsGroup.clearSelection();
                    questionsAnswered++;
                    if (selectedQuestions.get(currentQuestionIndex)[5].equals(userAnswers[currentQuestionIndex])) {
                        JOptionPane.showMessageDialog(frame, "Your answer is Correct", "Correct Answer",
                                1);
                        score++;
                    }else{
                        JOptionPane.showMessageDialog(frame, "Your answer is wrong. Correct answer is "+
                                        selectedQuestions.get(currentQuestionIndex)[5], "Wrong Answer",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    questionsAnsweredLabel.setText("Questions Answered: " + questionsAnswered + "/10");
                    currentQuestionIndex++;
                    if (currentQuestionIndex < selectedQuestions.size()) {
                        displayQuestion(currentQuestionIndex);
                    } else {
                        showResults();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select an answer.", "No Answer Selected",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(nextButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Display the first question
        displayQuestion(currentQuestionIndex);

        // Start the timer
        startTimer();

        frame.revalidate();
        frame.repaint();
    }

    private void displayQuestion(int questionIndex) {
        String[] question = selectedQuestions.get(questionIndex);
        questionArea.setText("Question: " + question[0]);
        questionArea.setFont(new Font("Arial", Font.PLAIN, 20));
        for (int i = 0; i < 4; i++) {
            options[i].setText((char) ('A' + i) + ") " + question[i + 1]);
            options[i].setActionCommand(Character.toString((char) ('A' + i)));
        }
    }

    private void showResults() {

        timer.cancel();
        frame.getContentPane().removeAll();

        JPanel resultPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel timeLabel = new JLabel("Time: " + (secondsElapsed / 60) + " mins " + (secondsElapsed % 60) + " sec");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        resultPanel.add(timeLabel, gbc);

        gbc.gridy = 1;
        JLabel scoreLabel = new JLabel("Score: " + score + "/" + selectedQuestions.size());
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        resultPanel.add(scoreLabel, gbc);

        gbc.gridy = 2;
        JButton playAgainButton = new JButton("PLAY AGAIN");
        playAgainButton.setPreferredSize(new Dimension(150, 50));
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHomeScreen();
            }
        });
        resultPanel.add(playAgainButton, gbc);

        gbc.gridy = 3;
        JButton quitButton = new JButton("QUIT");
        quitButton.setPreferredSize(new Dimension(150, 50));
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        resultPanel.add(quitButton, gbc);

        frame.add(resultPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                secondsElapsed++;
                int minutes = secondsElapsed / 60;
                int seconds = secondsElapsed % 60;
                timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
            }
        }, 1000, 1000);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ZambiaQuiz::new);
    }
}

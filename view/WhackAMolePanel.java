package view;

import java.awt.Container;
import controller.MoleActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class WhackAMolePanel {

	public enum GameState {
		READY, PLAYING, GAMEOVER
	}

	private MoleActionListener listener;
	private WhackAMoleCanvas canvas;
	private JFrame window;
	private JButton newGame = new JButton("Play Game");
	private JButton exit = new JButton("Start Screen");
	private JRadioButton levelOne = new JRadioButton("Easy");
	private JRadioButton levelTwo = new JRadioButton("Medium");
	private JRadioButton levelThree = new JRadioButton("Hard");
	private JRadioButton levelFour = new JRadioButton("Impossible");
	private JLabel time = new JLabel("Time : 60");
	private JLabel points = new JLabel("Points : 0");
	private GameState state = GameState.READY;

	public WhackAMolePanel(JFrame window) {
		this.window = window;
	}

	public void init() {
		Container cp = window.getContentPane();
		JPanel southPanel = new JPanel();

		cp.add(BorderLayout.SOUTH, southPanel);
		southPanel.setLayout(new GridLayout(2, 1));

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(newGame);
		buttonPanel.add(exit);
		southPanel.add(buttonPanel);

		JPanel radioPanel = new JPanel();
		radioPanel.add(levelOne);
		radioPanel.add(levelTwo);
		radioPanel.add(levelThree);
		radioPanel.add(levelFour);
		southPanel.add(radioPanel);

		ButtonGroup levelGroup = new ButtonGroup();
		levelGroup.add(levelOne);
		levelGroup.add(levelTwo);
		levelGroup.add(levelThree);
		levelGroup.add(levelFour);

		TitledBorder title = BorderFactory.createTitledBorder("Difficulty");
		radioPanel.setBorder(title);

		listener = new MoleActionListener(this);
		exit.addActionListener(listener);
		newGame.addActionListener(listener);
		levelOne.addActionListener(listener);
		levelTwo.addActionListener(listener);
		levelThree.addActionListener(listener);
		levelFour.addActionListener(listener);

		canvas = new WhackAMoleCanvas(this);
		cp.add(BorderLayout.CENTER, canvas);

		canvas.addMouseListener(listener);

		JPanel northPanel = new JPanel();
		cp.add(BorderLayout.NORTH, northPanel);
		northPanel.setLayout(new GridLayout(2, 1));
		northPanel.add(points);
		points.setFont(new Font("Arial", Font.BOLD, 20));
		northPanel.add(time);
		time.setFont(new Font("Arial", Font.BOLD, 28));

	}

	public MoleActionListener getListener() {
		return listener;
	}

	public JLabel getTimeLabel() {
		return time;
	}

	public JButton getExitButton() {
		return exit;
	}

	public JButton getNewGameButton() {
		return newGame;
	}

	public JRadioButton getLevel1() {
		return levelOne;
	}

	public JRadioButton getLevel2() {
		return levelTwo;
	}

	public JRadioButton getLevel3() {
		return levelThree;
	}

	public JRadioButton getLevel4() {
		return levelFour;
	}

	public JFrame getWindow() {
		return window;
	}

	public WhackAMoleCanvas getCanvas() {
		return canvas;
	}

	public GameState getGameState() {
		return state;
	}

	public void setGameState(WhackAMolePanel.GameState state) {
		this.state = state;
	}

	public JLabel getPoints() {
		return points;
	}

}

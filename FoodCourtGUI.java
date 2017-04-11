package gameFoodCourt;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class FoodCourtGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private ClockListener[] listeners;

	private Eatery[] eateries;

	private int nextPerson, cashierAvgTime, totTime, eateryAvgTime, leaveTime, numOfEateries;

	private int theThroughput, theTimeStartToFinish, theNumLeftInLine, theMaxCashierLine, maxPeople;

	private ArrayList<JTextField> list;

	JFrame frame;

	JPanel infoPanel;
	JPanel outputPanel;
	JPanel buttonPanel;

	/** North field labels */
	JLabel inputLabel;
	JLabel secondsToNextPersonLabel;
	JLabel cashierAverageTimeLabel;
	JLabel totalTimeLabel;
	JLabel eateryAverageTimeLabel;
	JLabel timeToLeaveLabel;
	JLabel numEateriesLabel;

	/** North field text */
	JTextField secondsToNextPerson;
	JTextField cashierAverageTime;
	JTextField totalTime;
	JTextField eateryAverageTime;
	JTextField timeToLeave;
	JTextField numEateries;

	/** South field labels */
	JLabel outputLabel;
	JLabel throughputLabel;
	JLabel timeStartToFinishLabel;
	JLabel numLeftInLineLabel;
	JLabel maxCashierLineLabel;

	/** South field text */
	JTextField throughput;
	JTextField timeStartToFinish;
	JTextField numLeftInLine;
	JTextField maxCashierLine;

	JButton start;
	JButton quit;

	/** Created by Ryan Beam */
	public FoodCourtGUI() {
		list = new ArrayList<JTextField>();
		// Clock clk = new Clock();
		// Eatery booth = new Eatery();
		//
		// game = new PersonProducer(booth, 20, 20);
		//
		// clk.add(game);
		// clk.add(booth);
		// clk.run(totTime);

		addPanels();
		addNorthLayout();
		addSouthLayout();
		addButtons();
		frameSet();

		frame.setLocationRelativeTo(null);
	}

	public void runSimulation() {
		Clock clk = new Clock();
		eateries = new Eatery[numOfEateries];
		listeners = new ClockListener[numOfEateries];

		for (int i = 0; i < numOfEateries; i++) {
			eateries[i] = new Eatery();
			listeners[i] = new PersonProducer(eateries[i], nextPerson, eateryAvgTime);
			clk.add(listeners[i]);
			clk.add(eateries[i]);
		}
		clk.run(totTime);
	}

	/** Created by Ryan Beam */
	private void addPanels() {
		infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(400, 200));
		infoPanel.setAlignmentX(LEFT_ALIGNMENT);

		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(300, 60));
		buttonPanel.setAlignmentX(CENTER_ALIGNMENT);

		outputPanel = new JPanel();
		outputPanel.setPreferredSize(new Dimension(400, 200));
		outputPanel.setAlignmentX(LEFT_ALIGNMENT);
	}

	/** Created by Ryan Beam */
	private void addNorthLayout() {
		inputLabel = new JLabel("--------------------------------Input Information--------------------------------");
		secondsToNextPersonLabel = new JLabel("Seconds to the next person     ");
		cashierAverageTimeLabel = new JLabel("Average seconds per cashier  ");
		totalTimeLabel = new JLabel("Total time in seconds                 ");
		eateryAverageTimeLabel = new JLabel("Average seconds per eatery    ");
		timeToLeaveLabel = new JLabel("Seconds before person leaves");
		numEateriesLabel = new JLabel("Number of eateries                     ");

		secondsToNextPerson = new JTextField(15);
		list.add(secondsToNextPerson);
		cashierAverageTime = new JTextField(15);
		list.add(cashierAverageTime);
		totalTime = new JTextField(15);
		list.add(totalTime);
		eateryAverageTime = new JTextField(15);
		list.add(eateryAverageTime);
		timeToLeave = new JTextField(15);
		list.add(timeToLeave);
		numEateries = new JTextField(15);
		list.add(numEateries);

		infoPanel.add(inputLabel);

		infoPanel.add(secondsToNextPersonLabel);
		infoPanel.add(secondsToNextPerson);

		infoPanel.add(cashierAverageTimeLabel);
		infoPanel.add(cashierAverageTime);

		infoPanel.add(totalTimeLabel);
		infoPanel.add(totalTime);

		infoPanel.add(eateryAverageTimeLabel);
		infoPanel.add(eateryAverageTime);

		infoPanel.add(timeToLeaveLabel);
		infoPanel.add(timeToLeave);

		infoPanel.add(numEateriesLabel);
		infoPanel.add(numEateries);
	}

	/** Created by Ryan Beam */
	private void addSouthLayout() {
		outputLabel = new JLabel("--------------------------------Output Information--------------------------------");
		throughputLabel = new JLabel("Throughput                                   ");
		timeStartToFinishLabel = new JLabel("Average time per Person          ");
		numLeftInLineLabel = new JLabel("Number of people in line            ");
		maxCashierLineLabel = new JLabel("Max Q length cashier line         ");

		throughput = new JTextField(15);
		timeStartToFinish = new JTextField(15);
		numLeftInLine = new JTextField(15);
		maxCashierLine = new JTextField(15);

		throughput.setEditable(false);
		timeStartToFinish.setEditable(false);
		numLeftInLine.setEditable(false);
		maxCashierLine.setEditable(false);

		outputPanel.add(outputLabel);

		outputPanel.add(throughputLabel);
		outputPanel.add(throughput);

		outputPanel.add(timeStartToFinishLabel);
		outputPanel.add(timeStartToFinish);

		outputPanel.add(numLeftInLineLabel);
		outputPanel.add(numLeftInLine);

		outputPanel.add(maxCashierLineLabel);
		outputPanel.add(maxCashierLine);
	}

	/** Created by Ryan Beam */
	private void addButtons() {
		start = new JButton("Start Simulation"); // Create the undo button
		quit = new JButton("Quit Simulation"); // Create the undo button

		buttonPanel.add(start);
		buttonPanel.add(quit); // Add button to the panel

		start.addActionListener(this); // Add the button to action listener
		quit.addActionListener(this); // Add the button to action listener
	}

	/** Created by Ryan Beam */
	private void frameSet() {
		frame = new JFrame();

		BorderLayout theLayout = new BorderLayout(); // Initialize the layout
		frame.setLayout(theLayout);

		frame.add(infoPanel, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.CENTER);
		frame.add(outputPanel, BorderLayout.SOUTH);

		frame.setPreferredSize(new Dimension(400, 480));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // Set the close
														// operation
		frame.pack(); // Pack the frame
		frame.setVisible(true); // Make the frame visible
	}

	/** Created by Ryan Beam */
	public void actionPerformed(ActionEvent e) {
		JComponent buttonPressed = (JComponent) e.getSource();

		if (buttonPressed == start) {
			if (checkInputs()) {
				getValues();
				runSimulation();
				getStats();
				changeText();
			} else {
				JOptionPane.showMessageDialog(null, "The values input are not valid.", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		if (buttonPressed == quit) {
			int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", null,
					JOptionPane.YES_NO_OPTION);

			if (n == JOptionPane.YES_OPTION) // quits if user hits yes
				System.exit(0);
		}

	}

	private void getValues() {
		nextPerson = Integer.parseInt(secondsToNextPerson.getText());
		cashierAvgTime = Integer.parseInt(cashierAverageTime.getText());
		totTime = Integer.parseInt(totalTime.getText());
		eateryAvgTime = Integer.parseInt(eateryAverageTime.getText());
		leaveTime = Integer.parseInt(timeToLeave.getText());
		numOfEateries = Integer.parseInt(numEateries.getText());
	}

	private void changeText() {
		throughput.setText("" + theThroughput + " people with max = " + maxPeople);
		timeStartToFinish.setText("" + theTimeStartToFinish + " seconds");
		numLeftInLine.setText("" + theNumLeftInLine + " people");
		maxCashierLine.setText("" + theMaxCashierLine);
	}

	private boolean checkInputs() {
		// checks all the JTextFiels to see if they're empty
		for (JTextField j : list) {
			if (j.getText().trim().isEmpty()) {
				return false;
			}
		}
		// checks all JTextField to make sure they all contain numbers
		for (JTextField j : list) {
			try {
				Integer.parseInt(j.getText());
			} catch (NumberFormatException e) {
				return false;
			}
		}

		return true;
	}

	private void getStats() {

	}

	/**
	 * Created by Ryan Beam Main function to start GUI, will start the game.
	 * 
	 * @param args
	 *            Input for current game
	 */
	public static void main(String args[]) {
		FoodCourtGUI game = new FoodCourtGUI(); // Start the game
	}
}

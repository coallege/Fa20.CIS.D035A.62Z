import javax.swing.*;

import java.awt.*;

// Read this class from top to bottom
class GUI {
	private static Coin coin = new Coin();

	private static Font MONOSPACED = new Font("monospaced", Font.PLAIN, 12);
	private static Font BIGMONOSPACED = new Font("monospaced", Font.PLAIN, 20);

	/**
	 * This is what is called in the Test::main function
	 */
	public static void run() {
		var frame = new JFrame();
		setupFrame(frame);
		showFrame(frame);
	}

	/**
	 * This is like the window that holds all the rest of the stuff
	 */
	private static void setupFrame(JFrame frame) {
		frame.setTitle("Cole Gannon's Coin Toss");
		frame.setSize(400, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		var tabs = new JTabbedPane();
		setupTabs(tabs);

		frame.setContentPane(tabs);
	}

	/**
	 * The main tab control in the window
	 */
	private static void setupTabs(JTabbedPane tabs) {
		var coinTossPanel = new JPanel();
		setupCoinTossPanel(coinTossPanel);
		tabs.addTab("Coin Toss", coinTossPanel);

		var coinToss20Panel = new JPanel();
		setupCoinToss20Panel(coinToss20Panel);
		tabs.addTab("Toss 20 Times", coinToss20Panel);
	}

	private static void setupCoinTossPanel(JPanel coinTossPanel) {
		var flipButton = new JButton("Toss");
		var sideLabel = new JLabel(coin.getSideUp().toString());
		sideLabel.setFont(BIGMONOSPACED);
		coinTossPanel.add(flipButton);
		coinTossPanel.add(sideLabel);

		flipButton.addActionListener(e -> {
			coin.toss();
			sideLabel.setText(coin.getSideUp().toString());
		});
	}

	private static void setupCoinToss20Panel(JPanel coinToss20Panel) {
		var toss20Button = new JButton("Toss x20");

		/**
		 * Yes, this is separated into model + view, annoyingly.
		 * You have to instantiate the model separately of the view which is what
		 * is happening below.
		 */
		var resultListModel = new DefaultListModel<String>();
		// i starts at 20. while i goes to 0, add an element that says "N/A"
		for (int i = 20; i --> 0;) {
			resultListModel.addElement("N/A     ");
		}

		var resultList = new JList<String>(resultListModel);
		setupResultsList(resultList);

		var results20 = new JLabel("<html>Heads: N/A<br>Tails: N/A</html>");
		results20.setFont(MONOSPACED);

		toss20Button.addActionListener(e -> {
			resultListModel.removeAllElements();
			int heads = 0;
			for (var face : coin.toss20()) {
				if (face == Coin.Face.heads) {
					heads++;
				}
				resultListModel.addElement(face.toString() + "   ");
			}

			results20.setText("<html>"
				+ "Heads: " + heads + "<br>"
				+ "Tails: " + (20 - heads)
				+ "</html>"
			);
		});

		coinToss20Panel.add(toss20Button);
		coinToss20Panel.add(resultList);
		coinToss20Panel.add(results20);
	}

	private static void setupResultsList(JList<String> list) {
		list.setSize(400, 300);
		list.setFont(MONOSPACED);
		list.setSelectionModel(new NoSelectModel());
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
	}

	private static void showFrame(JFrame frame) {
		frame.setVisible(true);
		frame.toFront();
		frame.requestFocus();
	}
}

import javax.swing.*;

import java.awt.*;

class GUI {
	private static Coin coin = new Coin();
	private static Font MONOSPACED = new Font("monospaced", Font.PLAIN, 12);
	private static Font BIGMONOSPACED = new Font("monospaced", Font.PLAIN, 20);
	public static void run() {
		var frame = new JFrame();
		frame.setTitle("Cole Gannon's Coin Toss");
		frame.setSize(400, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		var tabs = new JTabbedPane();

		var coinFlipPanel = new JPanel();
		var flipButton = new JButton("Toss");
		var sideLabel = new JLabel(coin.getSideUp().toString());
		sideLabel.setFont(BIGMONOSPACED);
		coinFlipPanel.add(flipButton);
		coinFlipPanel.add(sideLabel);
		flipButton.addActionListener(e -> {
			coin.toss();
			sideLabel.setText(coin.getSideUp().toString());
		});

		tabs.addTab("Coin Toss", coinFlipPanel);

		var flip20TimesPanel = new JPanel();
		var flip20Button = new JButton("Toss x20");

		var resultListModel = new DefaultListModel<String>();
		for (int i = 20; i --> 0;) {
			resultListModel.addElement("N/A     ");
		}
		var resultList = new JList<String>(resultListModel);
		resultList.setSize(400, 300);
		resultList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		resultList.setFont(MONOSPACED);
		resultList.setSelectionModel(new DefaultListSelectionModel() {
			@Override
			public void setAnchorSelectionIndex(final int anchorIndex) {}

			@Override
			public void setLeadAnchorNotificationEnabled(final boolean flag) {}

			@Override
			public void setLeadSelectionIndex(final int leadIndex) {}

			@Override
			public void setSelectionInterval(final int index0, final int index1) {}
		});

		var results20 = new JLabel("<html>Heads: N/A<br>Tails: N/A</html>");
		results20.setFont(MONOSPACED);

		flip20Button.addActionListener(e -> {
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
		flip20TimesPanel.add(flip20Button);
		flip20TimesPanel.add(resultList);
		flip20TimesPanel.add(results20);

		tabs.addTab("Toss 20 Times", flip20TimesPanel);
		frame.setContentPane(tabs);

		frame.setVisible(true);
		frame.toFront();
		frame.requestFocus();
	}
}

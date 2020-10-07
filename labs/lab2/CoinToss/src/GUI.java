import javax.swing.*;

import java.awt.*;

class GUI {
	private static Coin coin = new Coin();
	private static Font MONOSPACED = new Font("monospaced", Font.PLAIN, 12);
	public static void run() {
		var frame = new JFrame();
		frame.setTitle("Cole Gannon's Coin Toss");
		frame.setSize(500, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		var tabs = new JTabbedPane();

		var coinFlipPanel = new JPanel();
		tabs.addTab("Coin Flip", coinFlipPanel);

		var flip20TimesPanel = new JPanel();
		var flip20Button = new JButton("Flip 20");

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

		flip20Button.addActionListener(e -> {
			resultListModel.removeAllElements();
			for (var face : coin.toss20()) {
				resultListModel.addElement(face.toString() + "   ");
			}
		});
		flip20TimesPanel.add(flip20Button);
		flip20TimesPanel.add(resultList);
		tabs.addTab("Flip 20 Times", flip20TimesPanel);
		frame.setContentPane(tabs);

		frame.setVisible(true);
	}
}

import javax.swing.*;

class GUI extends JFrame {
	GUI(Coin c) {
		super.setSize(500, 300);
		super.setResizable(false);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
	}
}

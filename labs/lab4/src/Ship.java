public class Ship {
	// all of these methods are overrode by subclasses
	public void sail() {
		System.out.println("Oceanbound!");
	}

	public String type() {
		return "Normal";
	}

	public String whatsOnBoard() {
		return "Just the crew";
	}
}

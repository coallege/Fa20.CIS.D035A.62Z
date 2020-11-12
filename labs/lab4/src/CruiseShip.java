public class CruiseShip extends Ship {
	@Override
	public void sail() {
		System.out.println("All aboard?");
	}

	@Override
	public String type() {
		return "Cruise";
	}

	@Override
	public String whatsOnBoard() {
		return "Many passengers";
	}
}

public class CargoShip extends Ship {
	@Override
	public void sail() {
		System.out.println("I haul cargo...");
	}

	@Override
	public String type() {
		return "Cargo";
	}

	@Override
	public String whatsOnBoard() {
		return "A whole lot of cargo";
	}
}

public class ShipDriver {
	public static void main(String[] args) {
		final var ships = new Ship[10];

		// let's randomly make some ships
		for (var i = ships.length; i --> 0;) {
			final var rand = Math.random();
			if (rand < .4) {
				ships[i] = new Ship();
			} else if (rand < .7) {
				ships[i] = new CruiseShip();
			} else {
				ships[i] = new CargoShip();
			}
		}

		for (var ship : ships) {
			ship.sail();
			System.out.println(""
				+ "Hello, I am a "
				+ ship.type()
				+ " ship and I have "
				+ ship.whatsOnBoard()
				+ " on board"
			);
		}
	}
}

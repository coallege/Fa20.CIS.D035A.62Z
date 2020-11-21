import java.util.function.Predicate;

class TFlipFlopPredicate implements Predicate<Object> {
	private boolean on;

	@Override
	public boolean test(final Object dummy) {
		return this.on ^= true;
	}
}

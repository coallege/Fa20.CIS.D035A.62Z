import java.util.function.Predicate;

class TFlipFlopPredicate<dummy_t> implements Predicate<dummy_t> {
	private boolean on;

	@Override
	public boolean test(final dummy_t dummy) {
		return this.on ^= true;
	}
}

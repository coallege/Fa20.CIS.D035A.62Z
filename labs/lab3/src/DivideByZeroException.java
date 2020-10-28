import java.util.function.Supplier;

@SuppressWarnings("serial")
public class DivideByZeroException extends RuntimeException {
	DivideByZeroException(final String reason) {
		super(reason);
	}

	/**
	 * make :: String -> () -> DivideByZeroException
	 *
	 * Mostly useful for OptionalDouble.orElseThrow()
	 */
	static Supplier<DivideByZeroException> make(final String reason) {
		return () -> new DivideByZeroException(reason);
	}
}

import java.util.function.Supplier;

@SuppressWarnings("serial")
public class DivideByZeroException extends RuntimeException {
	DivideByZeroException(final String reason) {
		super(reason);
	}

	static Supplier<DivideByZeroException> make(final String reason) {
		return () -> new DivideByZeroException(reason);
	}
}

package functional;

@FunctionalInterface
public interface ThrowingRunnable {
	void run() throws Throwable;
}

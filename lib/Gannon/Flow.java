package Gannon;

import Gannon.functional.*;

public class Flow {
	public static void unchecked(ThrowingRunnable fn) {
		try {
			fn.run();
		} catch (Throwable e) {
			throw new Error(e);
		}
	}

	public static <T> T unchecked(ThrowingSupplier<T> fn) {
		try {
			return fn.get();
		} catch (Throwable e) {
			throw new Error(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T static_cast(Object val) {
		return (T) val;
	}
}

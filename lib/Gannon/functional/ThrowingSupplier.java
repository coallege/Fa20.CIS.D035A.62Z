package Gannon.functional;

public interface ThrowingSupplier<T> {
   T get() throws Throwable;
}

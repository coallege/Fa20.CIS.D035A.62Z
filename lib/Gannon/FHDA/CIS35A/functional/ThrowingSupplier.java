package Gannon.FHDA.CIS35A.functional;

public interface ThrowingSupplier<T> {
   T get() throws Throwable;
}

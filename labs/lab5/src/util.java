import java.nio.file.Path;

interface util {
	static String realpath(final Path p) {
		try {
			return p.toRealPath().toString();
		} catch (Throwable t) {
			return p.toString();
		}
	}
}

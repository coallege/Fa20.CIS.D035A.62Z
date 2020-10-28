package Gannon.FHDA.CIS35A.UMLGenerate;

import static java.lang.System.out;

import java.io.IOException;
import java.util.stream.Stream;

import java.nio.file.*;

public class ClassDirectory {
	ClassDirectory(String dir) {
		var abspath = Paths.get(dir).toAbsolutePath();
		out.println("Reading Class Files From " + abspath);
		try (Stream<Path> paths = Files.walk(abspath)) {
			paths
				 .filter(Files::isRegularFile)
				 .forEach(System.out::println);
		} catch (IOException a) {
			
		}
	}
}

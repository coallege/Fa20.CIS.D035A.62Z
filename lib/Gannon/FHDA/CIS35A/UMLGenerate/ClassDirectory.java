package Gannon.FHDA.CIS35A.UMLGenerate;

import static java.lang.System.out;

import java.util.stream.Stream;

import java.nio.file.*;

public class ClassDirectory {
	ClassDirectory(String dir) throws Exception {
		var abspath = Paths.get(dir).toAbsolutePath();
		out.println("Reading Class Files From " + abspath);
		Stream<Path> paths = Files.walk(abspath);
		paths
			.filter(Files::isRegularFile)
			.filter(f -> f.toString().endsWith(".class"))
			.forEach(System.out::println);
		paths.close();
	}
}

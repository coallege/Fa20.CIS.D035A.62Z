run:
	gradlew jar
	java -jar PersonalInformation.jar

build-without-gradle:
	javac -cp src -d bin $(wildcard src/**/*.java)
	jar cvfe PersonalInformation.jar test.Main $(wildcard bin/**/*.class)

clean:
	rd /s .gradle .settings bin build

uml:
	dot -Tpng UML.dot -o UML.png

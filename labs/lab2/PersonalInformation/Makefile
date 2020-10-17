jarfile  := PersonalInformation.jar
srcdir   := src
outdir   := build
srcfiles := $(wildcard $(srcdir)/**/*.java)

run: $(jarfile)
	java -jar $<

$(jarfile):
	gradlew jar

build-without-gradle:
	javac -cp src -d $(outdir) $(srcfiles)
	jar cvfe $(jarfile) test.Main -C $(outdir) .

clean:
	-rd /s .gradle $(outdir)
	-del $(jarfile)

uml:
	dot -Tpng UML.dot -o UML.png

.PHONY: run build-without-gradle clean

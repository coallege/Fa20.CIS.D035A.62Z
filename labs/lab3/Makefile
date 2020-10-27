src = $(wildcard src/*.java)
test = $(wildcard test/*.java)

run: build
	java -cp bin Driver

test: build build-tests
	java -cp "bin;lib/*" org.junit.runner.JUnitCore $(test:test/%.java=%)

build:
	javac -d bin $(src)

build-tests:
	javac -cp "src;lib/*" -d bin $(test)

.PHONY: run build

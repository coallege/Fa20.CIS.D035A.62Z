run: ComputeLoan.class LoanPayment.class LoanIterator.class Loan.class
	java ComputeLoan

build:
	javac $(wildcard *.java)

clean:
	del $(wildcard *.class)

%.class: %.java
	javac $<

.PHONY: run

IN_DIR ?= src
OUT_DIR ?= bin

src_files = $(wildcard $(IN_DIR)/*.java)
src_names = $(src_files:$(IN_DIR)/%.java=%)
artifacts = $(src_names:%=$(OUT_DIR)/%.class)

JAVAC_ARGS = -cp "$(IN_DIR);$(LIBS)" -d $(OUT_DIR) -parameters
JAVA_ARGS  = -cp "$(OUT_DIR);$(LIBS)"

default:
	@echo Please choose a target

$(OUT_DIR)/%.class: $(IN_DIR)/%.java
	@echo ----- MAK $< -----
	@-javac $(JAVAC_ARGS) $<

run~%: $(artifacts)
	$(eval J=$(notdir $(patsubst run~%,%,$@)))
	@echo ----- RUN $(J) -----
	@java $(JAVA_ARGS) $(J)
	@echo ----- END $(J) -----

clean:
	-rd /s /q "$(OUT_DIR)"

umlj = $(CURDIR)/../uml-jenerate-v0.0.2.jar

uml:
	java -jar $(umlj) $(CURDIR) $(CURDIR)/UML.dot $(CURDIR)/UML.png

.PHONY: default run~% clean
.SECONDARY:

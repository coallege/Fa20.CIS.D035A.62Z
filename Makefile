IN_DIR ?= src
OUT_DIR ?= bin

rwildcard = $(foreach d,$(wildcard $(1:=/*)),$(call rwildcard,$d,$2) $(filter $(subst *,%,$2),$d))
src_files = $(call rwildcard,$(IN_DIR),*.java)
src_names = $(src_files:$(IN_DIR)/%.java=%)
artifacts = $(src_names:%=$(OUT_DIR)/%.class)

JAVAC_ARGS = -cp "$(IN_DIR);$(LIBS)" -d $(OUT_DIR) -parameters
JAVA_ARGS  = -cp "$(OUT_DIR);$(LIBS)"

default:
	@echo $(MAKEFILE_LIST)

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

SELF_DIR := $(dir $(lastword $(MAKEFILE_LIST)))
umlj = $(SELF_DIR)/resources/uml-jenerate-v0.0.3.jar

uml:
	java -jar $(umlj) $(CURDIR) $(CURDIR)/UML.dot $(CURDIR)/UML.png

.PHONY: default run~% clean
.SECONDARY:

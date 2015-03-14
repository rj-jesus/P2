JDIR = $(shell find . -maxdepth 1 -type d ! -name '.' ! -name '*.git')
JC = javac
JFLAGS = -g

.PHONY : clean
clean :
	@echo "Cleaning up *.class files..."
	@find . -type f -name '*.class' -delete

all : clean
	@echo "Compiling all *.java files..."
	@for dir in $(JDIR);\
	do cd $$dir && $(JC) $(JFLAGS) *.java && cd ..; done

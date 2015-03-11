OBJ := $(shell find . -name '*.class')

.PHONY : clean
clean :
		@echo "Cleaning up *.class files..."
		@rm -rf $(OBJ)

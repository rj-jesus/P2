.PHONY : clean
clean :
	@echo "Cleaning up *.class files..."
	@find . -type f -name '*.class' -delete

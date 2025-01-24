# Makefile for automating Maven commands in Spring Boot

# Define variables
PROJECT_DIR := ./zamagcina-ngeyane
MAVEN := mvn
SPRING_BOOT := spring-boot:run

# Default target
.PHONY: all
all: clean compile run

# Clean the project (remove target directory and other compiled files)
.PHONY: clean
clean:
	@echo "Cleaning project..."
	cd $(PROJECT_DIR) && $(MAVEN) clean

# Compile the project
.PHONY: compile
compile:
	@echo "Compiling project..."
	cd $(PROJECT_DIR) && $(MAVEN) compile

# Run the Spring Boot application
.PHONY: run
run:
	@echo "Running Spring Boot application..."
	cd $(PROJECT_DIR) && $(MAVEN) $(SPRING_BOOT)

# Custom target to stop the application
.PHONY: stop
stop:
	@echo "Stopping Spring Boot application..."
	cd $(PROJECT_DIR) && $(MAVEN) spring-boot:stop

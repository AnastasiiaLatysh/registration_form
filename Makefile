.PHONY: run
run:
	mvn clean install spring-boot:repackage
	java -jar target/registration_form-1.0-SNAPSHOT.jar

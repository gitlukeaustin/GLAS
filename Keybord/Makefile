#
# Java Makefile
#

JC = javac
JCFLAGS = -g

JDOC = javadoc
JDOCFLAGS = -author
MAIN = controler/Main
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JCFLAGS) $*.java

JAVASRC = $(shell ls controler/*.java model/*.java view/*.java)
CLASSES = $(JAVASRC:.java=.class)

all: classes

default: classes

classes: $(CLASSES:.java=.class)

run:
	java -cp "mariadb-java-client-1.5.4.jar:." $(MAIN)
doc:
	mkdir -p doc
	$(JDOC) $(JDOCFLAGS) -d doc *.java

clean:
	rm -f *.class
	rm -fr doc
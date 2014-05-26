LIB_FILE = .:org.json.jar
JFLAGS = -cp $(LIB_FILE)
JC = javac
JVM= java
FILE=
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
CLASSES = \
	TocHW3.java

MAIN = TocHW3

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) $(JFLAGS) $(MAIN)

clean:
	$(RM) *.class

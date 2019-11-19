JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		Knapsack_conjunto.java \
		Knapsack_unbounded.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class
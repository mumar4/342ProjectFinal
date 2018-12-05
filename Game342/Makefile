GS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Game.java \
        Place.java \
	Direction.java \
	Artifact.java \
	GameTester.java \
	AI.java \
	Character.java \
	DecisionMaker.java \
	Drop.java \
	Exit.java \
	Get.java \
	Go.java \
	Inventory.java \
	KeyboardScanner.java \
	Look.java \
	Move.java \
	NPC.java \
	Player.java \
	UI.java \
	Use.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

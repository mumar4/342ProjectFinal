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
	Attack.java \
	Steal.java \
	Potions.java \
	Scroll.java \
	Heal.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

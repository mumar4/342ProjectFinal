//
//Name: Abdullah Umar, Netid: mumar4
//Name: Hamzah Quraishi, Netid: hqurai3
//Name: Abdullah Kidwai, Netid: akidwa2
//UIC
//Game342 V4
//Nov 14 2018
//
Readme.txt

//For VERSION 5.0 (HW 4)
How to Run Program:
1. "make" on command line
2. then 'java GameTester' 'filename' '# of players' (IF NO FILE GIVEN, PROMPT GIVEN INSIDE PROGRAM)
3. Program should work clearly. I added artifacts to be displayed with LOOK command to make it easier to grade. 
Also added some extra print statements to understand what the NPC is doing. 

Changes made from GDF 4.0 to 5.0:
1.) Added 2 places:
	1. Graveyard
	2. Tomb of the King
	

2.) Added 2 NPC types 
	1. Aggressive
		--> Steals and Attacks (Terrible Witch, The Ultimate thanos, Orochimaru).
	2. Friendly
		--> Heals a player or revives the dead player (Humble Healer).

3.) Added 4 artifacts 
	1. Dragon scroll: To be used for getting stolen items back.
	2. Ogre Scroll: To be used for getting stolen items back.
	3. Dead key: Allows you to get into the Tomb of the King to win the game.

4.) Changes some directions from locked to unlocked to incorporate Graveyard and Tomb of the king.

5.) Added New class:
	1. Potions.java (Implemented by Hamzah Quraishi)
		--> Extends Artifact.
		--> Regain health if lost.
		--> Goes away after use.
	2. Scroll.java (Implemented by Hamzah Quraishi)
		--> Extends Artifact.
		--> retrieves the last stolen item from the NPC.
	3. Attack.java (Implemented by Abdullah Umar)
		--> Extends Move.
		--> NPC attacks player.
		--> Player lose HP and when HP reaches 0, it dies and sent to graveyard.
	4. Steal.java (Implemented by Abdullah Umar)
		--> Extends Move.
		--> NPC steals random item from player if in the same room.
		--> Player can get the item back if they have a scroll.
	5. Heal.java (Implemented by Abdullah Kidwai)
		--> Extends Move.
		--> Gives three options to the player
			1. Regain all lost HP.
			2. Revive fellow player
			3. Do nothing.
		
6.) All NPCs now have a behavior:
	0: Normal NPC ("GO", "GET", "DROP", "USE")
	1: Aggressive NPC ("GO", "ATTACK", "STEAL")
	2: Friendly NPC ("HEAL")

7.) The player wins if they get the "Dead key" and open the "Tomb of the King."
 If both players die, the game ends and you lose. (Implemented by Abdullah Kidwai)


//----------------------------------------------------------
//----------------------------------------------------------

//FOR VERSION 4.0 (HW3)
How to Run Program: 
1. "make" on command line
2. then 'java GameTester'  'filename'  '# of players' (IF NO FILE GIVEN, PROMPT GIVEN INSIDE PROGRAM)
3. Program should work clearly. I added artifacts to be displayed with LOOK command to make it easier to grade. 
Also added some extra print statements to understand what the NPC is doing. 


NOTE: I implemented all functionalities, except the extra credit ones. 

//FOR VERSION 3.1 
How to Run Program: 
1. "make" on command line
2. then "java GameTester"

Implemented all functionalities:
- Private enum class dirType. In my program it's called 'DirType' NOT 'dirType'.
- Artifact class
- GET/DROP/USE artifact and INVE/INVENTORY 				
- Scanner constructor for every class








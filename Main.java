import java.util.ArrayList;
import java.util.Scanner;

/* 
Task 1: Modify an existing class (new methods and attributes.
Inventory.java -> class Inventory -> public static String getInventorySize() and public static int getInventorySize2(). Takes in the ArrayList of inventory and uses an enhanced for loop to iterate through the inventory, incrementing an int variable for each iteration. Returns a String that uses concatenation to show the user how many items are in their inventory in numerical form. This method is called when the user types in ‘i count’. InventorySize2() essentially does same thing but returns an int. 

Task 2: Add a new class (that actually enhances the game).
Endgame.java -> class Endgame -> public void done() gives the user their score after their inventory is at the minimum score, tells them how may items they need, and allows them to decide whether to continue or not. 
NPC.java -> class NPC -> creates NPC objects that help Detective Dan stay away from traps with riddles. 
Endgame.java -> class Endgame -> public void end() ends the game if the user continues to collect all 33 items and prints a nice message for them. 

Task 3: Create at least 15 rooms with items.
Rooms.java -> class Rooms -> 17 rooms are implemented. 

Task 4: Make the code more efficient or streamlined.
Main.java -> class Main -> public static void noExit(). This method is called when there is no exit for the direction the user typed in. Instead of having “You can’t go that way” typed out four different times, the method noExit() is called in four places instead. 

Task 5: Create a way to “win” the game.
When the player’s score reaches 250/330 (25/33 items collected), they have the option to “win” right away and finish with the minimum score, or they can continue playing and try to get more points. 

Task 6: Make the game more interactive better feedback, sounds, etc.
In addition to the riddles that the NPCs say, I put info to the room descriptions that add to the storyline. 

Optional Task 1: Add a theme - (horror – historic – puzzle -- adventure).
Theme is mystery, where the user is a detective searching for enough evidence in the suspect’s house to convict. 

Optional Task 2: Add a NPC (non-player character).
Classmates appear in the descriptions of rooms with a trap connected, and give Detective Dan a “riddle” that points him away from a trap. I used ChatGPT to generate the poems. Objects of the NPCs are created from the NPC class.

Optional Task 3: Not implemented. 
*/
public class Main  {
    public static void main(String args[]) {

        // Build rooms       
        final int HEIGHT = 15;
        final int WIDTH = 15;
        
        Room[][] room = new Room[HEIGHT][WIDTH];
        Rooms.build(room, HEIGHT, WIDTH);
        int row = 0;
        int col = 7;
        int score = 0;

        // Load inventory
        ArrayList<String> inventory = new ArrayList<>();
        
        // Title Screen
    	System.out.println("+-------------------------------+");
    	System.out.println("| Text Adventure: Detective Dan |");
    	System.out.println("+-------------------------------+");
    	
    	// Sounds.playTitleMusic(1);
    	
    	// Print starting room description
    	Rooms.print(room, row, col);

        // Start game loop
        boolean playing = true;
        while (playing) {

        	// Get user input
            String input = Input.getInput();

            // Movement commands
            if (input.equals("s")) {
                if (room[row][col].exits.contains("s")) {
                    row++;
                    Rooms.print(room, row, col);
                } else {
                    noExit();
                }
            } else if (input.equals("n")) {
                if (room[row][col].exits.contains("n")) {
                    row--;
                    Rooms.print(room, row, col);
                } else {
                    noExit();
                }
            } else if (input.equals("e")) {
                if (room[row][col].exits.contains("e")) {
                    col++;
                    Rooms.print(room, row, col);
                } else {
                    noExit();
                }
            } else if (input.equals("w")) {
                if (room[row][col].exits.contains("w")) {
                    col--;
                    Rooms.print(room, row, col);
                } else {
                    noExit();
                }
            }

            // Look commands
            else if (input.equals("look")) {
                Rooms.print(room, row, col);
            }

            // Get commands
            else if (input.length() > 4  && (input.substring(0, 4).equals("get ") || input.substring(0, 5).equals("take "))) {
                    if (input.substring(input.indexOf(' ')).length() > 1) {
                            String item = input.substring(input.indexOf(' ') + 1);
                         //  Sounds.playItemPickup();
                    score = Inventory.checkItem(row, col, item, inventory, room, score);
                    }	            
            }

            // Inventory commands
            else if (input.equals("i") || input.equals("inv")
                    || input.equals("inventory")) {
                Inventory.print(inventory);
            }          

            else if (input.length() > 5  && input.substring(0, 5).equals("drop ")) {
                   if (input.substring(input.indexOf(' ')).length() > 1) {
                        String item = input.substring(input.indexOf(' ') + 1);
                        Inventory.dropItem(inventory,item,room,row,col);
                    }	
            }
             
            else if (input.equals("score")) {
            	System.out.println("Score: " + score + "/350");
            }
            
            else if (input.equals("restart")) {
            	System.out.println();
            	Main.main(args);
            }
            
            else if (input.equals("help")) {
                System.out.println("These are the command you can type at the > prompt:");
            	System.out.println(" 'n'/'e'/'s'/'w' to move");
            	System.out.println(" 'look' for a description of the room you're in");
            	System.out.println(" 'get or take ' + the item to get something");
            	System.out.println(" 'i' to view your inventory");
              System.out.println(" 'i count' to view your inventory count");
            	System.out.println(" 'score' to view your score");
            	System.out.println(" 'restart' to restart the game");
            	System.out.println(" 'quit' to quit the game");
            } else if (input.equals("i count")){
              System.out.println(Inventory.getInventorySize(inventory));
            }
            
            // Quit commands
              else if (input.equals("quit") && Inventory.getInventorySize2(inventory) >= 24){
                System.out.println("YOU WIN. Your toal score was: "+ score + "/350. Goodbye!\nNote: All riddles were generated with ChatGPT due to the lack of poetry skills possessed by the maker of this game.");
                playing = false;
              }
            else if (input.equals("quit")) {
                System.out.println("Goodbye!\nNote: All riddles were generated with ChatGPT due to the lack of poetry skills possessed by the maker of this game.");
                playing = false;

            // Catch-all for invalid input
            } else {
                System.out.println("You can't do that.");
            }
        }
        System.exit(0);
    }
public static void noExit(){
  System.out.println("You can't go that way.");
}

}
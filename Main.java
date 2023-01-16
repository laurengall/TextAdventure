import java.util.ArrayList;
import java.util.Scanner;

/* 
Task 1: Inventory.java -> class Inventory -> public static String getInventorySize(). Takes in the ArrayList of inventory and uses an enhanced for loop to iterate through the inventory, incrementing an int variable for each iteration. Returns a String that uses concatenation to show the user how many items are in their inventory in numerical form. This method is called when the user types in ‘i count’. 

Task 2 and Optional Task 2: NPC.java -> class NPC -> public void chase() was the original plan for integrating an NPC into the game, but now it is just misleading ☹ . Now, classmates appear in the descriptions of rooms with a trap connected, and give Detective Dan a “riddle” that points him away from a trap. 

Task 3: Rooms.java -> class Rooms ->17 rooms are implemented. 
Task 4: Main.java -> class Main -> public static void noExit(). This method is called when there is no exit for the direction the user typed in. Instead of having “You can’t go that way” typed out four different times, the method noExit() is called in four places instead. 
Task 5: When the player’s score reaches 250/330 (25/33 items collected), they have the option to “win” right away and finish with the minimum score, or they can continue playing and try to get more points. 
Task 6: NPCs appear at “turning points” (places where one ends up trapped in a room or continues through the map). They give riddles/poems to the player, hinting at the right direction to go. I used ChatGPT to generate the poems. 

Optional Task 1: Theme is mystery, where the user is a detective searching for enough evidence in the suspect’s house to convict. 
Optional Task 3
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
    	System.out.println("Disclaimer: \nThe maker of this game is lacking in poetry skills. \nRiddles were generated with ChatGPT. \nCopyright OpenAI 2023."); 
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
            	System.out.println("Score: " + score + "/330");
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
                System.out.println("YOU WIN. Your toal score was: "+ score + "/330. Goodbye!");
                playing = false;
              }
            else if (input.equals("quit")) {
                System.out.println("Goodbye!");
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


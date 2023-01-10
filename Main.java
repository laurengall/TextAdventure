import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	
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
    	System.out.println("| Text Adventure: Detective Work |");
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
                    System.out.println("You can't go that way.");
                }
            } else if (input.equals("n")) {
                if (room[row][col].exits.contains("n")) {
                    row--;
                    Rooms.print(room, row, col);
                } else {
                    System.out.println("You can't go that way.");
                }
            } else if (input.equals("e")) {
                if (room[row][col].exits.contains("e")) {
                    col++;
                    Rooms.print(room, row, col);
                } else {
                    System.out.println("You can't go that way.");
                }
            } else if (input.equals("w")) {
                if (room[row][col].exits.contains("w")) {
                    col--;
                    Rooms.print(room, row, col);
                } else {
                    System.out.println("You can't go that way.");
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
            	System.out.println("Score: " + score + "/500");
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
/*
  public static void countdown(){
  String input = Input.getInput();
  int count = 20; 
  String roomName = Rooms.getName(); 
    while (roomName != "Entry Way" && count > 0){
    if (input.equals("n") || input.equals("s") ||input.equals("e") ||input.equals("w")) {
      count--; 
    }
    }

    if (count == 0 && roomName != "Entry Way"){
      System.out.println("You were taken hostage by the suspect, never to be seen again."); 
    }

    if (count > 0 && roomName == "Entry Way"){
      System.out.println("You escaped the suspect's house with enough evidence to make an arrest! YOU WIN."); 
    }
    
    
  } 
*/
}


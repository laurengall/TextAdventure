import java.util.ArrayList;

class Inventory {

    public static int checkItem(int row, int col, String item,  ArrayList<String> inventory, Room[][] room, int score) {
      
NPC npc = new NPC("Todd", false); 
       
      if (inventory.size() == 24){
        npc.chase(score); 
        
        
      }
      


        // Check if item is a valid room item
        boolean validRoomItem = false;
        for (String roomItems : room[row][col].items) {
            if (roomItems.equals(item)) {
                validRoomItem = true;
                break;
            }
        }

        // Check if item is already in inventory
        boolean inInventory = false;
        for (String itemInInv : inventory) {
            if (itemInInv.equals(item)) {
                inInventory = true;
                break;
            }
        }

        // Text output
        if (!inInventory && validRoomItem) {
            //Sounds.playItemPickup();
            System.out.println("You pick up the " + item + ".");
            inventory.add(item);
            score += 10;
            Rooms.removeItem(room, row, col, item);
        } else if (inInventory) {
            System.out.println("You already have the " + item + ".");
        } else if (!validRoomItem) {
            System.out.println("You don't see that here.");
        } else {
            System.out.println("I don't understand.");
        }

        return score;
    }

  

    public static void print(ArrayList<String> inventory) {

        System.out.println("Inventory:");
        for (String item : inventory) {
            System.out.println(item);
        }
    }

    public static void dropItem(ArrayList<String> inventory, String item, Room[][] room, int row, int col) {

        if (inventory.contains(item)) {      
            System.out.println("You drop the " + item);
            inventory.remove(item);
            room[row][col].setItems(item);
        } else {
            System.out.println("You don't have the " + item);
        }

    }

  public static String getInventorySize(ArrayList<String> inventory){
    int invCount = 0;
    for(String i: inventory){
      invCount++;
    } return "There are " + invCount + " items in your inventory"; 
  }

  public static int getInventorySize2(ArrayList<String> inventory){
    int invCount2 = 0;
    for(String i: inventory){
      invCount2++;
    } return invCount2; 
  }
  
  
        
} 

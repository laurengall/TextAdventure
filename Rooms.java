import java.util.ArrayList;

class Rooms {

    static String exits[] = new String[4];
            
    public static void build(Room[][] room, final int HEIGHT, final int WIDTH) {

    	// Initialize rooms
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                room[i][j] = new Room(i, "", "", null);
            }
        }

        // Entry Way row 0 col 7
        exits[0] = ""; exits[1] = "s"; exits[2] = ""; exits[3] = "";
        room[0][7].setNumber(0);
        room[0][7].setName("Entry Way");
        room[0][7].setDescription("You are in the entryway to the suspect's house.\nYou must get at least 25 items to win.\nGather all 33 items to get a perfect score.");
        room[0][7].setItems("newspaper");
        room[0][7].setItems("small box");
        room[0][7].setExits(exits);
        
        // Hallway to Foyer row 1 col 7
        exits[0] = "n"; exits[1] = "s"; exits[2] = ""; exits[3] = "";
        room[1][7].setNumber(1);
        room[1][7].setName("Hallway to the Foyer");
        room[1][7].setDescription("You are in the Hallway to the Foyer.");
        room[1][7].setItems("dead mouse");
        room[1][7].setItems("ransom note");
        room[1][7].setExits(exits);

      // Foyer row 2 col 7
        exits[0] = "n"; exits[1] = "s"; exits[2] = ""; exits[3] = "w";
        room[2][7].setNumber(2);
        room[2][7].setName("Foyer");
        room[2][7].setDescription("You are in the Foyer.\nSunlight filters through a skylight.\nCaden D. says:\n The setting sun, a hint of where to steer,\n West is not the way, it'll bring you only fear.\n Go south, and find what you've been missing,\n A new horizon, forever dismissing.");
        room[2][7].setItems("keys");
        room[2][7].setItems("rat poison");
        room[2][7].setExits(exits);

      // Kitchen row 3 col 7
        exits[0] = "n"; exits[1] = ""; exits[2] = "e"; exits[3] = "w";
        room[3][7].setNumber(3);
        room[3][7].setName("Kitchen");
        room[3][7].setDescription("You are in the kitchen. \nLauren G says: \n The rising moon, a hint of where to be, \n East is not the way, it'll lead you astray.\n Go west, and find what you've been yearning, \n A new adventure, forever churning.");
        room[3][7].setItems("bent fork");
        room[3][7].setItems("bloody knife");
        room[3][7].setExits(exits);

      //  Private Bathroom row 1 col 1
      exits[0] = ""; exits[1] = "s"; exits[2] = ""; exits[3] = "";
        room[1][1].setNumber(4);
        room[1][1].setName("Private Bathroom");
        room[1][1].setDescription("You are in the private bathroom.");
        room[1][1].setItems("hair dye");
      room[1][1].setItems("comb");
        room[1][1].setItems("colored contacts");
      room[1][1].setExits(exits);

      // Master Bedroom row 2 col 1
      exits[0] = "n"; exits[1] = ""; exits[2] = "e"; exits[3] = "w";
        room[2][1].setNumber(5);
        room[2][1].setName("Master Bedroom");
        room[2][1].setDescription("You are in the master bedroom.\nYou hear shuffling downstairs.");
      room[2][1].setItems("murder mystery novel");
        room[2][1].setItems("remote");
      room[2][1].setItems("blanket");
      room[2][1].setExits(exits);

      // Closet row 2 col 0
      exits[0] = ""; exits[1] = "s"; exits[2] = "e"; exits[3] = "";
        room[2][0].setNumber(6);
        room[2][0].setName("Closet");
        room[2][0].setDescription("You are in the closet.\nDavid F. says: \n If south brings you warmth and west brings you sea, \n But your destination is where you'll be free. \n Go back east, and on the right path you'll stay,\n Turn south and you'll wander astray.");
      room[2][0].setItems("wig");
        room[2][0].setItems("ripped t-shirt");
      room[2][0].setExits(exits);
      // Guest Bedroom row 3 col 1
      exits[0] = ""; exits[1] = ""; exits[2] = "e"; exits[3] = "";
        room[3][1].setNumber(7);
        room[3][1].setName("Guest Bedroom");
        room[3][1].setDescription("You are in the guest bedroom. You hear a scream from the basement.");
      room[3][1].setItems("lead pipe");
        room[3][1].setItems("leather gloves");
room[3][1].setExits(exits);
      // Guest Bathroom row 3 col 2
      exits[0] = ""; exits[1] = "s"; exits[2] = "e"; exits[3] = "w";
        room[3][2].setNumber(8);
        room[3][2].setName("Guest Bathroom");
        room[3][2].setDescription("You are in the guest bathroom.\nBill L. says: I always point you in the opposite direction of down,\n Go east or west, but never south, in this town.");
      room[3][2].setItems("empty prescription bottle");
        room[3][2].setItems("blood stained towel");
      room[3][2].setItems("hair brush");
room[3][2].setExits(exits);
      // Office row 3 col 3
      exits[0] = "n"; exits[1] = ""; exits[2] = "e"; exits[3] = "w";
        room[3][3].setNumber(9);
        room[3][3].setName("Office");
        room[3][3].setDescription("You are in the office.");
      room[3][3].setItems("computer mouse");
        room[3][3].setItems("paper file");
room[3][3].setExits(exits);
      // Entrance to Master Bedroom row 2 col 2
      exits[0] = ""; exits[1] = ""; exits[2] = "e"; exits[3] = "w";
        room[2][2].setNumber(10);
        room[2][2].setName("Entrance to Master Bedroom");
        room[2][2].setDescription("You are in the entrance to master bedroom.");
      room[2][2].setItems("lone sock");
room[2][2].setExits(exits);
      // Hallway to Master Bedroom row 2 col 3
      exits[0] = ""; exits[1] = "s"; exits[2] = ""; exits[3] = "w";
        room[2][3].setNumber(11);
        room[2][3].setName("Hallway to Master Bedroom");
        room[2][3].setDescription("You are in the hallway to master bedroom.");
      room[2][3].setItems("pen");
      room[2][3].setItems("broken bottle");
room[2][3].setExits(exits);
      // Gym row 2 col 4
      exits[0] = "n"; exits[1] = "s"; exits[2] = ""; exits[3] = "";
        room[2][4].setNumber(12);
        room[2][4].setName("Gym");
        room[2][4].setDescription("You are in the gym.\nMathias M. says: \n Where sweat is shed and muscles are made,\n From there a new direction to take.\n Go south, young, one, and success you'll find, \n Your goal is waiting, just one step behind.");
      room[2][4].setItems("dumbbell");
      room[2][4].setItems("resistance band");
room[2][4].setExits(exits);
      // Garage row 4 col 4
      exits[0] = "n"; exits[1] = ""; exits[2] = "e"; exits[3] = "";
        room[4][4].setNumber(13);
        room[4][4].setName("Garage");
        room[4][4].setDescription("You are in the garage.\nIt smells like bleach and there are plastic tarps on the floor.\nRyan F. says:\n The rising sun, a hint of where to go,\n East is not the way, you'll only end up slow.\n Go north, and find what you've been searching for,\n A journey's end, forever to adore.");
      room[4][4].setItems("socket wrench");
room[4][4].setExits(exits);
      // Gaming room row 3 col 4
      exits[0] = "n"; exits[1] = "s"; exits[2] = "e"; exits[3] = "w";
        room[3][4].setNumber(14);
        room[3][4].setName("Gaming Room");
        room[3][4].setDescription("You are in the gaming room.");
      room[3][4].setItems("controller");
      room[3][4].setItems("flash drive");
      room[3][4].setExits(exits);
      // Family room row 3 col 5
      exits[0] = ""; exits[1] = ""; exits[2] = "e"; exits[3] = "w";
        room[3][5].setNumber(16);
        room[3][5].setName("Family Room");
        room[3][5].setDescription("You are in the family room.\nThere are no family photographs or personalized items.");
      room[3][5].setItems("movie disc");
      room[3][5].setItems("string");
      room[3][5].setExits(exits);
      // Dining room row 3 col 6
      exits[0] = ""; exits[1] = ""; exits[2] = "e"; exits[3] = "w";
        room[3][6].setNumber(15);
        room[3][6].setName("Dining Room");
        room[3][6].setDescription("You are in the dining room.");
      room[3][6].setItems("chair leg");
      room[3][6].setItems("shattered plate");
      room[3][6].setExits(exits);
        
    }

    public static void print(Room[][] room, int x, int y) {

    	System.out.println();
        
        if (!room[x][y].getItems().isEmpty()) {
            System.out.println(room[x][y].getDescription() + " - at Position: " + x + "," + y);
            System.out.println("You see: " + room[x][y].getItems()) ;      
        }
         
         else {
            System.out.println("You see nothingness: " + " - in Position: " + x + "," + y);
      
         }
    }
  

    // Remove item from room when added to inventory
    public static void removeItem(Room[][] room, int x, int y, String item) {
    	
    	room[x][y].deleteItem(item);
    }
}

class Room {

    private int number;
    private String name;
    private String description;
    private boolean locked = false;
    public ArrayList<String> items = new ArrayList<>();
    public ArrayList<String> exits = new ArrayList<>();

    public Room(int number, String name, String description,
            ArrayList<String> items) {
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    
     public boolean isLocked() {
        return this.locked;
    }

    public void setItems(String item) {
        this.items.add(item);
    }
    
    public void setExits(String exit[]) {
        for(int i = 0; i < exit.length; i++)
            this.exits.add(exit[i]);
    }
    
     public void setLocked(boolean locked) {
         this.locked = locked;
    }

    public void deleteItem(String item) {
        this.items.remove(item);
    }

    public ArrayList<String> getItems() {
        return this.items;
    }
  
  
}

class item {
    
    private String name;
    private String description;
    private boolean hidden = false;
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
     public String getDescription() {
        return this.description;
    }
     
     public void setHidden(boolean hidden) {
         this.hidden = hidden;
    }
    
}


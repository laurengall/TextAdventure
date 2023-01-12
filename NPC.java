
 public class NPC {

private String npcName; 
private boolean isActive; 

  public NPC(String npcName, boolean isActive){
  
  }

public void setNpcName(String npcName) {
  this.npcName = npcName; 
}

  public String getNpcName(){
    return this.npcName;
  }

public void setIsActive(boolean isActive){
  this.isActive = isActive; 
}
  public boolean getIsActive(){
    return this.isActive; 
  }


public void chase(int score){
isActive = true; 
  
  
  System.out.println("Your current score is "+ score + "/330"); 
  
  System.out.println("Press 1 to keep playing, press 2 to quit the game."); 
  
String input = Input.getInput();
  
boolean keepAsking = true; 
  
  while (keepAsking == true) {
    if (input.equals("1")){
    System.out.println("You need eleven more items. Please continue playing. You can quit the game at any time by typing 'quit'. You will still win the game."); 
      keepAsking = false; 
  } 
    else if (input.equals("2")){
    System.out.println("YOU WIN. TOTAL SCORE: " + score + "/330"); 
      keepAsking = false; 
        System.exit(0);
  }
    else {
   System.out.println("Please type 1 to resume the game or 2 to quit the game."); 
      keepAsking = true; 
      input = Input.getInput();
  }
  
  
  
  }
          
   
 }
 

 
 }
    
  
  




  

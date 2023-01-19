public class Endgame {

public void done(int score){
 
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
 public void end(int score){
   System.out.println("Congratulations, you collected 33/33 items and finished the game with a perfect score. The suspect is serving a life sentence thanks to your evidence.");
   System.exit(0); 
 }
 }
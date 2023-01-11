
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


public void chase(){
isActive = true; 
System.out.println("You have all of the evidence you need! But, alas, the suspect has discovered you are in the house! Get back to the Entry Way in less that 20 moves."); 
  
System.out.println(npcName + " is in pursuit!"); 

}

    
    }
  




  

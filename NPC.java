public class NPC {

private String npcName; 
private String words; 

  public NPC(){
  npcName = "";
    words = "";
  }
public NPC(String n, String w){
  npcName = n; 
  words = w; 
}
  

public void setNpcName(String npcName) {
  this.npcName = npcName; 
}

  public String getNpcName(){
    return npcName;
  }

public void setWords(String words){
  this.words = words; 
}
  public String getWords(){
    return words; 
  }
 
 
 }
    
  




  

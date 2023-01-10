import java.util.Scanner;

public class Input {
	
    public static String getInput() {
    	
        System.out.print("\r> ");
        Scanner scanIn = new Scanner(System.in);
        String input = scanIn.nextLine();
        
        return input.toLowerCase();
    }
}


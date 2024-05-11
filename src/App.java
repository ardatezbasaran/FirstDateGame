import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args){

        System.out.println("-------- First Date ---------");
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.println("3. Quit");
        int choice = Integer.parseInt(System.console().readLine());
        if(choice == 1) newGame();
        else if (choice == 2) loadGame();
        else if (choice == 3) System.exit(0);
        else{
            System.err.println("Invalid Choice!");
            System.out.println("Please enter a number between 1 and 3.");
        }

        
        
    }

    public static void newGame(){
        // Create a new game object
        System.out.println("Please set difficulty between 1 to 5: ");
        int diff = Integer.parseInt(System.console().readLine());
        if(diff < 1 || diff > 5){
            System.out.println("Invalid Choice! Difficulty must be between 1 and 5.");
            return;
        }
        //switch(diff){
       /*  case 1:
            Game gm = new GameLevel1();
            break;
        case 2:
            Game gm = new GameLevel2();
            break;
        
        case 3:
            Game gm = new GameLevel3();
            break;
        case 4:
            Game gm = new GameLevel4();
            break;
        case 5:
            Game gm = new GameMaster();
            break;
        }*/
    // Start the game loop for this particular game


    }

    public static void loadGame() {
        System.out.println("Select a saved game:");

        // List available saved games
        File[] savedGames = new File("src/savedGames").listFiles();
        if (savedGames == null || savedGames.length == 0) {
            System.out.println("No saved games found.");
            return;
        }

        // Display numbered list of saved games
        int index = 1;
        for (File savedGame : savedGames) {
            System.out.printf("%d. %s\n", index++, savedGame.getName());
        }

        // Get user's choice
        int choice = Integer.parseInt(System.console().readLine());
        if (choice < 1 || choice > savedGames.length) {
            System.out.println("Invalid choice.");
            return;
        }

        // Read game data from chosen file
        File chosenFile = savedGames[choice - 1];
        try (Scanner scanner = new Scanner(chosenFile)) {
            // Store relevant game data variables (e.g., level, progress, difficulty)
            int level = scanner.nextInt();
            // ... add other data as needed ...

            // Create game object based on loaded data
           // Game game;
           /*  switch (level) {
                case 1:
                    game = new GameLevel1();
                    // ... set other game variables based on data ...
                    break;
                case 2:
                    game = new GameLevel2();
                    // ... set other game variables based on data ...
                    break;
                // ... and so on for other levels ...
                default:
                    System.out.println("Unknown game level. Cannot load.");
                    return;
            }*/

            // Start the game loop with loaded data
            // ... your game loop implementation ...
        } catch (FileNotFoundException e) {
            System.err.println("Error reading saved game file: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Invalid input format in saved game file.");
        }
    }

        

    
    
    
    
    
    

    


}

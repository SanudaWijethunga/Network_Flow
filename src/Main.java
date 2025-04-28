import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //get file name
        String fileName = getFIleName(input);
        System.out.println();
        System.out.println("File path : " + fileName);
        //call the method to process the data
        FileInputReader.processFileData(fileName);
    }
    private static String getFIleName(Scanner input){
        int userInput , fileNumber;
        String fileName;
        //display the menu
        System.out.println("""
    
    1 : Bridge file
    2 : Ladder file
    0 : Exit
    """);
        while (true){
            try{
                System.out.print("Enter the file type you want : ");
                userInput = input.nextInt();
                switch (userInput){
                    case 0:
                        // exit from the program
                        System.out.println("Exited");
                        System.exit(0);
                        break;
                    case 1:
                        // bridge files
                        fileNumber = getFileNumber("bride", 19, input);
                        fileName = "benchmarks/bridge_" + fileNumber + ".txt";
                        return fileName;
                    case 2:
                        // ladder files
                        fileNumber = getFileNumber("ladder",20, input);
                        fileName = "benchmarks/ladder_" + fileNumber + ".txt";
                        return fileName;
                    case 3 :
                        //test file
                    default:
                        System.out.println("Enter 1 or 2 to select file type or enter 0 to exit");
                        input.nextLine();
                }
            }
            catch (Exception e){
                System.out.println("Enter 1 or 2 to select file type or enter 0 to exit");
                input.nextLine();
            }
        }
    }
    private static int getFileNumber(String fileName, int endNumber, Scanner input){
        int userInput;
        while (true){
            System.out.print("Enter the " + fileName + " file number (1 - " + endNumber + "): ");
            try {
                userInput = input.nextInt();
                //validate the file number range
                if (1 <= userInput && userInput <= endNumber){
                    return userInput;
                }
                else {
                    System.out.println("The file number should be between " + 1 + " and " + endNumber + ".");
                }
            }
            catch (Exception e){
                System.out.println("Enter a number for the file number");
                input.nextLine();
            }
        }
    }
}
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String fileName = getFIleName(input);
        System.out.println(fileName);

        readData(fileName);

    }
    private static String getFIleName(Scanner input){
        int userInput , fileNumber;
        String fileName;

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
                    default:
                        System.out.println("Enter 1,2 to select file type or enter 0 to exit");
                        input.nextLine();
                }
            }
            catch (Exception e){
                System.out.println("Enter a number according to the file type");
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
                System.out.println("Enter a number");
                input.nextLine();
            }
        }
    }
    private static void readData(String filename) {
        int fromVertex, toVertex, capacity, numberOfVertices;
        try {
            File file = new File(filename);
            Scanner fileReader = new Scanner(file);

            //read the number of vertices
            numberOfVertices = Integer.parseInt(fileReader.nextLine().trim());
            NetworkGraph networkGraph = new NetworkGraph(numberOfVertices);

            //read the start vertex, end vertex and the edge capacity
            while (fileReader.hasNextLine()) {
                String[] connections = fileReader.nextLine().trim().split(" ");
                for (int i = 0; i < connections.length; i += 3) {
                    fromVertex = Integer.parseInt(connections[0]);
                    toVertex = Integer.parseInt(connections[1]);
                    capacity = Integer.parseInt(connections[2]);
                    //create a new edge using the read data
                    networkGraph.createNewEdge(fromVertex,toVertex,capacity);
                }
            }
            //display the graph as adjacency list
            networkGraph.displayAdjacencyList();
        }
        catch (IOException e) {
            System.out.println("Can not find the file");
        }
    }
}
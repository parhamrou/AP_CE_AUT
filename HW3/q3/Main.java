import java.util.Scanner;
/**
 * This is the Main class that contains the psvm.
 */
public class Main {
    public static void main(String[] args) {
        /**
         * In the main method of this class, we get the input 
         * from the user and call the proper methods;
         */
        Scanner input = new Scanner(System.in);
        Graph graph = new Graph();
        
        String choice = input.nextLine();

        while (!choice.equals("exit")) {
            if (choice.contains("addVertex")) {
                String[] strVertex = choice.split(" ");
                int vertex = Integer.parseInt(strVertex[1]);
                graph.addVertex(vertex);
            
            } else if (choice.contains("addEdge")) {
                String[] strVertes = choice.split(" ");
                int source = Integer.parseInt(strVertes[1]);
                int destination = Integer.parseInt(strVertes[2]);
                graph.addEdge(source, destination);    
            
            } else if (choice.contains("removeEdge")) {
                String[] strVertes = choice.split(" ");
                int source = Integer.parseInt(strVertes[1]);
                int destination = Integer.parseInt(strVertes[2]);
                graph.removeEdge(source, destination);
            
            } else if (choice.equals("print")) {
                graph.printGraph();
            
            } else {
                System.out.println("Invalid input!");
            }
            choice = input.nextLine();
        }
    }
}

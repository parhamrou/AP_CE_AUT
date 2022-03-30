import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * In this class we have the methods that are used to
 * handle the commnads that are entered by user in main method.
 * In the method we have a hashmap that maps each vertex to its neighbor vertices.
 */
public class Graph {

    HashMap<Integer, ArrayList<Integer>> graph;
    
    // constructore
    public Graph() {
        graph = new HashMap<>();
    }

    public void addVertex(int vertex) {
        Integer integer = vertex;
        ArrayList<Integer> arrayList = new ArrayList<>();
        graph.put(integer, arrayList);
    }

    /**
    * This method is used to add edge to our graph.
    * @param source  This is the source vertex.
    * @param destination  This is the destination vertex.
    */
    public void addEdge(int source, int destination) {
        graph.get(source).add(destination);
    }

    /**
    * This method is used to remove a edge from our graph.
    * @param source This is the source vertex.
    * @param destination This is the destination vertex.
    */
    public void removeEdge(int source, int destination) {
        Integer integer = destination;
        graph.get(source).remove(integer);
    }

    /**
    * This method is used to print our graph.
    * It prints each vertex and its neighbor vertices.
    */
    public void printGraph() {
        //finding the minimum for printing the graph sorted
        
        Collections.sort(graph);
        System.out.println("Graph {");
        for (Map.Entry<Integer, ArrayList<Integer>> entry : graph) {
            System.out.format("%d: ", entry.getKey());
            for (Integer integer : entry.setValue()) {
                System.out.format("%d ", integer);
            }
            System.out.println();
        }
        System.out.println("}");
    }

}
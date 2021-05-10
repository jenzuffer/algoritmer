package Algoritmer;

import Implementation.queue.Queue;
import Interfaces.Edge;
import Interfaces.Graph;

public class BFS {

    private boolean[] marked;
    private Queue pq;

    //Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges
    public BFS(Graph graph, int startNode){
        this.marked = new boolean[graph.getVertiesCount()];
        marked[startNode] = true;
        pq = new Queue();
        pq.enqueue(startNode);

        while (!pq.isEmpty()){
            int dequeue = (int) pq.dequeue();
            System.out.println("Dequeue: " + dequeue);
            for (Edge edge : graph.adj(dequeue)) {
                float weight = edge.getWeight();
                int to = edge.to();
                if (!marked[to]){
                    marked[to] = true;
                    pq.enqueue(to);
                    System.out.println("weight: " + weight + " to: " + to);
                }
            }
        }
    }
}

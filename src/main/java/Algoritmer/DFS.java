package Algoritmer;

import Implementation.queue.Queue;
import Interfaces.Edge;
import Interfaces.Graph;

public class DFS {

    private boolean[] marked;
    private Queue pq;

    public DFS(Graph graph, int startNode) {
        pq = new Queue();
        pq.enqueue(startNode);
        marked = new boolean[graph.getVertiesCount()];
        while (!pq.isEmpty()) {
            int dequeue = (int) pq.dequeue();
            System.out.println(dequeue);
            fillDFS(graph, dequeue);
        }
    }

    public void fillDFS(Graph graph, int dequeue) {
        for (Edge edge : graph.adj(dequeue)) {
            int to = edge.to();
            if (!marked[to]) {
                pq.enqueue(to);
                marked[to] = true;
                fillDFS(graph, to);
            }
        }
    }
}

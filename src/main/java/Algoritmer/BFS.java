package Algoritmer;

import Implementation.queue.Queue;
import Interfaces.Graph;

public class BFS {

    private boolean[] marked;
    private Queue pq;

    public BFS(Graph graph, int startNode){

        marked[startNode] = true;
        pq = new Queue();
        pq.enqueue(startNode);

        while (!pq.isEmpty()){

        }

    }
}

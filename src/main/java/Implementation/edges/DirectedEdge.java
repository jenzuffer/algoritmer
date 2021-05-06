package Implementation.edges;

import Interfaces.Edge;

public class DirectedEdge implements Edge {
    private final int vertexFrom;
    private final int vertexTo;
    private final float weight;


    public DirectedEdge(int vertexFrom, int vertexTo, float weight) {
        if (vertexFrom < 0) throw new IllegalArgumentException("Vertex names must be non-negative integers");
        if (vertexTo < 0) throw new IllegalArgumentException("Vertex names must be non-negative integers");
        if (weight <= 0) throw new IllegalArgumentException("Weight is lower then 0 or eaquel to 0 which is to low ");
        this.vertexFrom = vertexFrom;
        this.vertexTo = vertexTo;
        this.weight = weight;
    }


    @Override
    public int from() {
        return vertexFrom;
    }

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public int to() {
        return vertexTo;
    }

    public String toString() {
        return vertexFrom + "->" + vertexTo + " " + String.format("%5.2f", weight);
    }

    @Override
    public int compareTo(Edge o) {
        if (this.getWeight() < o.getWeight()) return -1;
        else if (this.getWeight() > o.getWeight()) return +1;
        else return 0;
    }
}

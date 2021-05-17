package Implementation.edges;

import Interfaces.Edge;

public class EdgeImpl implements Edge {

    private final int vertexFrom;
    private final int vertexTo;
    private final float weight;


    public EdgeImpl(int vertexFrom, int vertexTo, float weight) {
        if (vertexFrom < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
        if (vertexTo < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.vertexFrom = vertexFrom;
        this.vertexTo = vertexTo;
        this.weight = weight;
    }

    /**
     * Returns the weight of this edge.
     *
     * @return the weight of this edge
     */
    @Override
    public float getWeight() {
        return weight;
    }


    /**
     * Returns either endpoint of this edge.
     *
     * @return either endpoint of this edge
     */
    public int either() {
        return vertexFrom;
    }


    public int other(int vertex) {
        if (vertex == vertexFrom) return vertexTo;
        else if (vertex == vertexTo) return vertexFrom;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    /**
     * Returns a string representation of this edge.
     *
     * @return a string representation of this edge
     */
    public String toString() {
        return String.format("%d-%d %.5f", vertexFrom, vertexTo, weight);
    }

    @Override
    public int from() {
        return vertexFrom;
    }

    @Override
    public int to() {
        return vertexTo;
    }


    @Override
    public int compareTo(Edge o) {
        if (this.getWeight() < o.getWeight()) return -1;
        else if (this.getWeight() > o.getWeight()) return +1;
        else return 0;
    }
}

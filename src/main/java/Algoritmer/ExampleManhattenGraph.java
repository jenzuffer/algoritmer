package Algoritmer;

import Interfaces.ManhattanGraph;

public class ExampleManhattenGraph implements ManhattanGraph {
    private int[][] map;

    public ExampleManhattenGraph()
    {
        map = new int[9][8];
        map[1][1] = ManhattanGraph.GOAL;
        map[7][6] = ManhattanGraph.TARGET;
        for(int y = 1; y < 7; ++y)
        {
            map[4][y] = ManhattanGraph.WALL;
        }
    }

    @Override
    public int width()
    {
        return 9;
    }

    @Override
    public int height()
    {
        return 8;
    }

    @Override
    public int get(int x, int y)
    {
        return map[x][y];
    }
}

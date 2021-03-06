package Algoritmer;

import Interfaces.ManhattanGraph;



public class ExampleManhattenGraph implements ManhattanGraph {
    private int[][] map;

    public ExampleManhattenGraph()
    {
        map = new int[9][8];
        map[1][1] = ManhattanGraph.START;
        map[7][6] = ManhattanGraph.TARGET;
        for(int y = 1; y < 7; ++y)
        {
            map[4][y] = ManhattanGraph.WALL;
        }

        for (int i = 0 ; i < height() ; i++){
            for (int j = 0; j < width(); j++) {
                System.out.print(get(j,i)+ " ");
            }
            System.out.println();
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

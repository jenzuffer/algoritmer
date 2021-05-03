package Interfaces;

public interface ManhattanGraph {
    static final int EMPTY = 0;
    static final int GOAL = 1;
    static final int TARGET = 2;
    static final int WALL = 3;
    int width();
    int height();
    int get(int x, int y);
}

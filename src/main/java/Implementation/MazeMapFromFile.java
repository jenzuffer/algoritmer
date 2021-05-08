package Implementation;

import Interfaces.ManhattanGraph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MazeMapFromFile implements ManhattanGraph {

    private int[][] map;
    private int width, height;

    public MazeMapFromFile(String fileName) throws IOException {
        InputStream in = new FileInputStream(fileName);

    }

    @Override
    public int width() {
        return width;
    }

    @Override
    public int height() {
        return height;
    }

    @Override
    public int get(int x, int y) {
        return map[x][y];
    }
}

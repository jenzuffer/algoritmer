package Implementation;

import Interfaces.ManhattanGraph;

import java.io.*;
import java.util.ArrayList;

public class MazeMapFromFile implements ManhattanGraph {

    private int[][] map;
    private int width, height;
    private ArrayList<String> read = new ArrayList<>();

    public MazeMapFromFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = br.readLine()) !=null){
                    read.add(str);
            }
            width = read.get(0).length();
            height = read.size();
            map= new int[width][height];

            for (int i = 0; i < read.size(); i++) {

                for (int j = 0; j <read.get(i).length(); j++) {

                    switch (read.get(i).charAt(j)){
                        case '*':
                            break;
                        case 'W':
                            map[j][i] = ManhattanGraph.WALL;
                            break;
                        case 'T' :
                            map[j][i] = ManhattanGraph.TARGET;
                            break;
                        case 'S' :
                            map[j][i] = ManhattanGraph.START;
                            break;
                        default:
                            throw new IllegalArgumentException("we do not support this charector in the maze generator : " +read.get(i).charAt(j));
                    }

                }

            }
        }

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

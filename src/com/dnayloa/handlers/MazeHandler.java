package com.dnayloa.handlers;

import java.io.*;

/**
 * Created by drewnaylor on 29/03/2018.
 */
public class MazeHandler {

    static BufferedReader br;
    String[][] mazeArray;
    String line;

    public MazeHandler(String mazeName){
        try {
            br = new BufferedReader(new FileReader("/res/" + mazeName));
            br.readLine();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readMaze(){


    }

}

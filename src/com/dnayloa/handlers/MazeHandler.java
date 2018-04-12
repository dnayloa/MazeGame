package com.dnayloa.handlers;

import com.dnayloa.gameObjects.Origin;
import com.dnayloa.gameObjects.Wall;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by drewnaylor on 05/04/2018.
 */
public class MazeHandler {

    private String [][] mazeArray;
    private int mazeSize;
    private String title;
    private int size;

    public MazeHandler(int level){
        try {
            FileReader fileReader = new FileReader("maze" + level + ".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            title = bufferedReader.readLine();
            String [] tempSizeArray = bufferedReader.readLine().split(" ");
            size = Integer.parseInt(tempSizeArray[1]);

            mazeArray = new String [size][size];
            populateArray(mazeArray, bufferedReader);
            printArray(mazeArray);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException f){
            f.printStackTrace();
        }
    }

    private void printArray(String[][]mazeArray){
        for(int i = 0; i < mazeArray.length; i++){
            String line = "";
            for(int j = 0; j < mazeArray[i].length; j++){
                line += mazeArray[i][j];
            }
            System.out.println(line);
        }
    }

    private void populateArray(String[][]mazeArray, BufferedReader bufferedReader)  throws IOException {
        int i = 0;
        String temp = bufferedReader.readLine();
        while(i < size){
            mazeArray[i] = temp.split(" ");
            i++;
            temp = bufferedReader.readLine();
        }
    }

    public void populateHandler(Handler handler, String[][] mazeArray){
        for (int i = 0; i < mazeArray.length; i++){
            for(int j = 0; j < mazeArray[i].length; j++){
                if(mazeArray[i][j].equals("#"))
                    //@TODO Add fixed values for the wall sizes to make sure they always fit the screen.
                    handler.add(new Wall(j * 40 + 10, i  * 40, 40,40));
                else if(mazeArray[i][j].equals("o")){
                    handler.add(new Origin(j * 40 + 10, i  * 40, 40,40));
                }
            }
        }
    }


    public String[][] getMazeArray() {
        return mazeArray;
    }

    public void setMazeArray(String[][] mazeArray) {
        this.mazeArray = mazeArray;
    }

    public int getMazeSize() {
        return mazeSize;
    }

    public void setMazeSize(int mazeSize) {
        this.mazeSize = mazeSize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}

package com.dnayloa.handlers;

import com.dnayloa.gameObjects.collisionObjects.Origin;
import com.dnayloa.gameObjects.collisionObjects.Wall;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by drewnaylor on 05/04/2018.
 */
public class MazeHandler implements Runnable {

    private String [][] mazeArray;
    private int mazeSize;
    private String title;
    private int size;
    private boolean loaded = false;
    private int level;
    private Handler handler;
    Thread th;


    public MazeHandler(int level, Handler handler){
        this.level = level;
        this.handler = handler;
        start();
    }

    public void start(){
        th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        try {
            FileReader fileReader = new FileReader("src/res/maze" + level + ".txt");
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
        populateHandler(handler,mazeArray);
        stop();
    }

    public void stop(){
        loaded = true;
        try {
            th.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * Printing array for debugging purposes
     * @param mazeArray
     */
    private void printArray(String[][]mazeArray){
        for(int i = 0; i < mazeArray.length; i++){
            String line = "";
            for(int j = 0; j < mazeArray[i].length; j++){
                line += mazeArray[i][j];
            }
            System.out.println(line);
        }
    }

    /**
     * Populating mazeArray with Strings from the text file
     * @param mazeArray
     * @param bufferedReader
     * @throws IOException
     */
    private void populateArray(String[][]mazeArray, BufferedReader bufferedReader)  throws IOException {
        int i = 0;
        String temp = bufferedReader.readLine();
        while(i < size){
            mazeArray[i] = temp.split(" ");
            i++;
            temp = bufferedReader.readLine();
        }
    }

    /**
     * Populating the handler from data in the mazeArray
     * @param handler
     * @param mazeArray
     */
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
        handler.remove(handler.getLoadingScreen());
        handler.add(handler.getFrameCount());
    }

    //GETTER AND SETTERS

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

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }


}

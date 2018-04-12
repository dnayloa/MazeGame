package com.dnayloa.handlers;

import com.dnayloa.gameObjects.GameObject;
import com.dnayloa.gameObjects.Square;
import com.dnayloa.gameObjects.Text;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Handler extends ArrayList<GameObject> {
    private MazeHandler mh;
    private int level = 1;
    private Square background = new Square(0,0,500,500, Color.white);
    private Text loadingScreen = new Text(20,20, "Loading...");

    public Handler(){
        new ArrayList<GameObject>();
        this.add(background);
        this.add(loadingScreen);
        mh = new MazeHandler(level);
        mh.populateHandler(this, mh.getMazeArray());
    }

    public void tick(){
        if(this.size() > 0) {
            Iterator<GameObject> it = this.iterator();
            while (it.hasNext()) {
                GameObject temp = it.next();
                temp.update();
            }
        }
    }

    public void render(Graphics g){
        if(this.size() > 0) {
            Iterator<GameObject> it = this.iterator();
            while (it.hasNext()) {
                GameObject temp = it.next();
                if (temp.getX() > 0 || temp.getX() < 800 || temp.getY() > 0 || temp.getY() < 600) {
                    temp.paintComponent(g);
                }
            }
        }
    }

    public MazeHandler getMh() {
        return mh;
    }

    public void setMh(MazeHandler mh) {
        this.mh = mh;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Square getBackground() {
        return background;
    }

    public void setBackground(Square background) {
        this.background = background;
    }

    public Text getLoadingScreen() {
        return loadingScreen;
    }

    public void setLoadingScreen(Text loadingScreen) {
        this.loadingScreen = loadingScreen;
    }
}

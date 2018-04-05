package com.dnayloa.handlers;

import com.dnayloa.gameObjects.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Handler extends ArrayList<GameObject> {

    public Handler(){
        new ArrayList<GameObject>();
    }

    public void tick(){
        Iterator<GameObject> it = this.iterator();
        while (it.hasNext()){
            GameObject temp = it.next();
            temp.update();
        }
    }

    public void render(Graphics g){
        Iterator<GameObject> it = this.iterator();
        while (it.hasNext()){
            GameObject temp = it.next();
            if(temp.getX() > 0 || temp.getX() < 800 || temp.getY() > 0 || temp.getY() < 600  ) {
                temp.paintComponent(g);
            }
        }
    }
}

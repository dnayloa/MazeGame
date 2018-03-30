package com.dnayloa.main;
import com.dnayloa.window.Window;

import java.awt.*;


public class Game extends Canvas implements Runnable {

    public static final long serialVersionUID = 1L;

    private boolean isRunning = false;
    private Thread th;



    public Game(){
        new Window(800,600,"Game",this);
        start();
    }


    public void start(){
        isRunning = true;
        th = new Thread(this);
        th.start();                         //calls the run method below
    }

    @Override
    public void run() {
         this.requestFocus();
         long lastTime = System.nanoTime();
         double amountOfTicks = 60.0;
         double ns = 1000000000 / amountOfTicks;
         double delta = 0;
         long timer = System.currentTimeMillis();
         int frames = 0;
         while (isRunning){
             long now = System.nanoTime();
             delta += (now - lastTime) / ns;
             lastTime = now;
             while(delta >= 1){
                 tick();
                 delta--;
             }
             render();
             frames++;

             if(System.currentTimeMillis() - timer > 1000){
                 System.out.println("Frames: " + Integer.toString(frames));
                 timer += 1000;
                 frames = 0;
             }
         }
         stop();
    }

    public void tick(){

    }

    public void render(){

    }



    public void stop(){
        isRunning = false;
        try {
            th.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}

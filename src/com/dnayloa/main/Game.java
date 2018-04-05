package com.dnayloa.main;
import com.dnayloa.gameObjects.Player;
import com.dnayloa.gameObjects.Text;
import com.dnayloa.gameObjects.Wall;
import com.dnayloa.handlers.Handler;
import com.dnayloa.window.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable {

    public static final long serialVersionUID = 1L;

    private boolean isRunning = false;
    private Thread th;
    private Handler handler;
    //private Text frameCount= new Text(10,10,"");
    private Window window;

    private String version = "Alpha 0.01";

    public Game(){
        window = new Window(500,500,"The Maze Game: " + version ,this);
        start();
    }


    public void start(){
        isRunning = true;
        handler = new Handler();
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
                 System.out.println("FPS: " + Integer.toString(frames));
                 timer += 1000;
                 frames = 0;
             }
         }
         stop();
    }

    public void tick(){
        handler.tick();
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        handler.render(g);

        g.dispose();
        bs.show();
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

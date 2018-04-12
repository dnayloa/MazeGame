package com.dnayloa.main;

import com.dnayloa.handlers.Handler;

public class Renderer implements Runnable {
    Thread th;
    Game game;

    public Renderer(Game game){
        this.game = game;
        //start();
    }

    public void start() {
        th = new Thread();
        th.start();
    }


    @Override
    public void run() {
        game.render();
    }

    public void stop(){
        try {
            th.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

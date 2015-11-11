package game;
import display.Display;
import gfx.Assets;
import gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;

//Logic behind the game and its states
public class Game implements Runnable {

    private Display display;
    private BufferStrategy bs;
    private Graphics g;

    private Thread thread;
    private String title;

    private int x = 0;
    private int y = 0;
    private int delay = 0; // How much to delay animation

    private boolean isRunning;

    public Game(String name) {
        this.title = name;
    }


    private void init() {
        Assets.init();
        isRunning = true;
        this.display = new Display(title);
        this.x = 100;
        this.y = 100;
        this.delay = 10;

        SpriteSheet background = new SpriteSheet(Assets.background, 500, 700);
    }

    private void tick() {
        this.y++;
    }

    private void render() {
        this.bs = this.display.getCanvas().getBufferStrategy();

        if (this.bs == null) {
            this.display.getCanvas().createBufferStrategy(2);
            return;
        }

        this.g = this.bs.getDrawGraphics();
         g.clearRect(0, 0, Display.WIDTH, Display.HEIGHT);

        //Drawing Starts

        //Set up background
        g.drawImage(Assets.background, 0, 0, null);


        // That's how we set a color through a hex string
        g.setColor(Color.decode("#915151"));
        // Drawing a rectangle with arguments: X, Y, width, height
        g.fillRect(this.x, this.y, 50, 50);



        //Drawing Ends

        this.g.dispose();
        this.bs.show();
    }


    @Override
    public void run() {
        this.init();

        //Frames per second
        int fps = 60;
        //The maximum time allowed for running the tick() and render() methods is equal to one second (in nanoseconds)
        //divided by the frames per second
        double timePerTick = 1000000000.0 / fps;
        //Interval between tick() and render() methods being called
        double delta = 0;
        //Current time in nanoseconds
        long now;
        //Counting time since the game has been started
        long time = 0;

        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(isRunning) {
            //Now is the current time (in nanoseconds)
            //now = System.nanoTime();
            //Amount of time since we've started the game divided by the maximum time allowed for a tick
           // delta += (now - lastTime) / timePerTick;
            //Add the total time passed to the timer
           // time += now - lastTime;
            //The present moment becomes the past moment, used in the next cycle of the loop
            //lastTime = now;

            //if (delta >= timePerTick) {
                this.tick();
                this.render();
               // ticks++;
               // delta--;
            //}

            //if (timer >= 1000000000) {
            //    System.out.println("Ticks and Frames: " + ticks);
            //    ticks = 0;
            //    timer = 0;
            //}


        }

        try {
            this.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void start() {
        this.thread = new Thread(this);
        this.isRunning = true;
        this.thread.start();
    }

    public synchronized void stop() throws InterruptedException {
        try {
            this.isRunning = false;
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package game;

public class Launcher {
    //Starts an instance of the game
    public static void main(String[] args) {
        Game javaTetris = new Game("Empire State Tetris");

        javaTetris.start();
    }

}

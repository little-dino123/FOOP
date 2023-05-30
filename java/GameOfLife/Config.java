package GameOfLife;

public class Config {
    public static final CellState[][] initBoard = Presets.glider;
    public static final int width = initBoard[0].length;
    public static final int height = initBoard.length;
    public static final int refreshRate = 2; //FPS
}

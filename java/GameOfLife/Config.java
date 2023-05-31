package GameOfLife;

public class Config {
    public static final CellState[][] initBoard = Presets.pulsar;
    public static final int width = initBoard[0].length;
    public static final int height = initBoard.length;
    public static final int cellSize = 20;
    public static final int refreshRate = 2; //FPS
}

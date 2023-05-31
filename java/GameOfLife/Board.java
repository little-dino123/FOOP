package GameOfLife;

public class Board {
    private CellState[][] stateBoard;
    private final Cell[][] cellBoard;
    private final String[][] displayBoard;
    public final int width, height;

    public Board(int width, int height, CellState[][] initBoard) {
        this.width = width;
        this.height = height;
        stateBoard = new CellState[width][height];
        cellBoard = new Cell[width][height];
        displayBoard = new String[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                stateBoard[i][j] = initBoard[i][j];
                cellBoard[i][j] = new Cell(initBoard[i][j], i, j, this);
            }
        }
    }

    public Cell[][] getCellBoard() {
        return cellBoard;
    }

    public CellState[][] getStateBoard() {
        return stateBoard;
    }

    public String[][] getDisplayBoard() {
        return displayBoard;
    }

    public CellState[][] newBoard() {
        CellState[][] newDisplayBoard = new CellState[Config.height][Config.width];
        for (Cell[] cells : cellBoard) {
            for (Cell cell : cells) {
                newDisplayBoard[cell.cellX][cell.cellY] = cell.getNewState();
            }
        }
        return newDisplayBoard;
    }

    public void updateDisplayBoard() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                displayBoard[i][j] = (stateBoard[i][j] == CellState.A) ? "⬜" : "  ";
            }
        }
    }

    public void updateStateBoard() {
        stateBoard = newBoard();
    }

    public void updateCells() {
        for (Cell[] cells : cellBoard) {
            for (Cell cell : cells) {
                cell.updateState(stateBoard[cell.cellX][cell.cellY]);
            }
        }
    }

    public void updateAllBoards() {
        updateDisplayBoard();
        updateStateBoard();
        updateCells();
    }
}

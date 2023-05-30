package GameOfLife;

public class Cell {
    private Cell[] adjacentCells;
    private CellState cellState;
    private final Board board;
    public final int cellX;
    public final int cellY;
    public Cell(CellState cellState, int cellX, int cellY, Board board){
        this.board = board;
        this.cellState = cellState;
        this.cellX = cellX;
        this.cellY = cellY;
//        fillAdjacentCells(cellX,cellY);
    }
    public void updateState(CellState newState){
        cellState = newState;
    }
    public CellState getNewState(){
        int aliveNeighbors = numberOfAliveNeighbors();
        if (cellState.equals(CellState.A)){
            if(aliveNeighbors==2||aliveNeighbors==3){
                return CellState.A;
            }
            else{
                return CellState.D;
            }
        }
        else if (cellState.equals(CellState.D)&&aliveNeighbors==3){
            return CellState.A;
        }
        else{
            return cellState;
        }
    }
    private int numberOfAliveNeighbors(){
        int numAlive = 0;
        for (int rx = -1; rx <= 1; rx++) {
            for (int ry = -1; ry <= 1; ry++) {
                if (rx == 0 && ry == 0) continue; // skip center cell for a 3x3 grid
                int truex = cellX+rx, truey = cellY+ry; // gets true position
                // checks if in bounds
                if (truex < 0 || truex >= board.width) continue;
                if (truey < 0 || truey >= board.height) continue;
                if (board.getStateBoard()[truex][truey].equals(CellState.A)) numAlive++;
            }
        }
        return numAlive;
    }
    public CellState getCellState(){
        return cellState;
    }
}

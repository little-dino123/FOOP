package GameOfLife;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static Board board = new Board(Config.height, Config.width, Config.initBoard);

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            board.updateAllBoards();
            String[][] displayBoard = board.getDisplayBoard();
            StringBuilder output = new StringBuilder();
            output.append(StringUtils.repeat("_", displayBoard[0].length * 2));
            for (String[] line : displayBoard) {
                output.append("|");
                for (String s : line) {
                    output.append(s).append(" ");
                }
                output.append("|\n");
            }
            output.append(StringUtils.repeat("_", displayBoard[0].length * 2));

            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(output.toString());
            Thread.sleep(100);

        }
    }

}

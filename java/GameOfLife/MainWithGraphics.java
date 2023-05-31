package GameOfLife;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;

public class MainWithGraphics {
    public static Board board = new Board(Config.height, Config.width, Config.initBoard);

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            if (board.updateAllBoards()) break;
            printNewBoard();
            Thread.sleep(1000 / Config.refreshRate);
        }
    }

    public static void printNewBoard() {
        String[][] displayBoard = board.getDisplayBoard();
        StringBuilder output = new StringBuilder();
        output.append("+");
        output.append(StringUtils.repeat("-", displayBoard[0].length * 2));
        output.append("+\n");
        for (String[] line : displayBoard) {
            output.append("|");
            for (String s : line) {
                output.append(s);
            }
            output.append("|\n");
        }
        output.append("+");
        output.append(StringUtils.repeat("-", displayBoard[0].length * 2));
        output.append("+");
        System.out.println(output);
    }
}

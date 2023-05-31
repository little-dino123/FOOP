package GameOfLife;

import java.awt.*;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphic extends JPanel {
    private static final int cellSize = Config.cellSize;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void drawCell(Graphics g, int posX, int posY, CellState cellState) {
        g.setColor(cellState.equals(CellState.A) ? Color.WHITE : Color.BLACK);
        g.fillRect(posX * cellSize, posY * cellSize, cellSize, cellSize);
    }

    public void drawAllCells(JFrame frame,Graphics g, Cell[][] cellBoard) {
        frame.setVisible(false);
        for (Cell[] cells : cellBoard) {
            for (Cell cell : cells) {
                CellState cellState = cell.getCellState();
                int posX = cell.cellX;
                int posY = cell.cellY;
                drawCell(g, posX, posY, cellState);
            }
        }
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var panel = new Graphic();
            panel.setBackground(Color.BLACK);
            var frame = new JFrame("Game Of Life");
            frame.setSize(Config.width * cellSize, Config.height * cellSize);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(panel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
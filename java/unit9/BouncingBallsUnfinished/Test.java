package unit9.BouncingBallsUnfinished;

import java.awt.*;

import static unit9.BouncingBallsUnfinished.BallWorld.hsvToColor;

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 360; i++) {
            Color color = hsvToColor(i, 100, 100);

        }
    }
}

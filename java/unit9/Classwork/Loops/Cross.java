package unit9.Classwork.Loops;

public class Cross {
    public static int x = 2;

    public static void main(String[] args) {
        makeCross();
    }

    public static void makeCross() {
        makeTopAndBottom();
        makeMiddle();
        makeTopAndBottom();
    }

    public static void makeTopAndBottom() {
        for (int i = 0; i < x; i++) {
            makeSpaces();
            makeHashtags();
            makeSpaces();
            System.out.println();
        }
    }

    public static void makeSpaces() {
        for (int i = 0; i < x; i++) {
            System.out.print(" ");
        }
    }

    public static void makeMiddle() {
        for (int i = 0; i < x; i++) {
            makeHashtags();
            makeHashtags();
            makeHashtags();
            System.out.println();
        }
    }

    public static void makeHashtags() {
        for (int i = 0; i < x; i++) {
            System.out.print("#");
        }
    }
}

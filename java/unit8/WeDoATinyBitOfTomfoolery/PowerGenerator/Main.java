package unit8.WeDoATinyBitOfTomfoolery;

public class Test2 {
    public static void main(String[] args) {
        PowerGenerator pg = new PowerGenerator(2);
        for (int i=0; i<32; i++){
            System.out.println(pg.next());
        }
    }
}

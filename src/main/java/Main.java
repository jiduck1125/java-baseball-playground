public class Main {

    public static void main(String[] args) {
        NumberBaseballGame game = new NumberBaseballGame();

        boolean willPlay = true;

        while (willPlay) {
            game.play();
            willPlay = game.willPlay();
        }

    }

}

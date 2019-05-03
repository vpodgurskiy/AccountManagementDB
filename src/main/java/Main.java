import view.ConsolView;

public class Main {

    public static void main(String[] args) {

        ConsolView consolView = new ConsolView();

        while (consolView.ShowMenu()) {
            consolView.ShowMenu();
        }
    }
}
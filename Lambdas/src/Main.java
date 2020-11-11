public class Main {

    public static void main(String[] args) {
        new Thread(new CodeToRun()).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Running from the Runnable");
            }
        }).start();

        new Thread( ()-> System.out.println("Running from a lambda") ).start();
    }
}
    class CodeToRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Running!");
        }
    }


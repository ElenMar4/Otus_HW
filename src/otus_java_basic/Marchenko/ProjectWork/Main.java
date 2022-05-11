package otus_java_basic.Marchenko.ProjectWork;

public class Main {
    public static void main(String[] args) {
        //noinspection InfiniteLoopStatement
        while (true) {
            new FacadeApplication(new ConsoleUserInteractionService(), new DigitalInputHandler(), new CurrencyCompilerOne()).startApplication();
        }
    }
}
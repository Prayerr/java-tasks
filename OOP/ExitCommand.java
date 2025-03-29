public class ExitCommand implements Command {
    private GameState gameState;

    public ExitCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("Спасибо за игру!");
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "Выйти";
    }
} 
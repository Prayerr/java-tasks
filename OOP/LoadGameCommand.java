public class LoadGameCommand implements Command {
    private GameState gameState;

    public LoadGameCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("Загрузка игры...");
        // Здесь будет логика загрузки игры
    }

    @Override
    public String getDescription() {
        return "Загрузить игру";
    }
} 
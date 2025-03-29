public class SaveGameCommand implements Command {
    private GameState gameState;

    public SaveGameCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("Сохранение игры...");
        gameState.setGameSaved(true);
        // Здесь будет логика сохранения игры
    }

    @Override
    public String getDescription() {
        return "Сохранить игру";
    }
} 
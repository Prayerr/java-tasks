public class SaveGameCommand implements Command {
    private GameState gameState;

    public SaveGameCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("Сохранение игры...");
        gameState.setGameSaved(true);
    }

    @Override
    public String getDescription() {
        return "Сохранить игру";
    }
} 
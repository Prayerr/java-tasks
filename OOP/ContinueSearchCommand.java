public class ContinueSearchCommand implements Command {
    private GameState gameState;

    public ContinueSearchCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nЛисёнок решил не тратить время на добычу мёда и продолжил поиски. " +
                "Он слишком долго плутал по лесу и сам не заметил, как заблудился. " +
                "Теперь его самого нужно искать.");
        System.out.println("ВЫ ПРОИГРАЛИ");
        gameState.setCurrentLocation("menu");
        gameState.setGameStarted(false);
    }

    @Override
    public String getDescription() {
        return "Нет, потрачено слишком много времени, нужно идти дальше";
    }
} 
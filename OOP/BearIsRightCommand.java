public class BearIsRightCommand implements Command {
    private GameState gameState;

    public BearIsRightCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nЛисёнок не поверил Медвежонку и продолжил поиски. " +
                "Он слишком долго плутал по лесу и сам не заметил, как заблудился. " +
                "Теперь его самого нужно искать.");
        System.out.println("ВЫ ПРОИГРАЛИ");
        gameState.setCurrentLocation("menu");
        gameState.setGameStarted(false);
    }

    @Override
    public String getDescription() {
        return "Медвежонок ничего не знает, нужно продолжить поиски";
    }
} 
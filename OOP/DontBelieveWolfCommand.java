public class DontBelieveWolfCommand implements Command {
    private GameState gameState;

    public DontBelieveWolfCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nЛисёнок не послушался Волка и продолжил поиски. Он слишком долго плутал по лесу " +
                "и сам не заметил, как заблудился. Теперь его самого нужно искать.");
        System.out.println("ВЫ ПРОИГРАЛИ");
        gameState.setCurrentLocation("menu");
        gameState.setGameStarted(false);
    }

    @Override
    public String getDescription() {
        return "Волку не стоит верить";
    }
} 
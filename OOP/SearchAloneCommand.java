public class SearchAloneCommand implements Command {
    private GameState gameState;

    public SearchAloneCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nЛисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. " +
                "Теперь его самого нужно искать.");
        System.out.println("ВЫ ПРОИГРАЛИ");
        gameState.setCurrentLocation("menu");
        gameState.setGameStarted(false);
    }

    @Override
    public String getDescription() {
        return "Искать Бельчонка в одиночку";
    }
} 
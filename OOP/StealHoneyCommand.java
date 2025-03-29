public class StealHoneyCommand implements Command {
    private GameState gameState;

    public StealHoneyCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nПока Лисёнок ел, злобные пчёлы вернулись и покусали его. Лисёнку нужна помощь, " +
                "он не сможет продолжить поиски.");
        System.out.println("ВЫ ПРОИГРАЛИ");
        gameState.setCurrentLocation("menu");
        gameState.setGameStarted(false);
    }

    @Override
    public String getDescription() {
        return "Нужно попытаться выкрасть мёд немедленно";
    }
} 
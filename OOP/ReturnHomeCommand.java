public class ReturnHomeCommand implements Command {
    private GameState gameState;

    public ReturnHomeCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nВернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место встречи раньше " +
                "и увидел там рой злобных пчел. Он поспешил предупредить об этом Лисёнка, но они разминулись. " +
                "Наконец-то друзья нашли друг друга!");
        System.out.println("ВЫ ВЫИГРАЛИ");
        gameState.setCurrentLocation("menu");
        gameState.setGameStarted(false);
    }

    @Override
    public String getDescription() {
        return "Вернуться домой";
    }
} 
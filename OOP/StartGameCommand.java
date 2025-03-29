public class StartGameCommand implements Command {
    private GameState gameState;

    public StartGameCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        gameState.setGameStarted(true);
        gameState.setCurrentLocation("start");
        System.out.println("\nКаждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. " +
                "Это утро не было исключением. Лисёнок пришёл на их обычное место встречи, но Бельчонка там не было. " +
                "Лисёнок ждал, ждал, но так и не смог дождаться своего друга. Бельчонок не пропустил еще ни одной встречи, " +
                "вдруг он попал в беду. - подумал Лисёнок.\n");
        System.out.println("Как поступить Лисенку?");
        System.out.println("1. Вернуться домой");
        System.out.println("2. Отправиться на поиски");
        System.out.println("3. Показать меню");
    }

    @Override
    public String getDescription() {
        return "Начать игру";
    }
} 
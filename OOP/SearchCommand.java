public class SearchCommand implements Command {
    private GameState gameState;

    public SearchCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nВсе лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему. " +
                "Но вдруг кто нибудь видел Бельчонка... Лисёнок не знал, что ему делать. Помогите ему.");
        System.out.println("1. Попытаться разузнать о Бельчонке у лесных жителей");
        System.out.println("2. Искать Бельчонка в одиночку");
        gameState.setCurrentLocation("search");
    }

    @Override
    public String getDescription() {
        return "Отправиться на поиски";
    }
} 
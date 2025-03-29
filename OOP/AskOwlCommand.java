public class AskOwlCommand implements Command {
    private GameState gameState;

    public AskOwlCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nСова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, " +
                "бежавшего вглубь леса. Все лесные жители знают, что в глубине леса опасно, если Бельчонок там, " +
                "ему срочно нужна помощь.");
        System.out.println("1. Поверить Сове и отправиться вглубь леса");
        System.out.println("2. Сове не стоит верить");
        gameState.setCurrentLocation("ask_owl");
    }

    @Override
    public String getDescription() {
        return "Расспросить Сову";
    }
} 
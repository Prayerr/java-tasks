public class GiveHoneyToBearCommand implements Command {
    private GameState gameState;

    public GiveHoneyToBearCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nДовольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен, " +
                "что Бельчонок никогда не пошёл бы в глубь леса. Он заверял Лисёнка, что Белки не попадают в неприятности, " +
                "и что Совам нельзя верить, он также уговаривал Лисёнка вернуться домой.");
        System.out.println("1. Медвежонок ничего не знает, нужно продолжить поиски");
        System.out.println("2. Может быть он прав и Лисёнок просто паникует");
        gameState.setCurrentLocation("give_honey");
    }

    @Override
    public String getDescription() {
        return "Скорее отнести мёд Медвежонку";
    }
} 
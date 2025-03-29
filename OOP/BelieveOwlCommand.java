public class BelieveOwlCommand implements Command {
    private GameState gameState;

    public BelieveOwlCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nВ глубине леса Лисёнок встретил Медвежонка. Ленивый Медвежонок был готов рассказать все, " +
                "что знает, если Лисёнок принесёт ему мёда.");
        System.out.println("1. Нет, потрачено слишком много времени, нужно идти дальше");
        System.out.println("2. Нужно воспользоваться шансом и раздобыть мёд");
        gameState.setCurrentLocation("believe_owl");
    }

    @Override
    public String getDescription() {
        return "Поверить Сове и отправиться вглубь леса";
    }
} 
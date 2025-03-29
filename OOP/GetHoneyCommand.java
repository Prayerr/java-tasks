public class GetHoneyCommand implements Command {
    private GameState gameState;

    public GetHoneyCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nЛисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел.");
        System.out.println("Лисёнок всегда боялся пчёл, но и не найти друга он тоже боялся.");
        System.out.println("1. Подождать, вдруг пчёлы улетят");
        System.out.println("2. Нужно попытаться выкрасть мёд немедленно");
        gameState.setCurrentLocation("get_honey");
    }

    @Override
    public String getDescription() {
        return "Нужно воспользоваться шансом и раздобыть мёд";
    }
} 
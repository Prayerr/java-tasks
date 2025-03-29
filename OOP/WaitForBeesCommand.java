public class WaitForBeesCommand implements Command {
    private GameState gameState;

    public WaitForBeesCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nЛисёнок подождал немного, и пчёлы разлетелись. Лисёнок без проблем набрал мёда. " +
                "Вдруг он понял, что очень голоден. Что же делать?");
        System.out.println("1. Поесть немного и передохнуть");
        System.out.println("2. Скорее отнести мёд Медвежонку");
        gameState.setCurrentLocation("wait_for_bees");
    }

    @Override
    public String getDescription() {
        return "Подождать, вдруг пчёлы улетят";
    }
} 
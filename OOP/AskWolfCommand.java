public class AskWolfCommand implements Command {
    private GameState gameState;

    public AskWolfCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nВолк оказался вполне дружелюбным, но помочь не смог. Лишь сказал, что маленькому лисенку " +
                "не стоит бродить по лесу одному. И как теперь поступить?");
        System.out.println("1. Волк прав");
        System.out.println("2. Волку не стоит верить");
        gameState.setCurrentLocation("ask_wolf");
    }

    @Override
    public String getDescription() {
        return "Расспросить Волка";
    }
} 
public class AskForestResidentsCommand implements Command {
    private GameState gameState;

    public AskForestResidentsCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nПока Лисёнок принимал решение, лесные жители разошлись кто куда. " +
                "Остались только Сова и Волк. Но у Совы бывают проблемы с памятью, " +
                "а Волк может сильно разозлиться из-за расспросов");
        System.out.println("Кого выбрать?");
        System.out.println("1. Расспросить Сову");
        System.out.println("2. Расспросить Волка");
        gameState.setCurrentLocation("ask_forest_residents");
    }

    @Override
    public String getDescription() {
        return "Попытаться разузнать о Бельчонке у лесных жителей";
    }
} 
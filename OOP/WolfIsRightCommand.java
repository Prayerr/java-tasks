public class WolfIsRightCommand implements Command {
    private GameState gameState;

    public WolfIsRightCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nЛисёнок послушался Волка и вернулся домой. Там он нашёл Бельчонка, " +
                "который пришёл раньше и увидел рой злобных пчел. Он поспешил предупредить об этом Лисёнка, " +
                "но они разминулись.");
        System.out.println("ВЫ ВЫИГРАЛИ");
        System.out.println("\nНажмите Enter для возврата в меню...");
        gameState.setCurrentLocation("menu");
        gameState.setGameStarted(false);
    }

    @Override
    public String getDescription() {
        return "Волк прав";
    }
} 
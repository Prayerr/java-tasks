public class BearIsWrongCommand implements Command {
    private GameState gameState;

    public BearIsWrongCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        System.out.println("\nЛисёнок решил поверить Медвежонку и вернулся домой. " +
                "Там он нашёл Бельчонка, который пришёл раньше и увидел рой злобных пчел. " +
                "Он поспешил предупредить об этом Лисёнка, но они разминулись.");
        System.out.println("ВЫ ВЫИГРАЛИ");
        System.out.println("\nНажмите Enter для возврата в меню...");
        gameState.setCurrentLocation("menu");
        gameState.setGameStarted(false);
    }

    @Override
    public String getDescription() {
        return "Может быть он прав и Лисёнок просто паникует";
    }
} 
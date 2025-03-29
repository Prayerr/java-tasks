import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private GameState gameState;
    private Map<String, Command> menuCommands;
    private Map<String, Command> gameCommands;
    private Map<String, Map<String, Command>> locationCommands;
    private Scanner scanner;

    public Game() {
        this.gameState = new GameState();
        this.scanner = new Scanner(System.in);
        initializeCommands();
    }

    private void initializeCommands() {
        menuCommands = new HashMap<>();
        menuCommands.put("1", new StartGameCommand(gameState));
        menuCommands.put("2", new LoadGameCommand(gameState));
        menuCommands.put("3", new ExitCommand(gameState));

        Map<String, Command> startCommands = new HashMap<>();
        startCommands.put("1", new ReturnHomeCommand(gameState));
        startCommands.put("2", new SearchCommand(gameState));
        startCommands.put("3", new SaveGameCommand(gameState));

        Map<String, Command> searchCommands = new HashMap<>();
        searchCommands.put("1", new AskForestResidentsCommand(gameState));
        searchCommands.put("2", new SearchAloneCommand(gameState));

        Map<String, Command> askResidentsCommands = new HashMap<>();
        askResidentsCommands.put("1", new AskOwlCommand(gameState));
        askResidentsCommands.put("2", new AskWolfCommand(gameState));

        Map<String, Command> askOwlCommands = new HashMap<>();
        askOwlCommands.put("1", new BelieveOwlCommand(gameState));
        askOwlCommands.put("2", new DontBelieveOwlCommand(gameState));

        Map<String, Command> askWolfCommands = new HashMap<>();
        askWolfCommands.put("1", new WolfIsRightCommand(gameState));
        askWolfCommands.put("2", new DontBelieveWolfCommand(gameState));

        Map<String, Command> believeOwlCommands = new HashMap<>();
        believeOwlCommands.put("1", new ContinueSearchCommand(gameState));
        believeOwlCommands.put("2", new GetHoneyCommand(gameState));

        Map<String, Command> getHoneyCommands = new HashMap<>();
        getHoneyCommands.put("1", new WaitForBeesCommand(gameState));
        getHoneyCommands.put("2", new StealHoneyCommand(gameState));

        Map<String, Command> waitForBeesCommands = new HashMap<>();
        waitForBeesCommands.put("1", new EatAndRestCommand(gameState));
        waitForBeesCommands.put("2", new GiveHoneyToBearCommand(gameState));

        Map<String, Command> giveBearHoneyCommands = new HashMap<>();
        giveBearHoneyCommands.put("1", new BearIsRightCommand(gameState));
        giveBearHoneyCommands.put("2", new BearIsWrongCommand(gameState));

        locationCommands = new HashMap<>();
        locationCommands.put("start", startCommands);
        locationCommands.put("search", searchCommands);
        locationCommands.put("ask_forest_residents", askResidentsCommands);
        locationCommands.put("ask_owl", askOwlCommands);
        locationCommands.put("ask_wolf", askWolfCommands);
        locationCommands.put("believe_owl", believeOwlCommands);
        locationCommands.put("get_honey", getHoneyCommands);
        locationCommands.put("wait_for_bees", waitForBeesCommands);
        locationCommands.put("give_honey", giveBearHoneyCommands);
    }

    public void start() {
        while (true) {
            if (gameState.getCurrentLocation().equals("menu")) {
                showMenu();
            } else {
                handleGameInput();
            }
        }
    }

    private void showMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Начать игру");
        System.out.println("2. Загрузить игру");
        System.out.println("3. Выйти");
        if (gameState.isGameStarted()) {
            System.out.println("4. Сохранить игру");
        }
        handleMenuInput();
    }

    private void handleMenuInput() {
        String input = scanner.nextLine();
        Command command = menuCommands.get(input);
        if (command != null) {
            command.execute();
        } else if (gameState.isGameStarted() && input.equals("4")) {
            new SaveGameCommand(gameState).execute();
        } else {
            System.out.println("Неверный ввод. Попробуйте снова.");
        }
    }

    private void handleGameInput() {
        String input = scanner.nextLine();
        Map<String, Command> currentLocationCommands = locationCommands.get(gameState.getCurrentLocation());
        if (currentLocationCommands != null) {
            Command command = currentLocationCommands.get(input);
            if (command != null) {
                command.execute();
                if (!gameState.isGameStarted()) {
                    scanner.nextLine();
                }
            } else {
                System.out.println("Неверный ввод. Попробуйте снова.");
            }
        } else {
            System.out.println("Ошибка: неизвестное состояние игры.");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
} 
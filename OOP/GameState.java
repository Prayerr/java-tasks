public class GameState {
    private boolean isGameStarted;
    private boolean isGameSaved;
    private String currentLocation;
    private String gameProgress;

    public GameState() {
        this.isGameStarted = false;
        this.isGameSaved = false;
        this.currentLocation = "menu";
        this.gameProgress = "";
    }

    public boolean isGameStarted() {
        return isGameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        isGameStarted = gameStarted;
    }

    public boolean isGameSaved() {
        return isGameSaved;
    }

    public void setGameSaved(boolean gameSaved) {
        isGameSaved = gameSaved;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getGameProgress() {
        return gameProgress;
    }

    public void setGameProgress(String gameProgress) {
        this.gameProgress = gameProgress;
    }
} 
package models;

/**
 * Created by Hau on 19/08/2016.
 */
public class GameSetting {
    private static final int WIDTH_DEFAULT = 600;
    private static final int HEIGHT_DEFAULT = 800;
    private static final int DELAY_THREAD = 17;

    private int screenWidth;
    private int screenHeight;
    private int threadDelay;

    private GameSetting(int screenWidth, int screenHeight, int delayThread) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.threadDelay = delayThread;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getThreadDelay() {
        return threadDelay;
    }

    public void setThreadDelay(int threadDelay) {
        this.threadDelay = threadDelay;
    }

    public double toMiliseconds(int threadCount) {
        return ((double) threadCount * threadDelay);
    }

    public double toSeconds(int threadCount) {
        return toMiliseconds(threadCount) / 1000;
    }

    public boolean inScreen(GameObject gameObject) {
        return (gameObject.getY() > this.screenHeight) || (gameObject.getY() < 0);
    }

    private static GameSetting instance = null;

    public static GameSetting getInstance() {
        if (instance == null) {
            instance = new GameSetting(WIDTH_DEFAULT, HEIGHT_DEFAULT, DELAY_THREAD);
        }
        return instance;
    }
}

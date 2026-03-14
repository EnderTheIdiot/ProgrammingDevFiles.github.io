import java.io.*;

public class PlayerScore implements Serializable, Comparable<PlayerScore> {

    String playerName;
    int playerPoints;
    String playerTime;

    PlayerScore(String name, int points, String time) {
        this.playerName = name;
        this.playerPoints = points;
        this.playerTime = time;
    }
    public int getPlayerPoints() { return playerPoints; }

    @Override
    public String toString() {
        return "<html> " + playerTime + " | " + playerName + " | Score: " + playerPoints + "<html>";
    }

    @Override
    public int compareTo(PlayerScore otherScore) {
        return Integer.compare(this.playerPoints, otherScore.playerPoints);
    }
}

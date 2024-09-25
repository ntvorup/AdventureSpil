import java.util.Scanner;

public class Adventure {
    private Player player;
    private Map map;

    public Adventure(Map map) {
        this.map = map;
        this.player = new Player(map.getStartRoom());
    }

    public String movePlayer(String direction) {
        return player.move(direction);
    }

    public String lookAround() {
        return player.look();
    }

    public Player getPlayer() {
        return player;
    }
}
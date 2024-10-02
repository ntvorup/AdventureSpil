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

    public String takeItem(String itemName) {
        Item item = player.getCurrentRoom().findItem(itemName);
        if (item == null) {
            return "There is nothing like " + itemName + " to take around here.";
        } else {
            player.takeItem(item);
            player.getCurrentRoom().removeItem(item);
            return "You took " + item.getLongName();
        }
    }

    public String dropItem(String itemName) {
        Item item = player.findItemInInventory(itemName);
        if (item == null) {
            return "You don't have anything like " + itemName + " in your inventory.";
        } else {
            player.dropItem(item);
            player.getCurrentRoom().addItem(item);
            return "You dropped " + item.getLongName();
        }
    }

    public String showInventory() {
        return player.inventory();
    }

}
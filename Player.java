import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
    }

    public String move(String direction) {
        Room nextRoom = currentRoom.getRoomInDirection(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return "You go " + direction + ".\n";
        } else {
            return "You can't go that way.";
        }
    }

    public String look() {
        return "You are in " + currentRoom.getName() + ".\n" + currentRoom.getDescription();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String inventory() {
        if (inventory.isEmpty()) {
            return "Your inventory is empty.";
        } else {
            StringBuilder inv = new StringBuilder("You are carrying: \n");
            for (Item item : inventory) {
                inv.append(item.getLongName()).append(", \n");
            }
            inv.setLength(inv.length() - 2);
            return inv.toString();
        }
    }

    public void takeItem(Item item) {
        inventory.add(item);
    }

    public void dropItem(Item item) {
        inventory.remove(item);
    }

    public Item findItemInInventory(String shortName) {
        for (Item item : inventory) {
            if (item.getShortName().equals(shortName)) {
                return item;
            }
        }
        return null;

    }
}
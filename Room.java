import java.util.ArrayList;

public class Room {
    private boolean visited = false;
    private boolean letterFound = false;
    private String description;
    private String seenDescription;
    private String foundDescription;
    private String roomName;
    private Room south, east, west, north;
    private boolean northLocked = false;
    private boolean eastLocked = false;
    private boolean southLocked = false;
    private boolean westLocked = false;
    private ArrayList<Item> items = new ArrayList<>();

    public Room(String name, String description, String seenDescription, String foundDescription) {
        this.roomName = name;
        this.description = description;
        this.seenDescription = seenDescription;
        this.foundDescription = foundDescription;
    }

    public void setExit(String direction, Room room) {
        switch (direction) {
            case "north":
                this.north = room;
                break;
            case "east":
                this.east = room;
                break;
            case "south":
                this.south = room;
                break;
            case "west":
                this.west = room;
                break;
        }
    }

    public Room getRoomInDirection(String direction) {
        switch (direction) {
            case "north":
                if (northLocked) {
                    System.out.println("The door to the north is locked.");
                    return null;
                }
                return north;
            case "east":
                if (eastLocked) {
                    System.out.println("The door to the east is locked.");
                    return null;
                }
                return east;
            case "south":
                if (southLocked) {
                    System.out.println("The door to the south is locked.");
                    return null;
                }
                return south;
            case "west":
                if (westLocked) {
                    System.out.println("The door to the west is locked.");
                    return null;
                }
                return west;
            default:
                return null;
        }
    }

    public String getName() {
        return roomName;
    }

    public String getDescription() {
        StringBuilder desc = new StringBuilder();
        if (visited) {
            desc.append(letterFound ? foundDescription : seenDescription);
        } else {
            visited = true;
            desc.append(description);
        }

        if (!items.isEmpty()) {
            desc.append("\nItems in this room: \n");
            for (Item item : items) {
                desc.append(item.getLongName()).append(", \n");
            }
            desc.setLength(desc.length() - 2);
        } else {
            desc.append("\nThere are no items in this room.");
        }

        return desc.toString();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item findItem(String shortName) {
        for (Item item : items) {
            if (item.getShortName().equals(shortName)) {
                return item;
            }
        }
        return null;
    }

    public void findLetter() {
        letterFound = true;
    }

    public void lockNorth() {
        northLocked = true;
    }

    public void unlockNorth() {
        northLocked = false;
    }
}
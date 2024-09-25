public class Room {
    private boolean visited = false;
    private String description;
    private String seenDescription;
    private String roomName;
    private Room south, east, west, north;

    private boolean northLocked = false;
    private boolean eastLocked = false;
    private boolean southLocked = false;
    private boolean westLocked = false;

    public Room(String name, String description, String seenDescription) {
        this.roomName = name;
        this.description = description;
        this.seenDescription = seenDescription;
    }

    public void setExits(Room north, Room east, Room south, Room west) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
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
        if (visited) {
            return seenDescription;
        } else {
            visited = true;
            return description;
        }
    }

    public void lockNorth() {
        northLocked = true;
    }

    public void unlockNorth() {
        northLocked = false;
    }

    public void lockEast() {
        eastLocked = true;
    }

    public void unlockEast() {
        eastLocked = false;
    }

    public void lockSouth() {
        southLocked = true;
    }

    public void unlockSouth() {
        southLocked = false;
    }

    public void lockWest() {
        westLocked = true;
    }

    public void unlockWest() {
        westLocked = false;
    }
}
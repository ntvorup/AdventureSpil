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

    public Room getNorth() {
        if (northLocked) {
            System.out.println("The door to the north is locked.");
            return null;
        }
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        if (eastLocked) {
            System.out.println("The door to the east is locked.");
            return null;
        }
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getSouth() {
        if (southLocked) {
            System.out.println("The door to the south is locked.");
            return null;
        }
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getWest() {
        if (westLocked) {
            System.out.println("The door to the west is locked.");
            return null;
        }
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
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
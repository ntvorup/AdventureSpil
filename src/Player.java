public class Player {
    private Room currentRoom;

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
    }

    public String move(String direction) {
        Room nextRoom = currentRoom.getRoomInDirection(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return "You go " + direction + ".\n" + look();
        } else {
            return "You cannot go that way.";
        }
    }

    public String look() {
        return "You are in " + currentRoom.getName() + ".\n" + currentRoom.getDescription();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
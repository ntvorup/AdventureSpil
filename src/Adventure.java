import java.util.Scanner;

public class Adventure {
    private Room currentRoom;

    public Adventure() {
        createRooms();
    }

    private void createRooms() {
        Room room1 = new Room("Room 1", "rosin", "banan");
        Room room2 = new Room("Room 2", "", "");
        Room room3 = new Room("Room 3", "", "");
        Room room4 = new Room("Room 4", "", "");
        Room room5 = new Room("Room 5", "", "");
        Room room6 = new Room("Room 6", "", "");
        Room room7 = new Room("Room 7", "", "");
        Room room8 = new Room("Room 8", "", "");
        Room room9 = new Room("Room 9", "", "");

        room1.setNorth(null);
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.setWest(null);

        room2.setNorth(null);
        room2.setEast(room3);
        room2.setSouth(null);
        room2.setWest(room1);

        room3.setNorth(null);
        room3.setEast(null);
        room3.setSouth(room6);
        room3.setWest(room2);

        room4.setNorth(room1);
        room4.setEast(null);
        room4.setSouth(room7);
        room4.setWest(null);

        room5.setNorth(null);
        room5.setEast(null);
        room5.setSouth(room8);
        room5.setWest(null);

        room6.setNorth(room3);
        room6.setEast(null);
        room6.setSouth(room9);
        room6.setWest(null);

        room7.setNorth(room4);
        room7.setEast(room8);
        room7.setSouth(null);
        room7.setWest(null);

        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setSouth(null);
        room8.setWest(room7);

        room8.lockNorth();

        room9.setNorth(room6);
        room9.setEast(null);
        room9.setSouth(null);
        room9.setWest(room8);

        currentRoom = room1;
    }
    public String move(String direction) {
        Room nextRoom = null;

        switch (direction) {
            case "north":
                nextRoom = currentRoom.getNorth();
                break;
            case "east":
                nextRoom = currentRoom.getEast();
                break;
            case "south":
                nextRoom = currentRoom.getSouth();
                break;
            case "west":
                nextRoom = currentRoom.getWest();
                break;
        }

        if (nextRoom != null) {
            currentRoom = nextRoom;
            return "You go " + direction + ".\n" + lookAround();
        } else {
            return "You cannot go that way.";
        }
    }

    public String lookAround() {
        return "You are in " + currentRoom.getName() + ".\n" + currentRoom.getDescription();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}

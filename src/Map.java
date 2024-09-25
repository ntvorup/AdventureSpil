public class Map {
    private Room startRoom;

    public Map() {
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

        room1.setExits(null, room2, room4, null);
        room2.setExits(null, room3, null, room1);
        room3.setExits(null, null, room6, room2);
        room4.setExits(room1, null, room7, null);
        room5.setExits(null, null, room8, null);
        room6.setExits(room3, null, room9, null);
        room7.setExits(room4, room8, null, null);
        room8.setExits(room5, room9, null, room7);
        room9.setExits(room6, null, null, room8);

        room8.lockNorth();

        startRoom = room1;
    }

    public Room getStartRoom() {
        return startRoom;
    }
}
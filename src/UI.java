import java.util.Scanner;

public class UI {
    private Adventure adventure;
    private String lastLockedDirection = "";

    public UI(Adventure adventure) {
        this.adventure = adventure;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Adventure game!");
        System.out.println("Type 'help' for a list of commands.");

        boolean playing = true;
        while (playing) {
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "go north":
                case "north":
                case "n":
                    System.out.println(adventure.movePlayer("north"));
                    lastLockedDirection = "north";
                    break;
                case "go east":
                case "east":
                case "e":
                    System.out.println(adventure.movePlayer("east"));
                    lastLockedDirection = "east";
                    break;
                case "go south":
                case "south":
                case "s":
                    System.out.println(adventure.movePlayer("south"));
                    lastLockedDirection = "south";
                    break;
                case "go west":
                case "west":
                case "w":
                    System.out.println(adventure.movePlayer("west"));
                    lastLockedDirection = "west";
                    break;
                case "unlock":
                    unlockDoor();
                    break;
                case "look":
                    System.out.println(adventure.lookAround());
                    break;
                case "help":
                    printHelp();
                    break;
                case "exit":
                    System.out.println("Exiting the game. Goodbye!");
                    playing = false;
                    break;
                default:
                    System.out.println("Invalid command. Type 'help' for a list of commands.");
            }
        }
    }

    private void unlockDoor() {
        Room currentRoom = adventure.getPlayer().getCurrentRoom();
        switch (lastLockedDirection) {
            case "north":
                currentRoom.unlockNorth();
                System.out.println("You unlocked the door to the north.");
                break;
            case "east":
                currentRoom.unlockEast();
                System.out.println("You unlocked the door to the east.");
                break;
            case "south":
                currentRoom.unlockSouth();
                System.out.println("You unlocked the door to the south.");
                break;
            case "west":
                currentRoom.unlockWest();
                System.out.println("You unlocked the door to the west.");
                break;
            default:
                System.out.println("There's no door to unlock.");
                break;
        }
    }

    private void printHelp() {
        System.out.println("Commands:");
        System.out.println("'go north', 'north', 'n' - Move north");
        System.out.println("'go east', 'east', 'e' - Move east");
        System.out.println("'go south', 'south', 's' - Move south");
        System.out.println("'go west', 'west', 'w' - Move west");
        System.out.println("'look' - Look around");
        System.out.println("'unlock' - Unlocks the last locked door you tried to enter");
        System.out.println("'help' - Show this help message");
        System.out.println("'exit' - Exit the game");
    }
}
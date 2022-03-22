package objects;

import java.util.List;
import java.util.Random;

public class Pet {
    private Room currRoom;
    private final String type;

    public Pet(Room room, String type) {
        this.currRoom = room;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    /**
     * moves pet to another random room on the storey.
     *
     * @param rooms
     */
    public void changeRoom(List<Room> rooms) {
        Random random = new Random();
        int randRoomIndex = random.nextInt(rooms.size());
        currRoom = rooms.get(randRoomIndex);
    }
}

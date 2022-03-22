package objects;

import java.util.ArrayList;
import java.util.List;

public class Storey {
    List<Person> peopleOnStorey = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();


    public Storey addRoom(Room room) {
        rooms.add(room);
        return this;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}

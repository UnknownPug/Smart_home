package reportSystem;

import objects.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HouseConfReport implements Reportable {
    private final House house;
    private final List<Person> people;
    private final List<Pet> pets;
    private final String folderForReports;

    public HouseConfReport(House house, List<Person> people, List<Pet> pets, String folderForReports) {
        this.house = house;
        this.people = people;
        this.pets = pets;
        this.folderForReports = folderForReports;
    }

    @Override
    public void generateReport() {
        FileWriter writer;
        try {
            writer = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\java\\reports\\" + folderForReports + "\\" + "houseCondReport.txt");
            List<Storey> storeys = house.getStoreys();
            for (int i = 0; i < storeys.size(); i++) {
                writer.write("Storey " + (i + 1) + " : \n");
                for (Room room : storeys.get(i).getRooms()) {
                    writer.write("\t" + room.getRoomName() + " : \n");
                    writer.write("\t\tDevices :\n");
                    for (Device device : room.getDevices()) {
                        writer.write("\t\t\t" + device.getClass().getName() + " \n");
                    }
                    for (Sensor sensor : room.getSensors()) {
                        writer.write("\t\t\t" + sensor.getClass().getName() + " \n");
                    }
                    writer.write("\t\tWindows : " + room.getWindows() + "\n");
                    for (Window window : room.getWindows()
                    ) {
                        writer.write("\t\t\tBlinds : " + window.getBlinds() + "\n");
                    }
                }
            }
            writer.write("People: \n");
            for (Person person : people) {
                writer.write("\t" + person.getName() + "\n");
            }
            writer.write("Pets: \n");
            for (Pet pet : pets) {
                writer.write("\t" + pet.getType() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

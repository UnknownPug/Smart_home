package reportSystem;

import objects.Person;
import objects.Pet;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ActivityAndUsageReport implements Reportable {
    List<Person> people;
    List<Pet> pets;
    String folderForReports;

    public ActivityAndUsageReport(List<Person> people, List<Pet> pets, String folderForReports) {
        this.people = people;
        this.pets = pets;
        this.folderForReports = folderForReports;
    }

    @Override
    public void generateReport() {
        try {
            FileWriter writer = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\java\\reports\\" + folderForReports + "\\" + "activityAndUsageReport.txt");
            writer.write("People:\n");
            for (Person person : people) {
                writer.write(person.getName() + ":\n");
                writer.write("  TV: " + person.getPersonActivityAPI().getTvCounter() + "\n");
                writer.write("  Fridge: " + person.getPersonActivityAPI().getFridgeCounter() + "\n");
                writer.write("  SmartSpeaker: " + person.getPersonActivityAPI().getSmartSpeakerCounter() + "\n");
                writer.write("  Owen: " + person.getPersonActivityAPI().getOwenCounter() + "\n");
                writer.write("  Microwave: " + person.getPersonActivityAPI().getMicrowaveCounter() + "\n");
                writer.write("  WashingMachine: " + person.getPersonActivityAPI().getWashingMachineCounter() + "\n");
                writer.write("  Blinds: " + person.getPersonActivityAPI().getBlindsCounter() + "\n");
                writer.write("  AirCondition: " + person.getPersonActivityAPI().getAirConditionCounter() + "\n");
                writer.write("  Windows: " + person.getPersonActivityAPI().getWindowsCounter() + "\n");
                writer.write("  Car: " + person.getPersonActivityAPI().getCarCounter() + "\n");
                writer.write("  Bicycle: " + person.getPersonActivityAPI().getBicycleCounter() + "\n");
                writer.write("  Skis: " + person.getPersonActivityAPI().getSkiCounter() + "\n");
                writer.write("  LightSystem: " + person.getPersonActivityAPI().getLightSystemCounter() + "\n");
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

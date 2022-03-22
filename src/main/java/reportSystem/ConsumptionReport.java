package reportSystem;

import objects.Device;
import objects.WashingMachine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConsumptionReport implements Reportable {
    private final List<Device> devices;
    private final int pricePerKw;
    private final int pricePerLitre;
    private final String folderForReports;

    public ConsumptionReport(List<Device> devices, int pricePerKw, int pricePerLitre, String folderForReports) {
        this.devices = devices;
        this.pricePerKw = pricePerKw;
        this.pricePerLitre = pricePerLitre;
        this.folderForReports = folderForReports;
    }

    @Override
    public void generateReport() {
        try {
            File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\reports\\" + folderForReports + "\\consumptionReport.txt");
            FileWriter myWriter = new FileWriter(file);
            myWriter.write("Electricity consumption: \n");
            for (Device device : devices) {
                myWriter.write(device + " : " + device.getElectricityAPI().getSpentKilowatts() +
                        "kW - " + pricePerKw * device.getElectricityAPI().getSpentKilowatts() + "$\n");
                // "TV : 1000 kW - 100$"
            }
            myWriter.write("\nWater consumption: \n");
            for (Device device : devices) {
                if (device instanceof WashingMachine)
                    myWriter.write(device + " : " + ((WashingMachine) device).getWaterAPI().getSpentWaterAmount() +
                            "L - " + pricePerLitre * ((WashingMachine) device).getWaterAPI().getSpentWaterAmount() + "$\n");
            }

            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

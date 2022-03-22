package objects;

import objects.SensorsAndSystems.BackupGenerator;
import objects.SensorsAndSystems.FireSystem;
import objects.SensorsAndSystems.LightSystem;
import objects.SensorsAndSystems.WaterLeakSystem;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Storey> storeys = new ArrayList<>();
    private LightSystem lightSystem = new LightSystem();
    private FireSystem fireSystem = new FireSystem();
    private WaterLeakSystem waterLeakSystem = new WaterLeakSystem();
    private BackupGenerator backupGenerator = new BackupGenerator();

    public House() {

    }

    public List<Storey> getStoreys() {
        return storeys;
    }

    public void setStoreys(ArrayList<Storey> storeys) {
        this.storeys = storeys;
    }

    public void addStorey(Storey storey) {
        storeys.add(storey);
    }

    public LightSystem getLightSystem() {
        return lightSystem;
    }

    public void setLightSystem(LightSystem lightSystem) {
        this.lightSystem = lightSystem;
    }

    public FireSystem getFireSystem() {
        return fireSystem;
    }

    public void setFireSystem(FireSystem fireSystem) {
        this.fireSystem = fireSystem;
    }

    public WaterLeakSystem getWaterLeakSystem() {
        return waterLeakSystem;
    }

    public void setWaterLeakSystem(WaterLeakSystem waterLeakSystem) {
        this.waterLeakSystem = waterLeakSystem;
    }

    public BackupGenerator getBackupGenerator() {
        return backupGenerator;
    }

    public void setBackupGenerator(BackupGenerator backupGenerator) {
        this.backupGenerator = backupGenerator;
    }
}

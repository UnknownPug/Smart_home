package simulation;

import API.*;
import objects.*;
import objects.SensorsAndSystems.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Configuration {
    private static Configuration INSTANCE;
    private final String[] rooms = {"kitchen", "livingRoom", "bathRoom", "entertainmentRoom", "bedRoom1", "bedRoom2"};
    private final String[] peopleNames = {"Andrew", "Dmytro", "Jiri", "Katerina", "Tomas", "Luxanna"};
    private final List<Person> people = new ArrayList<>();
    private final List<Pet> pets = new ArrayList<>();
    private final List<Device> devicesWithConsumption = new ArrayList<>();
    private final List<Device> sensors = new ArrayList<>();

    private Configuration() {
    }

    public synchronized static Configuration getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Configuration();
        }
        return INSTANCE;
    }

    /**
     * factory method returning constructed working instance of house.
     *
     * @return House
     */
    public House initHouse() {
        House house = new House();

        Storey storey = new Storey();
        house.addStorey(storey);

        Room kitchen = new Room(rooms[0]);
        Room livingRoom = new Room(rooms[1]);
        Room bathRoom = new Room(rooms[2]);
        Room entertainmentRoom = new Room(rooms[3]);
        Room bedRoom = new Room(rooms[4]);
        Room bedRoom2 = new Room(rooms[5]);
        storey.addRoom(kitchen)
                .addRoom(livingRoom)
                .addRoom(bathRoom)
                .addRoom(entertainmentRoom)
                .addRoom(bedRoom)
                .addRoom(bedRoom2);


        addOneWindowToEveryRoom(kitchen, livingRoom, bathRoom, entertainmentRoom, bedRoom, bedRoom2);

        List<Blinds> allBlinds = getBlindsFromRooms(storey);

        Car car = new Car();
        CarAPI carAPI = new CarAPI(car);
        Fridge fridge = initFridge();

        Tv tv = new Tv();
        AirCondition airCondition = new AirCondition();
        AirCondition airCondition2 = new AirCondition();

        List<AirCondition> airConditions = new ArrayList<>();
        airConditions.add(airCondition);
        airConditions.add(airCondition2);

        SmartSpeaker smartSpeaker = new SmartSpeaker();
        Owen owen = new Owen();
        WashingMachine washingMachine = new WashingMachine();
        Microwave microwave = new Microwave();
        LightSystem lightSystem = new LightSystem();

        addDevicesWithConsumption(devicesWithConsumption, fridge, tv, airCondition, airCondition2, smartSpeaker,
                owen, washingMachine, microwave, lightSystem);

        ElectronicAPI electronicApi = new ElectronicAPI()
                .setFridgeApi(new FridgeAPI(fridge))
                .setTvApi(new TvAPI(tv))
                .setBlindsApi(new BlindsAPI(allBlinds))
                .setMicrowaveApi(new MicrowaveAPI(microwave))
                .setSmartSpeakerApi(new SmartSpeakerAPI(smartSpeaker))
                .setOwenApi(new OwenAPI(owen))
                .setAirConditionApi(new AirConditionAPI(airConditions))
                .setLightSystemApi(new LightSystemAPI(lightSystem))
                .setWashingMachineApi(new WashingMachineAPI(washingMachine));

        SmartSpeakerRemote speakerRemote = new SmartSpeakerRemote(smartSpeaker);
        AirCondRemote airCondRemote = new AirCondRemote(airCondition);
        TvRemote tvRemote = new TvRemote(tv);

        init_people(people, peopleNames, storey, livingRoom, electronicApi, carAPI, new BicycleAPI(new Bicycle()), speakerRemote, airCondRemote, tvRemote);

        init_pets(pets, livingRoom);

        fillRoomWithDevices(kitchen, owen, fridge, microwave);
        fillRoomWithDevices(livingRoom, tv);
        fillRoomWithDevices(bathRoom, washingMachine);
        fillRoomWithDevices(entertainmentRoom, smartSpeaker);
        fillRoomWithDevices(bedRoom, airCondition);
        fillRoomWithDevices(bedRoom2, airCondition2);

        setUpFireSensors(house.getFireSystem(), devicesWithConsumption, sensors, kitchen, livingRoom, bathRoom, entertainmentRoom, bedRoom);

        setUpWaterSensors(house.getWaterLeakSystem(), devicesWithConsumption, sensors, kitchen, bathRoom);

        setUpPowerOutageSensors(house.getBackupGenerator(), devicesWithConsumption, sensors, kitchen, bathRoom, livingRoom, entertainmentRoom, bedRoom);

        setUpStrongWindSensor(allBlinds, livingRoom, devicesWithConsumption, sensors);

        attachPeopleToBreakableDevices(people, fridge, tv, airCondition, airCondition2, owen, microwave, washingMachine, smartSpeaker);

        for (Device d : devicesWithConsumption) {
            sensors.add(d);
            d.turnOn();
        }
        return house;
    }


    public List<Person> getPeople() {
        return people;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public List<Device> getDevicesWithConsumption() {
        return devicesWithConsumption;
    }

    public List<Device> getSensors() {
        return sensors;
    }


    /**
     * adds one window to every room from param.
     *
     * @param rooms
     */
    private void addOneWindowToEveryRoom(Room... rooms) {
        for (Room room : rooms) {
            room.addWindow(new Window());
        }
    }

    /**
     * @param storey
     * @return all blind from all room on the storey.
     */
    private List<Blinds> getBlindsFromRooms(Storey storey) {
        List<Blinds> blinds = new ArrayList<>();
        for (Room room : storey.getRooms()) {
            for (Window w : room.getWindows()) {
                blinds.add(w.getBlinds());
            }
        }
        return blinds;
    }

    /**
     * method to fill several devices to the list.
     *
     * @param devicesWithConsumption
     * @param devices
     */
    private void addDevicesWithConsumption(List<Device> devicesWithConsumption, Device... devices) {
        devicesWithConsumption.addAll(Arrays.asList(devices));
    }

    /**
     * method for pets configuring.
     *
     * @param pets
     * @param room
     */
    private void init_pets(List<Pet> pets, Room room) {
        Pet cat = new Pet(room, "Cat");
        Pet dog = new Pet(room, "Dog");
        Pet rat = new Pet(room, "Rat");
        pets.add(cat);
        pets.add(dog);
        pets.add(rat);
    }

    /**
     * adds multiple amount of devices into room.
     *
     * @param room
     * @param devices
     */
    private void fillRoomWithDevices(Room room, Device... devices) {
        for (Device device : devices) {
            room.addDevice(device);
        }
    }

    /**
     * adds fireSensor to the room, attaches it to the central fireSystem of the house,
     * attaches trackers for consumption and event reports.
     *
     * @param fireSystem
     * @param devicesWithConsumption
     * @param sensors
     * @param rooms
     */
    private void setUpFireSensors(FireSystem fireSystem, List<Device> devicesWithConsumption, List<Device> sensors, Room... rooms) {
        for (Room room : rooms) {
            FireSensor fireSensor = new FireSensor();
            room.addSensor(fireSensor);
            fireSensor.attach(fireSystem);
            devicesWithConsumption.add(fireSensor);
            sensors.add(fireSensor);
        }
    }

    /**
     * adds waterLeakSensor to the room, attaches it to the central waterLeakSystem of the house,
     * attaches trackers for consumption and event reports.
     *
     * @param waterLeakSystem
     * @param devicesWithConsumption
     * @param sensors
     * @param rooms
     */
    private void setUpWaterSensors(WaterLeakSystem waterLeakSystem, List<Device> devicesWithConsumption, List<Device> sensors, Room... rooms) {
        for (Room room : rooms) {
            WaterLeakSensor waterLeakSensor = new WaterLeakSensor();
            room.addSensor(waterLeakSensor);
            waterLeakSensor.attach(waterLeakSystem);
            devicesWithConsumption.add(waterLeakSensor);
            sensors.add(waterLeakSensor);
        }
    }

    /**
     * adds powerOutageSensor to the room, attaches it to the backUpGenerator of the house,
     * attaches trackers for consumption and event reports.
     *
     * @param backupGenerator
     * @param devicesWithConsumption
     * @param sensors
     * @param rooms
     */
    private void setUpPowerOutageSensors(BackupGenerator backupGenerator, List<Device> devicesWithConsumption, List<Device> sensors, Room... rooms) {
        for (Room room : rooms) {
            PowerOutageSensor powerOutageSensor = new PowerOutageSensor(backupGenerator);
            room.addSensor(powerOutageSensor);
            powerOutageSensor.attach(backupGenerator);
            devicesWithConsumption.add(powerOutageSensor);
            sensors.add(powerOutageSensor);
        }
    }

    /**
     * adds strongWindSensor to the room, attaches it to the blinds of the house,
     * attaches trackers for consumption and event reports.
     *
     * @param allBlinds
     * @param livingRoom
     * @param devicesWithConsumption
     * @param sensors
     */
    private void setUpStrongWindSensor(List<Blinds> allBlinds, Room livingRoom, List<Device> devicesWithConsumption, List<Device> sensors) {
        StrongWindSensor strongWindSensor = new StrongWindSensor();
        for (Blinds b : allBlinds) {
            strongWindSensor.attach(b);
        }
        livingRoom.addSensor(strongWindSensor);
        devicesWithConsumption.add(strongWindSensor);
        sensors.add(strongWindSensor);
    }

    /**
     * method for creating people.
     *
     * @param people
     * @param peopleNames
     * @param storey
     * @param livingRoom
     * @param electronicApiBuilder
     * @param carAPI
     * @param bicycleAPI
     * @param speakerRemote
     * @param airCondRemote
     * @param tvRemote
     */
    private void init_people(List<Person> people, String[] peopleNames, Storey storey, Room livingRoom, ElectronicAPI electronicApiBuilder, CarAPI carAPI, BicycleAPI bicycleAPI, SmartSpeakerRemote speakerRemote, AirCondRemote airCondRemote, TvRemote tvRemote) {
        for (int i = 0; i < peopleNames.length; i++) {
            people.add(new Person(peopleNames[i], storey, livingRoom, electronicApiBuilder,
                    carAPI, new BicycleAPI(new Bicycle()),
                    speakerRemote, airCondRemote, tvRemote));
        }
    }

    /**
     * factory method for creating a fridge with some food.
     *
     * @return fridge instance
     */
    private Fridge initFridge() {
        Fridge fridge = new Fridge();
        fridge.turnOn();
        Food apple = new Food("apple");
        Food milk = new Food("milk");
        Food meat = new Food("meat");
        fridge.addFood(apple);
        fridge.addFood(milk);
        fridge.addFood(meat);
        return fridge;
    }

    /**
     * @param people
     * @param devices
     */
    private void attachPeopleToBreakableDevices(List<Person> people, Device... devices) {
        for (Person person : people) {
            for (Device device : devices) {
                device.attach(person);
            }
        }
    }
}

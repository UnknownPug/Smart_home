package API;


public class ElectronicAPI {
    private TvAPI tvApi;
    private OwenAPI owenApi;
    private SmartSpeakerAPI smartSpeakerApi;
    private MicrowaveAPI microwaveApi;
    private LightSystemAPI lightSystemApi;
    private FridgeAPI fridgeApi;
    private WashingMachineAPI washingMachineApi;
    private AirConditionAPI airConditionAPI;
    private BlindsAPI blindsAPI;

    /**
     * container for all apies for person.
     */
    public ElectronicAPI() {
    }


    public ElectronicAPI getResult() {
        return this;
    }

    public BlindsAPI getBlindsAPI() {
        return blindsAPI;
    }

    public ElectronicAPI setBlindsApi(BlindsAPI blindsAPI) {
        this.blindsAPI = blindsAPI;
        return this;
    }

    public TvAPI getTvApi() {
        return tvApi;
    }

    public ElectronicAPI setTvApi(TvAPI tvApi) {
        this.tvApi = tvApi;
        return this;
    }

    public OwenAPI getOwenApi() {
        return owenApi;
    }

    public ElectronicAPI setOwenApi(OwenAPI owenApi) {
        this.owenApi = owenApi;
        return this;
    }

    public SmartSpeakerAPI getSmartSpeakerApi() {
        return smartSpeakerApi;
    }

    public ElectronicAPI setSmartSpeakerApi(SmartSpeakerAPI smartSpeakerApi) {
        this.smartSpeakerApi = smartSpeakerApi;
        return this;
    }

    public MicrowaveAPI getMicrowaveApi() {
        return microwaveApi;
    }

    public ElectronicAPI setMicrowaveApi(MicrowaveAPI microwaveApi) {
        this.microwaveApi = microwaveApi;
        return this;
    }

    public LightSystemAPI getLightSystemApi() {
        return lightSystemApi;
    }

    public ElectronicAPI setLightSystemApi(LightSystemAPI lightSystemApi) {
        this.lightSystemApi = lightSystemApi;
        return this;
    }

    public FridgeAPI getFridgeApi() {
        return fridgeApi;
    }

    public ElectronicAPI setFridgeApi(FridgeAPI fridgeApi) {
        this.fridgeApi = fridgeApi;
        return this;
    }

    public WashingMachineAPI getWashingMachineApi() {
        return washingMachineApi;
    }

    public ElectronicAPI setWashingMachineApi(WashingMachineAPI washingMachineApi) {
        this.washingMachineApi = washingMachineApi;
        return this;
    }

    public AirConditionAPI getAirConditionApi() {
        return airConditionAPI;
    }

    public ElectronicAPI setAirConditionApi(AirConditionAPI airConditionAPI) {
        this.airConditionAPI = airConditionAPI;
        return this;
    }

    public AirConditionAPI getAirConditionAPI() {
        return airConditionAPI;
    }
}

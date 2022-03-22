package API;

import objects.Documentation;

public interface FuncWearOutAPI {
    /**
     * fixes device but only with documentation which you can get  from device
     *
     * @param documentation
     */
    void fixDevice(Documentation documentation);
}

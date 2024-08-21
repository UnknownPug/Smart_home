# Semester Project - OMO

### Czech Technical University in Prague (CTU) - Winter Semester 2021

#### Authors: Dmitry Rastvorov, Andrew Mamaev

---

### UML Diagram of the Project
## [Powered by IntelliJ Ultimate](https://www.jetbrains.com/help/idea/class-diagram.html):
![UML Diagram](https://gitlab.fel.cvut.cz/rastvdmy/omo_smart_home/-/wikis/uploads/2f382775dead5ad83e7d6f42b53f4cc6/omo_intellij_uml.png)

---

### Use Case Diagram of the Smart Home Code
## [Powered by draw.io](https://app.diagrams.net):
![Use Case Diagram](https://gitlab.fel.cvut.cz/rastvdmy/omo_smart_home/-/wikis/uploads/3dc290c7ab15af62ee01adb747232cb4/Untitled_Diagram.drawio.png)

---

### Project Description

The full description of our project can be found in the following PDF file (**description in Czech**):
[Description_of_project_smart_home.pdf](https://gitlab.fel.cvut.cz/rastvdmy/omo_smart_home/-/wikis/uploads/d7908236074d105ca7f61f988187c8b1/Description_of_projekt_smart_home.pdf)

---

### Status Overview of Project Sections

The progress of the project has been tracked as follows:

- A **"+"** indicates that the section has been successfully completed.
- A **"*"** indicates that additional notes or explanations are provided for the section.

**F1**: + * (All relevant objects can be found in the "objects" folder).

**F2**: + * (Most devices are API-driven. The primary API for the main house devices is implemented within the `ElectronicApi`. Devices have states, such as "turned on," which are checked before allowing usage).

**F3**: + * (Devices have an active state indicating whether they are turned on. While there is no explicit "Idle" state, when a device breaks, its energy consumption increases, serving as an approximation).

**F4**: + * (In the "API" folder, you will find `ElectricityAPI`, `WaterAPI`, and `FuncWearOutAPI`. We have omitted gas appliances for safety reasons and made all devices electric).

**F5**: +

**F6**: + * (An overview of events is available in the `objects/eventType` folder. Random event generation is handled by the `Simulation` class).

**F7**: +

- **Fire**: Extinguished by the fire suppression system.
- **Water Leak**: Water tubes are closed by the water leak prevention system.
- **Strong Wind**: Blinds are automatically closed.
- **Empty Fridge**: A resident must go shopping to restock the fridge.
- **Power Outage**: Devices are turned on by the backup generator.
- **Broken Device**: A resident must repair it after finding the appropriate documentation.

**F8**: + * (Reports for `Configuration` and `Configuration2` are located in the "reports/1" and "reports/2" folders).

**F9**: + * (Documentation is available. When a device breaks, it sends a notification to the user, who must locate the documentation to repair it).

**F10**: +

---

### Design Patterns Implemented:

- **State Machine**: Located in the "states" folder.
- **Factory/Factory Method**: Applied during house construction in `Configuration`.
- **Decorator/Composite**: Implemented for remote controllers.
- **Singleton**: Both configurations are represented as singleton classes.
- **Visitor/Observer/Listener**: Used for handling events.
- **Chain of Responsibility**: Applied to APIs and the repair system.
- **Builder**: Implemented via `ElectronicAPIBuilder` and used in `Configuration` during house construction.

---

### Configurations:

We created two configurations with minimal differences, both of which satisfy the project requirements:
- 6 residents, 3 animals, 8 types of appliances, 20 individual appliances, 6 rooms, 1 pair of skis, and 2 cars.

The configurations are represented as singleton classes (`Configuration` and `Configuration2`) instead of JSON files.

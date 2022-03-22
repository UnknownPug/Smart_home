# This program was created as a semester project of the OMO

## (CTU - OI winter semester 2021)

### Authors: Dmitry Rastvorov, Andrew Mamaev
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- - 
### This is our main UML diagram of our project ([Powered by draw.io](https://app.diagrams.net)):
![[Image description]](https://gitlab.fel.cvut.cz/rastvdmy/omo_smart_home/-/wikis/uploads/3f0b53d7ab58b635e5c6ff9085fefc5f/omo_uml_diagram.drawio.png)

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- - 
### Also we have more readable version of our UML diagram ([Powered by IntelliJ Ultimate](https://www.jetbrains.com/help/idea/class-diagram.html)):
![[Image description]](https://gitlab.fel.cvut.cz/rastvdmy/omo_smart_home/-/wikis/uploads/2f382775dead5ad83e7d6f42b53f4cc6/omo_intellij_uml.png)
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- - 
### USER CASE diagram of our smart home code ([Powered by draw.io](https://app.diagrams.net)):
![[Image description]](https://gitlab.fel.cvut.cz/rastvdmy/omo_smart_home/-/wikis/uploads/3dc290c7ab15af62ee01adb747232cb4/Untitled_Diagram.drawio.png)
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- - 
### Description

Full description of our project, paragraphs can be found in this .pdf file **(description of this project in Czech language)**: 

[Description_of_projekt_smart_home.pdf](https://gitlab.fel.cvut.cz/rastvdmy/omo_smart_home/-/wikis/uploads/d7908236074d105ca7f61f988187c8b1/Description_of_projekt_smart_home.pdf)
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- - 
### For the understanding, we've scheduled the points as follows:

##### " + " means that paragraph has been successfully completed.
##### " * " means that we have some notes or explanation to this paragraph.

**F1**: +   * (All is in folder "objects").

**F2**: +   * (Almost all devices have apies. Person owns one big api for the main devices of house 
in ElectronicApi. Devices have state "turned on" for instance, 
which we check before letting person use some device).

**F3**: +   * (Devices have active state defining if its turned on or not. We do not have Idle state,
but once device is broken we increase its energy consumption, so its kinda suits).

**F4**: +   * (in folder API: ElectricityAPI, WaterAPI, FuncWearOutAPI, but we do not have gas appliances, in order
to provide higher protection to residents of house we made all devices electric:) ).
    
**F5**: + 

**F6**: +  * (overview of events you can find in objects/eventType, random generating
of events is implemented in class Simulation).

**F7**: +

fire -> extinguishing a fire by fireSystem.

water leak -> closing tubes by waterLeakSystem.

strongWind -> closing blinds.

empty fridge -> person has to go to the shop and fill fridge with products.

power outage -> turning on devices by generator.

broken device -> person has to fix it but at first he must find the documentation.

**F8**: + * (reports for Configuration and Configuration2 are created in folders reports/1 and reports/2).

**F9**: + * (but we have only documentation. If smth is broken, device send notification to person
    who has to find documentation in order to fix device).

**F10**: +
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- - 
##### Patterny:
●	State machine # folder "states" with different states.

●	Factory/Factory method # factory method during constructing house in Configuration.

●	Decorator/Composite # Remotes.

●	Singleton # configurations are represented as singleton classes.

●	Visitor/Observer/Listener # events.

●	Chain of responsibility # APIs, fixing system.

●	Builder # ElectronicAPIBuilder and usage in Configuration during constructing house.
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- - 
##### Configurations:
    We made 2 configurations with very small differences which both should suit requirements
    - 6 persons, 3 animals, 8 types of appliances, 20 pieces of appliances, 6 rooms, one ski, two cars.
    We do not have json file for configuration,we have them represented as singleton classes Configuration and Configuration2.
 
Enjoy! 😁

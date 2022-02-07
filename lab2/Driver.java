package lab2;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

import java.awt.Color;

public class Driver {

    Level level1 = new Level();
    LevelGUI levelGUI = new LevelGUI(level1, "Test");

    public void run() {
        Room kitchen = new Room(500, 500, Color.red);
        Room livingroom = new Room(500, 500, Color.green);
        Room bedroom = new Room(500, 500, Color.blue);
        Room bathroom = new Room(500, 500, Color.black);
        Room guestroom = new Room(500, 500, Color.pink);
        Room testroom = new Room(500, 500, Color.cyan);

        /* Kolla över */
        level1.place(kitchen, 0, 0);
        level1.place(livingroom, 0, 501);
        level1.place(bedroom, 501, 501);
        level1.place(bathroom, 501, 0);
        level1.place(guestroom, 1002, 0);
        level1.place(testroom, 10, 10);

        /* The code below shows how many rooms have been placed */
        /*
        for(Room room : level1.rooms){
            System.out.println(room);
        }
         */

        kitchen.connectSouthTo(livingroom);  /* Innehåller en "pekare" som pekar på livingroom */
        livingroom.connectNorthTo(kitchen);

        livingroom.connectEastTo(bedroom);
        bedroom.connectWestTo(livingroom);

        bedroom.connectNorthTo(bathroom);
        bathroom.connectSouthTo(bedroom);

        bathroom.connectEastTo(guestroom);
        guestroom.connectWestTo(bathroom);

    }

}
package lab2;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

import java.awt.Color;

public class Driver {

    Level level1 = new Level();

    public void run() {
        Room kitchen = new Room(500, 500, Color.red);
        Room livingroom = new Room(500, 500, Color.green);
        Room bedroom = new Room(500, 500, Color.blue);
        Room room1 = new Room(500, 500, Color.black);
        Room room2 = new Room(500, 500, Color.pink);
        Room room3 = new Room(500, 500, Color.cyan);

        /* Kolla över */
        level1.place(kitchen, 0, 0);
        level1.place(livingroom, 0, 550);
        level1.place(bedroom, 550, 550);
        level1.place(room1, 550, 0);
        level1.place(room2, 1100, 0);
        level1.place(room3, 10, 10);


        kitchen.connectSouthTo(livingroom);  /* Innehåller en "pekare" som pekar på livingroom */

        livingroom.connectNorthTo(kitchen);
        livingroom.connectEastTo(bedroom);
        bedroom.connectNorthTo(room1);
        room1.connectEastTo(room2);

        bedroom.connectWestTo(livingroom);

    }

}
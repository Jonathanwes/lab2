package lab2.level;

import java.awt.Color;


public class Room {
    /* Needs to be packaged declared */
    Room northernDoorway;
    Room southernDoorway;
    Room easternDoorway;
    Room westernDoorway;
    Color color;
    int dx;
    int dy;
    int x;
    int y;

    public Room(int dx, int dy, Color color) {
        this.color = color;
        this.dx = dx;
        this.dy = dy;

        System.out.println("The dimensions of the room are as follows: " + dx + "x" + dy + ". With the floor color: " + color);
    }

    public void connectNorthTo(Room r) {
        this.northernDoorway = r;
    }
    public void connectEastTo(Room r) {
        this.easternDoorway = r;
    }
    public void connectSouthTo(Room r) {
        this.southernDoorway = r;
    }
    public void connectWestTo(Room r) {
        this.westernDoorway = r;
    }
}

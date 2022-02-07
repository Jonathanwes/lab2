package lab2.level;

import java.util.Observable;
import java.util.ArrayList;


public class Level extends Observable {
    public ArrayList<Room> rooms = new ArrayList<>(); /*  Arraylist is a dynamic sized data structure which doesn't require a specific size at the time of initialization. */
    int playerX;
    int playerY;

    public boolean place(Room r, int x, int y)  {

        for(Room room : rooms) { /* Check if r overlaps with room, if not then it's added to rooms.
        http://jeffreythompson.org/collision-detection/rect-rect.php */
            if (room.x + room.dx >= x &&    // room right edge past r left
                    room.x <= x + r.dx &&    // room left edge past r right
                    room.y + room.dy >= y &&    // room top edge past r bottom
                    room.y <= y + r.dy) {    // room bottom edge past r top
                return false;
            }
        }
        r.x = x;
        r.y = y;
        rooms.add(r);
        /* Marks this Observable object as having been changed. */
        setChanged();
        /* Notifys observers */
        notifyObservers();

        return true;
    }

    public void firstLocation(Room r) {
        playerX = rooms.get(0).dx/2;
        playerY = rooms.get(0).dy/2;
    }

}

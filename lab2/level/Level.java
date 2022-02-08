package lab2.level;

import java.util.Observable;
import java.util.ArrayList;


public class Level extends Observable {
    public ArrayList<Room> rooms = new ArrayList<>(); /*  Arraylist is a dynamic sized data structure which doesn't require a specific size at the time of initialization. */
    int playerX;
    int playerY;
    int playerRoom;

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
        playerRoom=rooms.get(0); // för att lättare kunna hålla koll på rummet spelaren är i och vilka kopplingar rummet har
    }
    public void moveDirection(Direction){// förflyttar spelaren till ett anant rum
        try{
        switch(Direction){
        case "North": 
            playerRoom=playerRoom.northernDoorway; // om det finns en koppling är rum.[riktning]Doorway rummet i den riktningen Det hade nog gått att skriva om den här så att for loopen i förra metoden inte längre finns genom att tex lägga till en if sats eller genom att lägga till en try/except som retunerar false om det inte finns en koppling i riktningen. Så slipper man loopa över en lista vi inte har för tillfället.
            Break;
        case "East": 
            playerRoom=playerRoom.easternDoorway;
            Break;
        case "South": 
            playerRoom=playerRoom.southernDoorway;
            Break;
        case "West": 
            playerRoom=playerRoom.westernDoorway;
            Break;
        default: 
            return // Borde aldrig komma hit utan om det inte går att gå i en riktning borde det bli en exception. Eftersom det inte finns någon koppling i riktningen.
        } // playerroom är nytt rum pga hur doorway fungerar
        playerX=playerRoom.x+playerRoom.dx/2 // uppdaterar spelaren till mitten av det nya rummet
        playerY=playerRoom.y+playerRoom.dy/2 
        // lägg till notifyobserver för att uppdatera GUI:n
            }
        // Direction är inputen från listner som triggar ett case. Om det inte finns en koppling i riktningen blir det en exception och funktionen uppdaterar ingenting.
    
        }
        
    }
}

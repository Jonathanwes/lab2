package lab2.level;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static java.lang.Math.*;


public class LevelGUI implements Observer {

    private Level lv;
    private Display d;

    public LevelGUI(Level level, String name) {

        this.lv = level;

        /* When notifyObservers is called update will be runned. */
        lv.addObserver(this);

        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TODO: You should change 200 to a value
        // depending on the size of the level
        d = new Display(lv,200,200);

        frame.getContentPane().add(d);
        frame.pack();
        frame.setLocation(0,0);
        frame.setVisible(true);
    }


    public void update(Observable arg0, Object arg1) {
        d.repaint();
    }

    private class Display extends JPanel {


        public Display(Level fp, int x, int y) {


            addKeyListener(new Listener());

            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(x+20,y+20));
            setFocusable(true);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawRoom(g);
            drawConnections(g);
        }


        private void drawRoom(Graphics g){
            for(Room room : lv.rooms){
                g.setColor(room.color);
                g.drawRect(room.x, room.y, room.dx, room.dy);
            }
        }

        private void drawConnections(Graphics g){

            for(Room room: lv.rooms){
                g.setColor(Color.black);

                if(room.northernDoorway != null){
                    int x1 = room.x + (room.dx/2);
                    int y1 = room.y;
                    drawConnection(g, room.northernDoorway, x1, y1);
                }
                if(room.easternDoorway != null){
                    int x1 = room.x + room.dx;
                    int y1 = room.y + (room.dy/2);
                    drawConnection(g, room.easternDoorway, x1, y1);
                }
                if(room.southernDoorway != null){
                    int x1 = room.x + (room.dx/2);
                    int y1 = room.y + room.dy;
                    drawConnection(g, room.southernDoorway, x1, y1);
                }
                if(room.westernDoorway != null){
                    int x1 = room.x;
                    int y1 = room.y + (room.dy/2);
                    drawConnection(g, room.westernDoorway, x1, y1);
                }

            }

        }

        private void drawConnection(Graphics g, Room room, int x, int y){
            int x2 = room.x + (room.dx/2);
            int y2 = room.y + (room.dy/2);
            g.drawLine(x, y, x2, y2);
        }


        private class Listener implements KeyListener {


            public void keyPressed(KeyEvent arg0) {
            }

            public void keyReleased(KeyEvent arg0) {
            }

            public void keyTyped(KeyEvent event) {
                switch(event.getKeyChar) {
                    case "a":
                        this.lv.move("West");
                            Break;
                    case "s":
                        this.lv.move("South");
                            Break;
                    case "d":
                        this.lv.move("East");
                            Break;
                    case "w":
                        this.lv.move("North");
                            Break;
                    default:
                            Break;
                            
                                                    
                           
            }
        }

    }

}

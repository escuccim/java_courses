import java.awt.*;
import java.util.*;

public class Bear extends Critter {
    private boolean polar;
    private int moveNum = 0;

    public Bear(boolean polar){
        this.polar = polar;
    }

    public Color getColor(){
        if(polar){
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    public String toString(){
        if(moveNum % 2 == 0){
            return "/";
        } else {
            return "\\";
        }

    }

    public Action getMove(CritterInfo info){
        moveNum++;
        Neighbor front = info.getFront();
        if(front == Neighbor.OTHER){
            return Action.INFECT;
        } else if (front == Neighbor.EMPTY){
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }
}

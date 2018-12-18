import java.awt.*;
import java.util.*;

public class Tiger extends Critter {
    private Color[] colors = {Color.WHITE, Color.RED, Color.GREEN};
    private Random randomizer = new Random();
    private Color current_color;
    private int moveNum = 0;

    public Color getColor(){
        if(moveNum % 3 == 0){
            current_color = colors[randomizer.nextInt(colors.length)];
        }
        return current_color;
    }

    public String toString(){
        return "TGR";
    }

    public Action getMove(CritterInfo info){
        moveNum++;
        Neighbor front = info.getFront();

        // if enemy in front infect
        if(front == Neighbor.OTHER){
            return Action.INFECT;
        }
        // if wall in front turn left
        else if(front == Neighbor.WALL){
            return Action.LEFT;
        }
        // if tiger is in front turn right
        else if(front == Neighbor.SAME){
            return Action.RIGHT;
        }
        // if wall to right turn left
        Neighbor right = info.getRight();
        if(right == Neighbor.WALL){
            return Action.LEFT;
        }
        // else hop
        return Action.HOP;
    }
}

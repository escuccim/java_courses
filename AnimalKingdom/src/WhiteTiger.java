import java.awt.*;

public class WhiteTiger extends Critter {
    private boolean infectedOther = false;
    private int moveNum = 0;

    public Color getColor(){
        return Color.WHITE;
    }

    public String toString(){
        if(this.infectedOther){
            return "TGR";
        } else {
            return "tgr";
        }
    }

    public Action getMove(CritterInfo info){
        moveNum++;
        Neighbor front = info.getFront();

        // if enemy in front infect
        if(front == Neighbor.OTHER){
            this.infectedOther = true;
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

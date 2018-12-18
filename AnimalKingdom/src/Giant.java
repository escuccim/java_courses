import java.awt.*;

public class Giant extends Critter {
    private int moveNum = 0;

    public Color getColor(){
        return Color.GRAY;
    }

    public String toString(){
        if(moveNum <  6){
            return "fee";
        } else if(moveNum < 12){
            return "fie";
        } else if(moveNum < 18){
            return "foe";
        } else {
            return "fum";
        }
    }

    public Action getMove(CritterInfo info){
        moveNum++;
        if(moveNum > 24){
            moveNum = 0;
        }
        Neighbor front = info.getFront();

        if(front == Neighbor.OTHER){
            return Action.INFECT;
        } else if(front == Neighbor.EMPTY){
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }
}

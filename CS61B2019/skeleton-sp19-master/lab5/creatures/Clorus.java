package creatures;
import huglife.Action;
import huglife.Creature;
import huglife.Direction;
import huglife.Occupant;
import static huglife.HugLifeUtils.randomEntry;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Random;

public class Clorus extends Creature {
    private int r,g,b;
    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    @Override
    public Color color() {
        r = 34;
        g = 0;
        b = 231;
        return color(r,g,b);
    }

    public void move(){
        energy -= 0.03;
    }

    public void attack(Creature c){
        energy += c.energy();
    }

    public Clorus replicate(){
        energy = energy/2;
        return new Clorus(energy);
    }


    public void stay(){
        energy -= 0.01;
    }

    /**
     * Returns an action. The creature is provided information about its
     * immediate NEIGHBORS with which to make a decision.
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors){
        Deque<Direction> dqPlip = new ArrayDeque<>(),dq = new ArrayDeque<>();
        for(Direction k:neighbors.keySet()){
            if(neighbors.get(k).name().equals("empty")){
                dq.add(k);
            }
            else if(neighbors.get(k).name().equals("plip")){
                dqPlip.add(k);
            }
        }
        int szP = dqPlip.size(), sz = dq.size();
        if(szP>0){
            return new Action(Action.ActionType.ATTACK,randomEntry(dqPlip));
        }
        else if(sz>0){
            if(energy>=1){
                return new Action(Action.ActionType.REPLICATE,randomEntry(dq));
            }
            else{
                return new Action(Action.ActionType.MOVE,randomEntry(dq));
            }
        }
        else
            return new Action(Action.ActionType.STAY);
    }
}

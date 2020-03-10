package creatures;
import java.util.HashMap;
import java.util.Map;
import huglife.Action;
import huglife.Direction;
import huglife.Empty;
import huglife.Impassible;
import huglife.Occupant;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestClorus {
    @Test
    public void TestCorusAction(){
        Clorus c = new Clorus(2);
        assertEquals(c.energy(),2,0.01);
        Clorus c1 = new Clorus(3);
        assertEquals(c1.energy(),3,0.01);
        Map<Direction, Occupant> surrounded = new HashMap<>();
        surrounded.put(Direction.TOP,new Empty());
        surrounded.put(Direction.LEFT,new Impassible());
        surrounded.put(Direction.RIGHT,new Impassible());
        surrounded.put(Direction.BOTTOM,new Impassible());
        Action expected = new Action(Action.ActionType.REPLICATE,Direction.TOP);
        Action actual = c1.chooseAction(surrounded);
        assertEquals(expected,actual);

        surrounded.clear();
        surrounded.put(Direction.TOP,new Impassible());
        surrounded.put(Direction.LEFT,new Impassible());
        surrounded.put(Direction.RIGHT,new Impassible());
        surrounded.put(Direction.BOTTOM,new Impassible());
        actual = c1.chooseAction(surrounded);
        expected = new Action(Action.ActionType.STAY);
        assertEquals(expected,actual);

    }
}

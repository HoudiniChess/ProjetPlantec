package behaviorStrategy;

import java.awt.Point;

import model.Beacon;
import model.ElementMobile;

public class MonteSurfacePourSynchro extends BeaconDeplacement
{

  public MonteSurfacePourSynchro(Movement next)
  {
    super(next);
  }

  @Override
  public void move(ElementMobile target)
  {
    Point p = target.getPosition();
    int y = p.y;
    if (y > 0)
    {
      y -= 3;
      if (y < 0)
        y = 0;
      target.setPosition(new Point(p.x, y));
    }
    else
    {
      target.getManager().baliseReadyForSynchro((Beacon) target);
      target.setDeplacement(this.next);
    }
  }

}

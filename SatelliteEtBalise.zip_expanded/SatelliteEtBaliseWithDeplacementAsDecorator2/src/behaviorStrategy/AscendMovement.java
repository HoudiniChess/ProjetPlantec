package behaviorStrategy;

import java.awt.Point;

import model.Beacon;
import model.ElementMobile;

public class AscendMovement extends BeaconMovement
{

  public AscendMovement(Movement next)
  {
    super(next);
    // TODO Auto-generated constructor stub
  }

  // TURBO MARLOUTAGE PAS BIEN
  public AscendMovement()
  {
    super(null);
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
      {
        y = 0;
        super.setFinish();
      }

      target.setPosition(new Point(p.x, y));
    }
    else
    {
      target.getManager().baliseReadyForSynchro((Beacon) target);
      target.setMouvement(this.next);
    }
  }

}

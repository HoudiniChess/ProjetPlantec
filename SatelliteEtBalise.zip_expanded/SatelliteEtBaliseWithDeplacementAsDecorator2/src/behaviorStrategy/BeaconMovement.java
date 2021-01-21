package behaviorStrategy;

import model.Beacon;
import model.ElementMobile;

public class BeaconMovement extends Movement
{

  public void move(Beacon target)
  {}

  @Override
  public void move(ElementMobile target)
  {
    this.move((Beacon) target);
  }

}

package behaviorStrategy;

import events.SatelliteMoved;
import model.Beacon;
import model.ElementMobile;

public class BeaconMovement extends Movement
{

  protected Movement next;

  public BeaconMovement(Movement next)
  {
    this.next = next;
  }

  public void move(Beacon target)
  {}

  @Override
  public void move(ElementMobile target)
  {
    this.move((Beacon) target);
  }

  public void whenSatelliteMoved(SatelliteMoved arg, Beacon target)
  {}

}

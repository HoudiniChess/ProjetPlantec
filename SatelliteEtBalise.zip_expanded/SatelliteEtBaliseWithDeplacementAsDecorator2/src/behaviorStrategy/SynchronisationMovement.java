package behaviorStrategy;

import events.SatelliteMoved;
import events.SynchroEvent;
import model.Beacon;
import model.Satellite;

public class SynchronisationMovement extends BeaconMovement
{
  private int synchroTime;
  private Satellite synchro;

  public Boolean synchroStarted()
  {
    return this.synchro != null;
  }

  public SynchronisationMovement()
  {
    this.synchroTime = 10;
    this.synchro = null;
  }

  @Override
  public void whenSatelliteMoved(SatelliteMoved arg, Beacon target)
  {
    if (this.synchro != null)
      return;
    Satellite sat = (Satellite) arg.getSource();
    int satX = sat.getPosition().x;
    int tarX = target.getPosition().x;
    if (satX > tarX - 10 && satX < tarX + 10)
    {
      this.synchro = sat;
      target.send(new SynchroEvent(this));
      this.synchro.send(new SynchroEvent(this));
    }
  }

}
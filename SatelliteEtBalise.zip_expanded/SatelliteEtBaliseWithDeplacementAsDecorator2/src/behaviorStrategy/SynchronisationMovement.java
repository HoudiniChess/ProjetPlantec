package behaviorStrategy;

import events.SatelliteMoved;
import events.SynchroEvent;
import model.Beacon;
import model.Satellite;

public class SynchronisationMovement extends BeaconDeplacement
{
  private int synchroTime;
  private Satellite synchro;

  public Boolean synchroStarted()
  {
    return this.synchro != null;
  }

  public SynchronisationMovement(Movement next)
  {
    super(next);
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

  @Override
  public void move(Beacon target)
  {
    if (this.synchro == null)
      return;
    this.synchroTime--;
    if (synchroTime <= 0)
    {
      Satellite sat = this.synchro;
      this.synchro = null;
      this.synchroTime = 10;
      target.send(new SynchroEvent(this));
      sat.send(new SynchroEvent(this));
      target.getManager().baliseSynchroDone(target);
      target.setDeplacement(next);
    }
  }
}

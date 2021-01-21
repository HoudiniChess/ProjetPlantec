package state;

import events.SatelliteMoveListener;
import events.SatelliteMoved;
import events.SynchroEvent;
import model.Beacon;
import model.Satellite;

public class BeaconStateSynchro extends BeaconState implements SatelliteMoveListener
{

  protected int synchroTime;
  protected Satellite synchro;
  protected Beacon beacon;

  @Override
  public void behaviorState(Beacon beacon)
  {
    if (this.synchro == null)
    {
      return;
    }
    this.synchroTime--;
    if (synchroTime <= 0)
    {
      // Next State

      beacon.send(new SynchroEvent(this));
      synchro.send(new SynchroEvent(this));
      beacon.getManager().baliseSynchroDone(beacon);
      beacon.getMemory().resetData();

    }

  }

  @Override
  public void whenSatelliteMoved(SatelliteMoved arg)
  {
    if (this.synchro != null)
      return;
    Satellite sat = (Satellite) arg.getSource();
    int satX = sat.getPosition().x;
    int tarX = beacon.getPosition().x;
    if (satX > tarX - 10 && satX < tarX + 10)
    {
      this.synchro = sat;
      beacon.send(new SynchroEvent(this));
      this.synchro.send(new SynchroEvent(this));
    }
  }

  @Override
  public void nextState(Beacon beacon)
  {
    BeaconStateDiving stateDiving = new BeaconStateDiving();
    beacon.setState(stateDiving);

  }

  @Override
  public void install(Beacon beacon)
  {

    System.out.println("Synchro install");
    this.synchroTime = 10;
    this.synchro = null;
    this.beacon = beacon;
  }

}

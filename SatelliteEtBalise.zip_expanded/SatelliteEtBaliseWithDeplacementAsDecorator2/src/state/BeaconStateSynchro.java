package state;

import events.SynchroEvent;
import model.Beacon;
import model.Satellite;

public class BeaconStateSynchro extends BeaconState
{

  private int synchroTime;
  private Satellite synchro;

  @Override
  public void behaviorState(Beacon beacon)
  {
    if (this.synchro == null)
      return;
    this.synchroTime--;
    if (synchroTime <= 0)
    {
      Satellite sat = this.synchro;
      this.synchro = null;
      this.synchroTime = 10;
      beacon.send(new SynchroEvent(this));
      sat.send(new SynchroEvent(this));
      beacon.getManager().baliseSynchroDone(beacon);
      beacon.getMemory().resetData();
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

  }

}

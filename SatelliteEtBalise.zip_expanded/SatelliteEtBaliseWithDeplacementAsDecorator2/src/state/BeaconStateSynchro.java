package state;

import model.Beacon;

public class BeaconStateSynchro extends BeaconState
{

  @Override
  public void behaviorState(Beacon beacon)
  {
    // TODO Auto-generated method stub

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

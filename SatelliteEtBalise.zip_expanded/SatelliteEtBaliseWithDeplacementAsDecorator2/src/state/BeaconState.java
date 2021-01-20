package state;

import model.Beacon;

public abstract class BeaconState
{
  public abstract void behaviorState(Beacon beacon);

  public abstract void nextState(Beacon beacon);

  public abstract void install(Beacon beacon);
}

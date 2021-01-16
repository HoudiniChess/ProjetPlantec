package state;

import model.Beacon;

public abstract class State
{
  public abstract void behaviorState(Beacon beacon);

  public abstract void nextState(Beacon beacon);
}

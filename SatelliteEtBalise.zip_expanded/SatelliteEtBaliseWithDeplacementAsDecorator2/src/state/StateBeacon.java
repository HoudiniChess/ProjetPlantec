package state;

import model.Beacon;

public abstract class StateBeacon
{
  public abstract void handleSynchro(Beacon beacon);

  public abstract void next(Beacon beacon);
}

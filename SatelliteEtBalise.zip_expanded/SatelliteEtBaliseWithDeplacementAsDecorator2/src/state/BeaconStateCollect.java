package state;

import model.Beacon;

public class BeaconStateCollect extends BeaconState
{

  @Override
  public void behaviorState(Beacon beacon)
  {
    // Si l'état courant continue
    if (this.shouldContinue(beacon))
      beacon.readSensors();
    // si non passer à l'état suivant
    else
    {
      this.nextState(beacon);
    }

  }

  private boolean shouldContinue(Beacon beacon)
  {
    return !beacon.getMemory().memoryFull();
  }

  @Override
  public void nextState(Beacon beacon)
  {
    BeaconStateAscend stateAscend = new BeaconStateAscend();
    stateAscend.install(beacon);
    beacon.setState(stateAscend);

  }

  @Override
  public void install(Beacon beacon)
  {
    // que se passe t'il quand l'état est intalle
  }

}

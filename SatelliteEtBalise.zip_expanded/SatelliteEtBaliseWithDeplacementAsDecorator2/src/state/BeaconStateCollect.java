package state;

import model.Beacon;

public class BeaconStateCollect extends BeaconState
{

  @Override
  public void behaviorState(Beacon beacon)
  {
    // Si l'�tat courant continue
    if (this.shouldContinue(beacon))
      beacon.readSensors();
    // si non passer � l'�tat suivant
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
    // que se passe t'il quand l'�tat est intalle
  }

}

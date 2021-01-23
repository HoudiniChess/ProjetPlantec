package state;

import model.Beacon;

public class BeaconStateCollect extends BeaconState
{

  @Override
  public void install(Beacon beacon)
  {
    this.isInstall = true;
    System.out.println(beacon.getCollectMovement());
    beacon.setMovement(beacon.getCollectMovement());
  }

  @Override
  public void behaviorState(Beacon beacon)
  {

    if (!isInstall)
    {
      this.install(beacon);
    }
    // Si l'état courant continue
    if (this.shouldContinue(beacon))
      beacon.readSensors();
    // si non passer à l'état suivant
    else
    {
      this.nextState(beacon);
    }

  }

  @Override
  public void nextState(Beacon beacon)
  {
    BeaconStateAscend stateAscend = new BeaconStateAscend();
    stateAscend.install(beacon);
    beacon.setState(stateAscend);

  }

  private boolean shouldContinue(Beacon beacon)
  {
    return !beacon.getMemory().memoryFull();
  }

}

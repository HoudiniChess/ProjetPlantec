package state;

import model.Beacon;

public class BeaconStateCollect extends BeaconState
{

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
    this.isInstall = true;
    beacon.setMovement(beacon.getCollectMovement());
    // reprendre le mouvement de base
    // Sauvegarde du mouvement de base ?

  }

}

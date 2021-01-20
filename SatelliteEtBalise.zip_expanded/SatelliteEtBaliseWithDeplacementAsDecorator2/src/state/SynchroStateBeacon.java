package state;

import behaviorStrategy.DiveMovement;
import behaviorStrategy.AscendMovement;
import behaviorStrategy.Movement;
import behaviorStrategy.SynchronisationMovement;
import model.Beacon;

public class SynchroStateBeacon extends BeaconState
{

  @Override
  public void behaviorState(Beacon beacon)
  {
    // Traiter remonte

    // Traiter synchro

    // Traiter redescente
    Movement diving = new DiveMovement(beacon.movement(), beacon.deepness());
    Movement synchroBehavior = new SynchronisationMovement(diving);
    Movement nextMovement = new AscendMovement(synchroBehavior);
    beacon.setMouvement(nextMovement);
    if (beacon.getMemory().memoryFull())
    {
      this.nextState(beacon);
    }
  }

  @Override
  public void nextState(Beacon beacon)
  {
    BeaconStateCollect stateDesynchro = new BeaconStateCollect();
    beacon.setState(stateDesynchro);
  }

  @Override
  public void install(Beacon beacon)
  {
    // TODO Auto-generated method stub

  }

}

package state;

import behaviorStrategy.DiveMovement;
import behaviorStrategy.MonteSurfacePourSynchro;
import behaviorStrategy.Movement;
import behaviorStrategy.SynchronisationMovement;
import model.Beacon;

public class SynchroStateBeacon extends State
{

  @Override
  public void behaviorState(Beacon beacon)
  {
    // Traiter remonte

    // Traiter synchro

    // Traiter redescente
    Movement diving = new DiveMovement(beacon.movement(), beacon.deepness());
    Movement synchroBehavior = new SynchronisationMovement(diving);
    Movement nextMovement = new MonteSurfacePourSynchro(synchroBehavior);
    beacon.setMouvement(nextMovement);
    if (beacon.memoryFull())
    {
      beacon.resetData();
      this.nextState(beacon);
    }
  }

  @Override
  public void nextState(Beacon beacon)
  {
    Collect stateDesynchro = new Collect();
    beacon.setState(stateDesynchro);
  }

}

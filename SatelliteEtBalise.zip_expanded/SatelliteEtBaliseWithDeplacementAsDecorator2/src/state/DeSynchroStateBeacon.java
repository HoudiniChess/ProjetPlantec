package state;

import behaviorStrategy.DiveMovement;
import behaviorStrategy.MonteSurfacePourSynchro;
import behaviorStrategy.Movement;
import behaviorStrategy.SynchronisationMovement;
import model.Beacon;

public class DeSynchroStateBeacon extends StateBeacon
{

  @Override
  public void handleSynchro(Beacon beacon)
  {
    beacon.readSensors();
    if (beacon.memoryFull())
    {
      Movement diving = new DiveMovement(beacon.movement(), beacon.deepness());
      Movement synchroBehavior = new SynchronisationMovement(diving);
      Movement nextMovement = new MonteSurfacePourSynchro(synchroBehavior);
      beacon.setMouvement(nextMovement);
      this.next(beacon);
    }
  }

  @Override
  public void next(Beacon beacon)
  {
    SynchroStateBeacon stateSynchro = new SynchroStateBeacon();
    beacon.setState(stateSynchro);
  }

}

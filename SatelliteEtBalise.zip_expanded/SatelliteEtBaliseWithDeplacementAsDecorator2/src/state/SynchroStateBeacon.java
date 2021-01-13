package state;

import model.Beacon;

public class SynchroStateBeacon extends StateBeacon
{

  @Override
  public void handleSynchro(Beacon beacon)
  {

    if (!beacon.memoryFull())
    {
      beacon.resetData();
      this.next(beacon);
    }
  }

  @Override
  public void next(Beacon beacon)
  {
    DeSynchroStateBeacon stateDesynchro = new DeSynchroStateBeacon();
    beacon.setState(stateDesynchro);
  }

}

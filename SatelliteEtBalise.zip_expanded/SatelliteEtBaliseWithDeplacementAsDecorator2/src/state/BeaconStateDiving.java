package state;

import behaviorStrategy.DiveMovement;
import model.Beacon;

public class BeaconStateDiving extends BeaconState
{

  protected DiveMovement diveMovement;

  @Override
  public void behaviorState(Beacon beacon)
  {
    beacon.move();
    if (beacon.getMovement().isFinish())
    {
      this.nextState(beacon);
    }
  }

  @Override
  public void nextState(Beacon beacon)
  {
    BeaconStateCollect stateCollect = new BeaconStateCollect();
    stateCollect.install(beacon);
    beacon.setState(stateCollect);
  }

  @Override
  public void install(Beacon beacon)
  {
    this.diveMovement = new DiveMovement(beacon.getStandartDeepness());
    beacon.setMovement(this.diveMovement);
  }

}

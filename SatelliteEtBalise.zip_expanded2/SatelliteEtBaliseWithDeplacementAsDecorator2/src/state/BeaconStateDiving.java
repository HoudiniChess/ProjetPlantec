package state;

import model.Beacon;
import movementStrategy.DiveMovement;

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
    int speed = beacon.getMovement().getSpeed();
    this.diveMovement = new DiveMovement(speed, beacon.getStandartDeepness());
    beacon.setMovement(this.diveMovement);
  }

}

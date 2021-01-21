package state;

import behaviorStrategy.AscendMovement;
import model.Beacon;

public class BeaconStateAscend extends BeaconState
{

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
    System.out.println("State Ascend - next State");
    BeaconStateSynchro stateSynchro = new BeaconStateSynchro();
    stateSynchro.install(beacon);
    beacon.setState(stateSynchro);

  }

  @Override
  public void install(Beacon beacon)
  {
    beacon.setMovement(new AscendMovement());

  }

}

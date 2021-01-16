package model;

import behaviorStrategy.BeaconMovement;
import events.SatelliteMoveListener;
import events.SatelliteMoved;
import state.Collect;
import state.State;

public class Beacon extends ElementMobile implements SatelliteMoveListener
{

  protected State state;

  public Beacon(int memorySize)
  {
    super(memorySize);
    this.state = new Collect();
  }

  public int deepness()
  {
    return this.getPosition().y;
  }

  public void readSensors()
  {
    this.dataSize++;
  }

  @Override
  public void tick()
  {
    state.behaviorState(this);
    super.tick();
  }

  @Override
  public void whenSatelliteMoved(SatelliteMoved arg)
  {
    BeaconMovement dp = (BeaconMovement) this.movement;
    dp.whenSatelliteMoved(arg, this);
  }

  public State getState()
  {
    return state;
  }

  public void setState(State state)
  {
    this.state = state;
  }

}

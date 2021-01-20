package model;

import behaviorStrategy.BeaconMovement;
import events.SatelliteMoveListener;
import events.SatelliteMoved;
import state.BeaconStateCollect;
import state.BeaconState;

public class Beacon extends ElementMobile implements SatelliteMoveListener
{

  protected BeaconState state;
  protected Memory memory;

  public Beacon(Memory memory)
  {
    super();
    this.state = new BeaconStateCollect();
    this.memory = memory;
  }

  public int deepness()
  {
    return this.getPosition().y;
  }

  public void readSensors()
  {
    memory.tick();
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

  public BeaconState getState()
  {
    return state;
  }

  public void setState(BeaconState state)
  {
    this.state = state;
  }

  public Memory getMemory()
  {
    return memory;
  }

}

package model;

import behaviorStrategy.BeaconMovement;
import events.SatelliteMoveListener;
import events.SatelliteMoved;
import state.DeSynchroStateBeacon;
import state.StateBeacon;

public class Beacon extends ElementMobile implements SatelliteMoveListener
{

  protected StateBeacon state;

  public Beacon(int memorySize)
  {
    super(memorySize);
    this.state = new DeSynchroStateBeacon();
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
    state.handleSynchro(this);
    super.tick();
  }

  @Override
  public void whenSatelliteMoved(SatelliteMoved arg)
  {
    BeaconMovement dp = (BeaconMovement) this.movement;
    dp.whenSatelliteMoved(arg, this);
  }

  public StateBeacon getState()
  {
    return state;
  }

  public void setState(StateBeacon state)
  {
    this.state = state;
  }

}

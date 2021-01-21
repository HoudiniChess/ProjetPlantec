package model;

import behaviorStrategy.BeaconMovement;
import behaviorStrategy.Movement;
import events.SatelliteMoveListener;
import events.SatelliteMoved;
import state.BeaconState;
import state.BeaconStateCollect;

public class Beacon extends ElementMobile implements SatelliteMoveListener
{

  protected BeaconState state;
  Movement collectMovement; // Comportement nominal de l'element mobile.
  protected Memory memory;

  public Beacon(Memory memory)
  {
    super();
    this.memory = memory;
    this.state = new BeaconStateCollect();
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

  public Movement getCollectMovement()
  {
    return collectMovement;
  }

  public void setCollectMovement(Movement collectMovement)
  {
    this.collectMovement = collectMovement;
  }

}

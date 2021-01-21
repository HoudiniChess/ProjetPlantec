package model;

import behaviorStrategy.Movement;
import state.BeaconState;
import state.BeaconStateCollect;

public class Beacon extends ElementMobile
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

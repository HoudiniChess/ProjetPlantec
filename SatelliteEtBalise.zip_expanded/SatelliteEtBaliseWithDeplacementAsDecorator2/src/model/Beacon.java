package model;

import movementStrategy.Movement;
import state.BeaconState;
import state.BeaconStateCollect;

public class Beacon extends ElementMobile
{

  protected BeaconState state;
  Movement collectMovement; // Comportement nominal de l'element mobile.
  protected Integer standartDeepness;

  public Beacon(Memory memory)
  {
    super(memory);
    this.state = new BeaconStateCollect();
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

  public Movement getCollectMovement()
  {
    return collectMovement;
  }

  public void setCollectMovement(Movement collectMovement)
  {
    this.collectMovement = collectMovement;
  }

  public Integer getStandartDeepness()
  {
    return standartDeepness;
  }

  public void setStandartDeepness(Integer standartDeepness)
  {
    this.standartDeepness = standartDeepness;
  }

}

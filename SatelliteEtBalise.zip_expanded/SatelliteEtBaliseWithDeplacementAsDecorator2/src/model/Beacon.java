package model;

import behaviorStrategy.BeaconDeplacement;
import behaviorStrategy.DiveMovement;
import behaviorStrategy.MonteSurfacePourSynchro;
import behaviorStrategy.Movement;
import behaviorStrategy.SynchronisationMovement;
import events.SatelliteMoveListener;
import events.SatelliteMoved;

public class Beacon extends ElementMobile implements SatelliteMoveListener
{

  public Beacon(int memorySize)
  {
    super(memorySize);
  }

  public int deepness()
  {
    return this.getPosition().y;
  }

  protected void readSensors()
  {
    this.dataSize++;
  }

  @Override
  public void tick()
  {
    this.readSensors();
    if (this.memoryFull())
    {
      Movement diving = new DiveMovement(this.deplacement(), this.deepness());
      Movement synchroBehavior = new SynchronisationMovement(diving);
      Movement nextMovement = new MonteSurfacePourSynchro(synchroBehavior);
      this.setDeplacement(nextMovement);
      this.resetData();
    }
    super.tick();
  }

  @Override
  public void whenSatelliteMoved(SatelliteMoved arg)
  {
    BeaconDeplacement dp = (BeaconDeplacement) this.movement;
    dp.whenSatelliteMoved(arg, this);
  }

}

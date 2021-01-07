package model;

import events.SatelliteMoved;

public class Satellite extends ElementMobile
{

  public Satellite(int memorySize)
  {
    super(memorySize);
  }

  @Override
  public void move()
  {
    super.move();
    this.send(new SatelliteMoved(this));
  }
}

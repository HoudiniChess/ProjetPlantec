package model;

import events.SatelliteMoved;

public class Satellite extends ElementMobile
{

  public Satellite(Memory memory)
  {
    super(memory);
  }

  @Override
  public void move()
  {
    super.move();
    this.send(new SatelliteMoved(this));
  }
}

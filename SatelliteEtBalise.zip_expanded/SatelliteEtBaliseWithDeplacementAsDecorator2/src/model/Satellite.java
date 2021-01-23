package model;

import events.SatelliteMoved;

public class Satellite extends ElementMobile
{
  protected Memory memory;

  public Satellite(Memory memory)
  {
    super(memory);
    this.memory = memory;

  }

  @Override
  public void move()
  {
    super.move();
    this.send(new SatelliteMoved(this));
  }
}

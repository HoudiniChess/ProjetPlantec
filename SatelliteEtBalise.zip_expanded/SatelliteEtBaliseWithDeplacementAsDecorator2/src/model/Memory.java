package model;

import eventHandler.EventHandler;

public class Memory
{
  protected Integer size;
  protected Integer fillMemory;
  protected EventHandler eventHandler;

  public Memory(Integer size)
  {
    this.size = size;
    this.fillMemory = 0;
    this.eventHandler = new EventHandler();
  }

  public Integer getSize()
  {
    return size;
  }

  public void setSize(Integer size)
  {
    this.size = size;
  }

  public Integer getFillMemory()
  {
    return fillMemory;
  }

  public void setFillMemory(Integer fillMemory)
  {
    this.fillMemory = fillMemory;
  }

}

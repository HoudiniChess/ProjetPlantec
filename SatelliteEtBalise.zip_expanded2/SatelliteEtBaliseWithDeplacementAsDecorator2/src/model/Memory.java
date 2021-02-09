package model;

import eventHandler.AbstractEvent;
import eventHandler.EventHandler;
import events.MemoryChanged;

public class Memory
{

  private final static int DATA_SIZE_INCREMENT = 1;
  protected Integer size;
  protected Integer fillMemory;
  protected EventHandler eventHandler;

  public Memory(Integer size)
  {
    this.size = size;
    this.fillMemory = 0;
    this.eventHandler = new EventHandler();
  }

  public void tick()
  {
    addData(DATA_SIZE_INCREMENT);
  }

  public void addData(int data)
  {
    if (this.memoryFull())
      return;

    this.fillMemory += data;
    if (this.fillMemory > this.size)
    {
      this.fillMemory = this.size;
    }
    this.send(new MemoryChanged(this));
  }

  public void removeData(int data)
  {
    if (this.fillMemory == 0)
      return;

    this.fillMemory -= data;
    if (this.fillMemory < 0)
    {
      this.fillMemory = 0;
    }
    this.send(new MemoryChanged(this));
  }

  public void resetData()
  {
    this.fillMemory = 0;
    this.send(new MemoryChanged(this));
  }

  public void send(AbstractEvent e)
  {
    eventHandler.send(e);
  }

  public boolean memoryFull()
  {
    return fillMemory >= size;
  }

  public boolean memoryEmpty()
  {
    return fillMemory == 0;
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

  // Events
  public void registerListener(Class<? extends AbstractEvent> whichEventType, Object listener)
  {
    eventHandler.registerListener(whichEventType, listener);
  }

  public void unregisterListener(Class<? extends AbstractEvent> whichEventType, Object listener)
  {
    eventHandler.unregisterListener(whichEventType, listener);
  }

}

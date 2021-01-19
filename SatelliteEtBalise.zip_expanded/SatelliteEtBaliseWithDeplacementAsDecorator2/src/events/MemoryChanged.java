package events;

import eventHandler.AbstractEvent;

public class MemoryChanged extends AbstractEvent
{

  public MemoryChanged(Object source)
  {
    super(source);
  }

  @Override
  public void runOn(Object target)
  {
    MemoryChangeListener listener = (MemoryChangeListener) target;
    Memory memory = (Memory) this.getSource();

    if (memory.memoryFull())
    {
      listener.whenMemoryFull(this);
    }

    else if (memory.memoryEmpty())
    {
      listener.whenMemoryEmpty(this);
    }

    else
    {
      listener.whenMemoryChanged(this);
    }
  }

}

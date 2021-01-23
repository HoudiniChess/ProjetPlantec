package events;

import eventHandler.AbstractEvent;
import model.Memory;

public class MemoryChanged extends AbstractEvent
{

  private static final long serialVersionUID = 7813602985694517237L;

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

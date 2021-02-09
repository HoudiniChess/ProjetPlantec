package events;

public interface MemoryChangeListener
{
  public void whenMemoryChanged(MemoryChanged memoryChanged);

  public void whenMemoryFull(MemoryChanged memoryFull);

  public void whenMemoryEmpty(MemoryChanged memoryEmpty);
}

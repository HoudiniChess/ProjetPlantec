package events;

import behaviorStrategy.SynchronisationMovement;
import eventHandler.AbstractEvent;

public class SynchroEvent extends AbstractEvent
{
  private static final long serialVersionUID = 480096146703824993L;

  public SynchroEvent(Object source)
  {
    super(source);
  }

  @Override
  public void runOn(Object target)
  {
    SynchroEventListener listener = (SynchroEventListener) target;
    SynchronisationMovement movement = (SynchronisationMovement) this.getSource();
    if (movement.synchroStarted())
      listener.whenStartSynchro(this);
    else
      listener.whenStopSynchro(this);
  }
}

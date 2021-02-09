package events;

import eventHandler.AbstractEvent;
import state.BeaconStateSynchro;

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
    BeaconStateSynchro synchro = (BeaconStateSynchro) this.getSource();
    if (synchro.synchroStarted())
      listener.whenStartSynchro(this);
    else
      listener.whenStopSynchro(this);
  }
}

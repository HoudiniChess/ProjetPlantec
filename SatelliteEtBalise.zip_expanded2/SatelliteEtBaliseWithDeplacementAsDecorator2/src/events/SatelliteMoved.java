package events;

import eventHandler.AbstractEvent;

public class SatelliteMoved extends AbstractEvent
{
  private static final long serialVersionUID = 480096146703824993L;

  public SatelliteMoved(Object source)
  {
    super(source);
  }

  @Override
  public void runOn(Object target)
  {
    SatelliteMoveListener listener = (SatelliteMoveListener) target;
    listener.whenSatelliteMoved(this);
  }
}

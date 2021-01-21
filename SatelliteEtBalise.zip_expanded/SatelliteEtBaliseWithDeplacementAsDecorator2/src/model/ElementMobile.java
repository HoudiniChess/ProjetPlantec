package model;

import java.awt.Point;

import behaviorStrategy.Movement;
import eventHandler.AbstractEvent;
import eventHandler.EventHandler;
import events.PositionChanged;

public class ElementMobile
{
  Movement movement;

  Point position;
  EventHandler eventHandler;
  Manager manager;

  public ElementMobile()
  {
    eventHandler = new EventHandler();
    this.position = new Point(0, 0);

  }

  public void setManager(Manager manager)
  {
    this.manager = manager;

  }

  // enregistrement des listeners
  public void registerListener(Class<? extends AbstractEvent> whichEventType, Object listener)
  {
    eventHandler.registerListener(whichEventType, listener);
  }

  public void unregisterListener(Class<? extends AbstractEvent> whichEventType, Object listener)
  {
    eventHandler.unregisterListener(whichEventType, listener);
  }

  // envoi des evenements
  public void send(AbstractEvent event)
  {
    eventHandler.send(event);
  }

  public void tick()
  {
    this.move();
  }

  public void move()
  {
    this.movement.move(this);
    this.send(new PositionChanged(this));
  }

  public void setPosition(Point position)
  {
    if (this.position.equals(position))
      return;
    this.position = position;
  }

  public Point getPosition()
  {
    return position;
  }

  public Movement getMovement()
  {
    return this.movement;
  }

  public void setMovement(Movement depl)
  {
    this.movement = depl;
  }

  public Manager getManager()
  {
    return manager;
  }

}

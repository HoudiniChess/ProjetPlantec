package movementStrategy;

import java.awt.Point;

import model.ElementMobile;

public class HorizontalMovement extends BeaconMovement
{
  Integer start;
  Integer end;
  Boolean fromStartToEnd = true;

  public HorizontalMovement(int speed, Integer start, Integer end)
  {
	super(speed);
    this.start = start;
    this.end = end;
  }

  @Override
  public void move(ElementMobile target)
  {
    Point p = target.getPosition();
    int x = p.x;
    if (fromStartToEnd)
    {
      x += speed;
      if (x > end)
        fromStartToEnd = false;
    }
    else
    {
      x -= speed;
      if (x < start)
        fromStartToEnd = true;
    }
    target.setPosition(new Point(x, p.y));
  }

}

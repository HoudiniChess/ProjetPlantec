package behaviorStrategy;

import java.awt.Point;

import model.ElementMobile;

public class VerticalMovement extends BeaconMovement
{
  Integer min;
  Integer max;
  Boolean goUp = false;

  public VerticalMovement(Integer min, Integer max)
  {
    this.min = min;
    this.max = max;
  }

  @Override
  public void move(ElementMobile target)
  {
    Point p = target.getPosition();
    int y = p.y;
    if (goUp)
    {
      y -= 3;
      if (y < min)
        goUp = false;
    }
    else
    {
      y += 3;
      if (y > max)
        goUp = true;
    }
    target.setPosition(new Point(p.x, y));
  }

}

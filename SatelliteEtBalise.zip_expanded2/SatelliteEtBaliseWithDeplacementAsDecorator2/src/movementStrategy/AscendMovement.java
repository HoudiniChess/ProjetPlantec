package movementStrategy;

import java.awt.Point;

import model.ElementMobile;

public class AscendMovement extends BeaconMovement
{

  public AscendMovement(int speed) {
		super(speed);
  }

@Override
  public void move(ElementMobile target)
  {
    Point p = target.getPosition();
    int y = p.y;
    if (y > 0)
    {
      y -= speed;
      if (y <= 0)
      {
        y = 0;
        super.setFinish();
      }

      target.setPosition(new Point(p.x, y));
    }
  }

}

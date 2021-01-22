package behaviorStrategy;

import java.awt.Point;

import model.Beacon;

public class DiveMovement extends BeaconMovement
{
  int deepness;

  public DiveMovement(int deepness)
  {
    this.deepness = deepness;
  }

  @Override
  public void move(Beacon target)
  {
    Point p = target.getPosition();
    int y = p.y;
    if (y < this.deepness)
    {
      y += 3;
      if (y > this.deepness)
      {
        y = this.deepness;
        super.setFinish();
      }
      target.setPosition(new Point(p.x, y));
    }

  }

}

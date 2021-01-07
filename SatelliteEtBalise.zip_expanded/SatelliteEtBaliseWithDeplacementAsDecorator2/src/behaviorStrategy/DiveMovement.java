package behaviorStrategy;

import java.awt.Point;

import model.Beacon;

public class DiveMovement extends BeaconDeplacement
{
  int deepness;

  public DiveMovement(Movement next, int deepness)
  {
    super(next);
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
        y = this.deepness;
      target.setPosition(new Point(p.x, y));
    }
    else
    {
      target.setDeplacement(next);
    }
  }

}

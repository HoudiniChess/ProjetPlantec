package behaviorStrategy;

import java.awt.Point;

import model.ElementMobile;

public class SinusoidaleMovement extends BeaconMovement
{

  private int minX;
  private int maxX;

  private int minY;
  private int maxY;

  private int defaultSpeed = 3;

  public SinusoidaleMovement(int minX, int maxX, int minY, int maxY)
  {
    super(null);
    this.minX = minX;
    this.maxX = maxX;

    this.minY = minY;
    this.maxY = maxY;
  }

  @Override
  public void move(ElementMobile target)
  {
    System.out.println("Move - SinusoidaleMovement");
    Point p = target.getPosition();
    System.out.println(p);
    int x = p.x;
    int y = p.y;
    x += defaultSpeed;
    if (x < this.minX || x > this.maxX)
    {
      defaultSpeed *= -1;
    }
    y = (int) (this.minY * (Math.sin(x * 0.5 * Math.PI / 40))) + (this.maxY - this.minY);
    target.setPosition(new Point(x, y));

  }

}

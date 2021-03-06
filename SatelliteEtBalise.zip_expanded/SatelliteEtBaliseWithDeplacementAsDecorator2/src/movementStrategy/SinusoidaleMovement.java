package movementStrategy;

import java.awt.Point;

import model.ElementMobile;

public class SinusoidaleMovement extends BeaconMovement
{

  private int minX;
  private int maxX;

  private int minY;
  private int maxY;

  

  public SinusoidaleMovement(int speed, int minX, int maxX, int minY, int maxY)
  {
	  super(speed);
    this.minX = minX;
    this.maxX = maxX;

    this.minY = minY;
    this.maxY = maxY;
    
   
  }

  @Override
  public void move(ElementMobile target)
  {
    Point p = target.getPosition();
    int x = p.x;
    int y = p.y;
    x += speed;
    if (x < this.minX || x > this.maxX)
    {
    	speed *= -1;
    }
    y = (int) (this.minY * (Math.sin(x * 0.5 * Math.PI / 40))) + (this.maxY - this.minY);
    target.setPosition(new Point(x, y));

  }

}

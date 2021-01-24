package movementStrategy;

import model.ElementMobile;

public abstract class Movement
{
  boolean finish = false;
  protected int speed;

  Movement(int speed)
  {
    this.speed = Math.abs(speed);
  }

  /**
   * Effectue l'algorithme de deplacement sur le target en parammêtre
   * 
   * @param target
   */
  abstract public void move(ElementMobile target);

  public boolean isFinish()
  {
    return this.finish;
  }

  public void setFinish()
  {
    this.finish = !this.finish;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void setSpeed(int speed)
  {
    this.speed = speed;
  }

}

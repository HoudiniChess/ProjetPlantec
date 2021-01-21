package behaviorStrategy;

import model.ElementMobile;

public abstract class Movement
{
  boolean finish = false;

  abstract public void move(ElementMobile target);

  public boolean isFinish()
  {
    return this.finish;
  }

  public void setFinish()
  {
    this.finish = !this.finish;
  }
}

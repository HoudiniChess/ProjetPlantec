package behaviorStrategy;

import model.ElementMobile;

public abstract class Movement
{
  abstract public void move(ElementMobile target);

  public Movement replacement()
  {
    return this;
  }
}

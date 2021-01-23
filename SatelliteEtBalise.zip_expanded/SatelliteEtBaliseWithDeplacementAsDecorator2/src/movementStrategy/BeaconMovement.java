package movementStrategy;

import model.Beacon;
import model.ElementMobile;

public class BeaconMovement extends Movement
{

  BeaconMovement(int speed) {
		super(speed);
	}

public void move(Beacon target)
  {}

  @Override
  public void move(ElementMobile target)
  {
    this.move((Beacon) target);
  }

}

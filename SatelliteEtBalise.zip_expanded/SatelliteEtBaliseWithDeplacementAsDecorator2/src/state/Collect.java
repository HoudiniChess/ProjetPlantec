package state;

import model.Beacon;

public class Collect extends State
{

  @Override
  public void behaviorState(Beacon beacon)
  {
    // Si l'état courant continue
    if (this.shouldContinue(beacon))
      beacon.readSensors();
    // si non passer à l'état suivant
    else
    {
      this.nextState(beacon);
    }

  }

  private boolean shouldContinue(Beacon beacon)
  {
    if (!beacon.memoryFull())
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  @Override
  public void nextState(Beacon beacon)
  {
    SynchroStateBeacon stateSynchro = new SynchroStateBeacon();
    beacon.setState(stateSynchro);
  }

  public void install(Beacon beacon)
  {
    // que se passe t'il quand l'état est intalle
  }

}

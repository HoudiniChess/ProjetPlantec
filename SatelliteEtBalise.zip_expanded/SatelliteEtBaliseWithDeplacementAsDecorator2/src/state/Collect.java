package state;

import model.Beacon;

public class Collect extends State
{

  @Override
  public void behaviorState(Beacon beacon)
  {
    // Si l'�tat courant continue
    if (this.shouldContinue(beacon))
      beacon.readSensors();
    // si non passer � l'�tat suivant
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
    // que se passe t'il quand l'�tat est intalle
  }

}

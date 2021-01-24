package state;

import events.SatelliteMoveListener;
import events.SatelliteMoved;
import events.SynchroEvent;
import model.Beacon;
import model.Satellite;

/**
 * 
 * @author yannl
 *
 */
public class BeaconStateSynchro extends BeaconState implements SatelliteMoveListener
{

  protected final static int SYNCHROTIME = 20;
  protected Satellite satSynchro;
  protected Beacon beacon;

  @Override
  public void install(Beacon beacon)
  {
    this.beacon = beacon;
    beacon.getManager().beaconReadyForSynchro(this);
  }

  @Override
  public void behaviorState(Beacon beacon)
  {

    if (!this.synchroStarted())
    {
      return;
    }

    beacon.getMemory().removeData(SYNCHROTIME);
    satSynchro.getMemory().addData(SYNCHROTIME);

    // Todo: Amélioration avec les satellites qui vont déposer leur données à un bateau
    if (satSynchro.getMemory().memoryFull())
    {
      satSynchro.getMemory().resetData();
    }

    if (beacon.getMemory().getFillMemory() == 0)
    {

      Satellite sat = this.satSynchro;
      this.satSynchro = null;
      beacon.send(new SynchroEvent(this));
      sat.send(new SynchroEvent(this));
      beacon.getManager().beaconSynchroDone(this);
      this.nextState(beacon);
    }
  }

  @Override
  public void nextState(Beacon beacon)
  {
    BeaconStateDiving stateDiving = new BeaconStateDiving();
    stateDiving.install(beacon);
    beacon.setState(stateDiving);
  }

  public Boolean synchroStarted()
  {
    return this.satSynchro != null;
  }

  @Override
  public void whenSatelliteMoved(SatelliteMoved arg)
  {
    if (this.synchroStarted())
      return;
    Satellite sat = (Satellite) arg.getSource();
    int satX = sat.getPosition().x;
    int tarX = beacon.getPosition().x;
    if (satX > tarX - 20 && satX < tarX + 20)
    {
      setSatSynchro(sat);
      beacon.send(new SynchroEvent(this));
      this.satSynchro.send(new SynchroEvent(this));
    }
  }

  public Satellite getSatSynchro()
  {
    return satSynchro;
  }

  public void setSatSynchro(Satellite satSynchro)
  {
    this.satSynchro = satSynchro;
  }

}

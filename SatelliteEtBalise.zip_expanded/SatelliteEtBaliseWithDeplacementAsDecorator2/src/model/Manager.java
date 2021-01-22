package model;

import java.util.ArrayList;

import events.SatelliteMoved;
import state.BeaconStateSynchro;

public class Manager
{
  ArrayList<Satellite> sats = new ArrayList<Satellite>();
  ArrayList<Beacon> bals = new ArrayList<Beacon>();

  public void addBalise(Beacon bal)
  {
    bals.add(bal);
    bal.setManager(this);
  }

  public void addSatellite(Satellite sat)
  {
    this.sats.add(sat);
    sat.setManager(this);
  }

  public void tick()
  {
    for (Beacon b : this.bals)
    {
      b.tick();
    }
    for (Satellite s : this.sats)
    {
      s.tick();
    }
  }

  public void beaconReadyForSynchro(BeaconStateSynchro b)
  {
    for (Satellite s : this.sats)
    {
      s.registerListener(SatelliteMoved.class, b);
    }
  }

  public void beaconSynchroDone(BeaconStateSynchro b)
  {
    for (Satellite s : this.sats)
    {
      s.unregisterListener(SatelliteMoved.class, b);
    }
  }

}

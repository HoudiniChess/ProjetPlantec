package model;

import java.util.ArrayList;

import events.SatelliteMoved;

public class Manager {
	ArrayList<Satellite> sats = new ArrayList<Satellite>();
	ArrayList<Beacon> bals = new ArrayList<Beacon>();
	public void addBalise(Beacon bal) {
		bals.add(bal);
		bal.setManager(this);
	}
	public void addSatellite(Satellite sat) {
		this.sats.add(sat);
		sat.setManager(this);
	}
	public void tick() {
		for (Beacon b : this.bals) {
			b.tick();
		}
		for (Satellite s : this.sats) {
			s.tick();
		}
	}
	
	public void baliseReadyForSynchro(Beacon b) {
		for (Satellite s : this.sats) {			
			s.registerListener(SatelliteMoved.class, b);
		}
	}
	public void baliseSynchroDone(Beacon b) {
		for (Satellite s : this.sats) {			
			s.unregisterListener(SatelliteMoved.class, b);
		}
	}

}

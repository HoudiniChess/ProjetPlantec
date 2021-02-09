package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Beacon;
import model.Manager;
import model.Memory;
import model.Satellite;
import movementStrategy.HorizontalMovement;
import movementStrategy.Movement;
import state.BeaconStateAscend;
import state.BeaconStateCollect;
import state.BeaconStateDiving;
import state.BeaconStateSynchro;

class TestBeaconState
{

  @Test
  void testStateChange()
  {

    Memory memory = new Memory(100);
    Memory memory2 = new Memory(1000);
    Beacon beacon = new Beacon(memory);
    Satellite sat = new Satellite(memory2);
    Manager m = new Manager();
    m.addBalise(beacon);
    beacon.setStandartDeepness(150);
    Movement movement = new HorizontalMovement(1, 0, 10);
    beacon.setMovement(movement);
    beacon.setCollectMovement(movement);
    assertEquals(new BeaconStateCollect().getClass(), beacon.getState().getClass());
    beacon.getMemory().addData(100);
    m.tick();
    assertEquals(new BeaconStateAscend().getClass(), beacon.getState().getClass());
    beacon.getMovement().setFinish();
    m.tick();
    BeaconStateSynchro stateSynchro = new BeaconStateSynchro();
    assertEquals(stateSynchro.getClass(), beacon.getState().getClass());
    ((BeaconStateSynchro) beacon.getState()).setSatSynchro(sat);
    beacon.getMemory().removeData(100);
    m.tick();
    assertEquals(new BeaconStateDiving().getClass(), beacon.getState().getClass());
    beacon.getMovement().setFinish();
    m.tick();
    assertEquals(new BeaconStateCollect().getClass(), beacon.getState().getClass());
  }

}

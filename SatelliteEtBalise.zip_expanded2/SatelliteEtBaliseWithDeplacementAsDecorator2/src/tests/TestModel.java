package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Beacon;
import model.ElementMobile;
import model.Memory;

class TestModel
{

  @Test
  void testMemory()
  {
    Memory memory = new Memory(100);
    ElementMobile beacon = new Beacon(memory);
    assertEquals(100, beacon.getMemory().getSize());

    assertEquals(0, beacon.getMemory().getFillMemory());
    beacon.getMemory().addData(100);
    assertTrue(beacon.getMemory().memoryFull());
    beacon.getMemory().removeData(80);
    assertEquals(20, beacon.getMemory().getFillMemory());

    beacon.getMemory().resetData();
    assertEquals(0, beacon.getMemory().getFillMemory());
  }

}

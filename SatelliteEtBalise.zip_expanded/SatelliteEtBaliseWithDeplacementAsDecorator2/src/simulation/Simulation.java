package simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import behaviorStrategy.HorizontalMovement;
import behaviorStrategy.Movement;
import behaviorStrategy.SatelliteMovement;
import behaviorStrategy.SinusoidaleMovement;
import behaviorStrategy.VerticalMovement;
import graphicLayer.GBounded;
import graphicLayer.GRect;
import graphicLayer.GSpace;
import model.Beacon;
import model.Manager;
import model.Memory;
import model.Satellite;

public class Simulation
{

  Manager manager = new Manager();
  GSpace world = new GSpace("Satellite & Balises", new Dimension(800, 600));

  public void mainLoop()
  {
    while (true)
    {
      manager.tick();
      try
      {
        Thread.sleep(50);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  public void addBeacon(GBounded sea, Point startPos, Movement depl, Memory memory)
  {
    Beacon bal = new Beacon(memory);
    bal.setPosition(startPos);
    bal.setMouvement(depl);
    manager.addBalise(bal);
    GrBalise grbal = new GrBalise();
    grbal.setModel(bal);
    sea.addElement(grbal);
  }

  public void addSatellite(GBounded sky, Point startPos, int vitesse, Memory memory)
  {
    Satellite sat = new Satellite(memory);
    sat.setPosition(startPos);
    sat.setMouvement(new SatelliteMovement(-10, 1000, vitesse));
    manager.addSatellite(sat);
    GrSatelitte grSat = new GrSatelitte();
    grSat.setModel(sat);
    sky.addElement(grSat);
  }

  public void launch()
  {
    GRect sky = new GRect();
    sky.setColor(Color.WHITE);
    sky.setDimension(new Dimension(800, 300));
    GRect sea = new GRect();
    sea.setColor(Color.blue);
    sea.setDimension(new Dimension(800, 300));
    sea.setPosition(new Point(0, 300));
    this.world.addElement(sky);
    this.world.addElement(sea);
    this.addSatellite(sky, new Point(10, 50), 2, new Memory(10000));
    this.addSatellite(sky, new Point(100, 10), 1, new Memory(10000));
    this.addSatellite(sky, new Point(400, 90), 3, new Memory(10000));
    this.addSatellite(sky, new Point(500, 140), 4, new Memory(10000));
    this.addSatellite(sky, new Point(600, 10), 1, new Memory(10000));
    this.addBeacon(sea, new Point(400, 200), new HorizontalMovement(50, 750), new Memory(300));
    this.addBeacon(sea, new Point(100, 100), new VerticalMovement(50, 200), new Memory(400));
    this.addBeacon(sea, new Point(0, 160), new HorizontalMovement(0, 800), new Memory(200));
    this.addBeacon(sea, new Point(200, 100), new VerticalMovement(130, 270), new Memory(500));
    this.addBeacon(sea, new Point(300, 100), new SinusoidaleMovement(100, 700, 50, 200), new Memory(150));
    this.world.open();
    this.mainLoop();
  }

  public static void main(String[] args)
  {
    new Simulation().launch();
  }

}

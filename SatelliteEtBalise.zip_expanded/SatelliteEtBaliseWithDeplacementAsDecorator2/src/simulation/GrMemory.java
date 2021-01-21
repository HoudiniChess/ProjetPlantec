package simulation;

import java.awt.Color;
import java.awt.Dimension;

import events.MemoryChangeListener;
import events.MemoryChanged;
import graphicLayer.GRect;
import model.Memory;

public class GrMemory extends GRect implements MemoryChangeListener
{
  private final static int LOADING_BAR_HEIGHT = 60;
  GRect loadingBar;

  public GrMemory()
  {
    super();
    this.setDimension(new Dimension(15, LOADING_BAR_HEIGHT));
    this.setBorderColor(Color.BLACK);
    this.loadingBar = new GRect();
    this.loadingBar.setDimension(new Dimension(14, 1));
    this.loadingBar.setColor(Color.green);
    this.addElement(loadingBar);
  }

  @Override
  public void whenMemoryChanged(MemoryChanged memoryChanged)
  {
    Memory memory = (Memory) memoryChanged.getSource();
    int pourcentage = memory.getFillMemory() * 60 / memory.getSize();

    this.loadingBar.setDimension(new Dimension(14, pourcentage));
    this.repaint();

  }

  @Override
  public void whenMemoryFull(MemoryChanged memoryFull)
  {
    this.loadingBar.setColor(Color.red);

  }

  @Override
  public void whenMemoryEmpty(MemoryChanged memoryEmpty)
  {
    this.loadingBar.setColor(Color.green);
    this.loadingBar.setDimension(new Dimension(14, 1));

  }

}

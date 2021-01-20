package simulation;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import events.MemoryChanged;
import graphicLayer.GImage;
import model.Beacon;
import model.ElementMobile;
import model.Memory;

public class GrBalise extends GrElementMobile
{
  protected GrMemory grMemory;

  public GrBalise()
  {
    this.grMemory = new GrMemory();
    this.addElement(grMemory);
    File path = new File("balise.png");
    this.withoutBorder();
    this.withoutBackground();
    BufferedImage rawImage = null;
    try
    {
      rawImage = ImageIO.read(path);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    this.addElement(new GImage(rawImage));
    this.setDimension(new Dimension(rawImage.getWidth(), rawImage.getHeight()));
  }

  @Override
  public void setModel(ElementMobile model)
  {
    super.setModel(model);
    Memory memoire = ((Beacon) model).getMemory();
    memoire.registerListener(MemoryChanged.class, this.grMemory);

  }

}

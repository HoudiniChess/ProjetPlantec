package state;

import model.Beacon;

public abstract class BeaconState
{
  protected boolean isInstall = false;

  /**
   * Execute le comportmeent de balise
   * 
   * @param beacon
   */
  public abstract void behaviorState(Beacon beacon);

  /**
   * Change l'etat du beacon passer en parametre
   * 
   * @param beacon
   */
  public abstract void nextState(Beacon beacon);

  /**
   * Installe les attributs necessaire au fonctionnement de l'état
   * 
   * @param beacon
   */
  public abstract void install(Beacon beacon);

}

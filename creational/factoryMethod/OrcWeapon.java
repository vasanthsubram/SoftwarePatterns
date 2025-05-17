package patterns.creational.factoryMethod;

import java.util.Calendar;

public class OrcWeapon implements Weapon {

  private WeaponType weaponType;

  public OrcWeapon(WeaponType weaponType) {
    this.weaponType = weaponType;
  }

  @Override
  public String toString() {
    return "Orcish " + weaponType;
  }

  @Override
  public WeaponType getWeaponType() {
    return weaponType;
  }
}
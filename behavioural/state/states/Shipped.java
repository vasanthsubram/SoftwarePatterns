package patterns.behavioural.state.states;

import patterns.behavioural.state.DeliveryContext;
import patterns.behavioural.state.PackageState;

public class Shipped implements PackageState {
  //Singleton
  private static Shipped instance = new Shipped();

  private Shipped() {}

  public static Shipped instance() {
    return instance;
  }

  //Business logic and state transition
  @Override
  public void updateState(DeliveryContext ctx) {
    System.out.println("Package is shipped !!");
    ctx.setCurrentState(InTransition.instance());
  }
}
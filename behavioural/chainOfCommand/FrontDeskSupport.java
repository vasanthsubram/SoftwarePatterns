package patterns.behavioural.chainOfCommand;

public class FrontDeskSupport implements SupportService {

  private SupportService next = null;

  public FrontDeskSupport (SupportService next){
    this.next = next;
  }

  @Override
  public void handleRequest(ServiceRequest service) {
    if(service.getType() == ServiceLevel.LEVEL_ONE) {
      service.setConclusion("Front desk solved level one reuqest !!");
    } else {
      if(next != null){
        next.handleRequest(service);
      } else {
        throw new IllegalArgumentException("No handler found for :: " + service.getType());
      }
    }
  }
}
package patterns.behavioural.mediator;

public interface ChatRoom
{
  public void sendMessage(String msg, String userId);

  void addUser(User user);
}
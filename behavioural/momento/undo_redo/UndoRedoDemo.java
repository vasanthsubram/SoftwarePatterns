package patterns.behavioural.momento.undo_redo;

public class UndoRedoDemo {

  public static void main(String[] args) {
    ChangeManager manager = new ChangeManager();
    manager.addChangeable(new CommandLineChanger("Hello"));
    manager.addChangeable(new CommandLineChanger("there "));
    manager.undo();
    manager.redo();
    manager.undo();
    manager.undo();
    manager.addChangeable(new CommandLineChanger("world"));
    manager.undo();
  }
}




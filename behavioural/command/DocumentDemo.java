package patterns.behavioural.command;

import java.util.Stack;

interface Command {
    public void execute();
}
 interface UndoableCommand extends Command{
    public void undo();
}

 class Document {
    private String text;
    public Document(String text){
        this.text=text;
    }
    public void boldSelection(){}
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}

 class BoldCommand implements UndoableCommand {
    //the command always needs the target to work with
    private Document document;
    private String previousText;

    public BoldCommand(Document doc) {
        this.document = doc;
        previousText = this.document.getText();
    }

    public void execute() {
        System.out.println("Making text bold");
        document.boldSelection();
    }

    public void undo() {
        System.out.println("Undoing: text is not bold");
        document.setText(previousText);
    }
}
public class DocumentDemo {
    private Stack<Command> commandStack = new Stack<Command>();

    public static void main(String[] args) {
        DocumentDemo manager = new DocumentDemo();
        Document doc = new Document("Helo World");
        Command bold = new BoldCommand(doc);
        manager.executeCommand(bold);
        manager.undo();
    }

    public void executeCommand(Command cmd) {
        cmd.execute();
        if (cmd instanceof UndoableCommand) {
            commandStack.push(cmd);
        }
    }

    public void undo() {
        if (commandStack.size() > 0) {
            UndoableCommand cmd = (UndoableCommand) commandStack.pop();
            cmd.undo();
        }
    }
}

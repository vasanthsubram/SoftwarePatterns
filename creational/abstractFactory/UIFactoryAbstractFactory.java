package patterns.creational.abstractFactory;

// Abstract Products
interface Button {
    String render();
}

interface Checkbox {
    String render();
}

// Concrete Products for Windows
class WindowsButton implements Button {
    @Override
    public String render() {
        return "Rendering a Windows-style Button";
    }
}

class WindowsCheckbox implements Checkbox {

    @Override
    public String render() {
        return "Rendering a Windows-style Checkbox";
    }
}

// Concrete Products for macOS
class MacOSButton implements Button {
    @Override
    public String render() {
        return "Rendering a macOS-style Button";
    }
}

class MacOSCheckbox implements Checkbox {

    @Override
    public String render() {
        return "Rendering a macOS-style Checkbox";
    }
}

// Abstract Factory
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factories
class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacOSUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

// Client Code
public class UIFactoryAbstractFactory {
    private UIFactory factory;
    private Button button;
    private Checkbox checkbox;

    public UIFactoryAbstractFactory(UIFactory factory) {
        this.factory = factory;
    }

    public void createUI() {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        System.out.println("Rendering UI elements:");
        System.out.println("- Button: " + button.render());
        System.out.println("- Checkbox: " + checkbox.render());
    }

    public static void main(String[] args) {
        String osType = System.getProperty("os.name").toLowerCase();
        UIFactory factory;

        if (osType.contains("win")) {
            factory = new WindowsUIFactory();
        } else if (osType.contains("mac") || osType.contains("darwin")) {
            factory = new MacOSUIFactory();
        } else {
            System.out.println("Unsupported OS. Using default Windows UI.");
            factory = new WindowsUIFactory();
        }

        UIFactoryAbstractFactory app = new UIFactoryAbstractFactory(factory);
        app.createUI();
        app.renderUI();
    }
}
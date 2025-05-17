package patterns.creational.factoryMethod;

// Abstract Product: Represents a generic UI element
interface UIElement {
    String render();
}

// Concrete Products: Specific UI elements for different platforms
class WindowsButton implements UIElement {
    @Override
    public String render() {
        return "Rendering a Windows-style Button";
    }
}

class MacOSButton implements UIElement {
    @Override
    public String render() {
        return "Rendering a macOS-style Button";
    }
}

class WindowsCheckbox implements UIElement {
    @Override
    public String render() {
        return "Rendering a Windows-style Checkbox";
    }
}

class MacOSCheckbox implements UIElement {
    @Override
    public String render() {
        return "Rendering a macOS-style Checkbox";
    }
}

// Abstract Creator: Defines the interface for creating UI elements (Factory Method)
interface UIFactory {
    UIElement createButton();
    UIElement createCheckbox();

    default void renderUI() {
        UIElement button = createButton();
        UIElement checkbox = createCheckbox();
        System.out.println("Rendering UI:");
        System.out.println("- Button: " + button.render());
        System.out.println("- Checkbox: " + checkbox.render());
    }
}

// Concrete Creators: Implement the factory methods to create specific UI element families
class WindowsUIFactory implements UIFactory {
    @Override
    public UIElement createButton() {
        return new WindowsButton();
    }

    @Override
    public UIElement createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacOSUIFactory implements UIFactory {
    @Override
    public UIElement createButton() {
        return new MacOSButton();
    }

    @Override
    public UIElement createCheckbox() {
        return new MacOSCheckbox();
    }
}

// Client code
public class UIFactoryMethod {
    public static UIFactory configureUI(String osType) {
        if (osType.equalsIgnoreCase("windows")) {
            return new WindowsUIFactory();
        } else if (osType.equalsIgnoreCase("macos")) {
            return new MacOSUIFactory();
        } else {
            throw new IllegalArgumentException("Unsupported operating system: " + osType);
        }
    }

    public static void main(String[] args) {
        UIFactory windowsFactory = configureUI("windows");
        windowsFactory.renderUI();

        System.out.println("\n---");

        UIFactory macosFactory = configureUI("macos");
        macosFactory.renderUI();
    }
}
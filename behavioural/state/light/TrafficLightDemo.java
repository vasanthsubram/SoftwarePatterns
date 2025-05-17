package patterns.behavioural.state.light;

// 1. State Interface
interface TrafficLightState {
    void handleRequest(TrafficLightContext context);
    String getColor();
}

// 2. Concrete State - Red
class RedLight implements TrafficLightState {
    @Override
    public void handleRequest(TrafficLightContext context) {
        System.out.println("Traffic Light is Red. Waiting...");
        // Transition to Green after some time (simulated)
        context.changeState(new GreenLight());
    }

    @Override
    public String getColor() {
        return "Red";
    }
}

// 3. Concrete State - Yellow
class YellowLight implements TrafficLightState {
    @Override
    public void handleRequest(TrafficLightContext context) {
        System.out.println("Traffic Light is Yellow. Slow down!");
        // Transition to Red after some time (simulated)
        context.changeState(new RedLight());
    }

    @Override
    public String getColor() {
        return "Yellow";
    }
}

// 4. Concrete State - Green
class GreenLight implements TrafficLightState {
    @Override
    public void handleRequest(TrafficLightContext context) {
        System.out.println("Traffic Light is Green. Go!");
        // Transition to Yellow after some time (simulated)
        context.changeState(new YellowLight());
    }

    @Override
    public String getColor() {
        return "Green";
    }
}

// 5. Context
class TrafficLightContext {
    private TrafficLightState currentState;

    public TrafficLightContext() {
        // Initial state
        currentState = new RedLight();
    }

    public void changeState(TrafficLightState newState) {
        System.out.println("Traffic Light changing from " + currentState.getColor() + " to " + newState.getColor());
        this.currentState = newState;
    }

    public void update() {
        currentState.handleRequest(this);
    }

    public String getCurrentColor() {
        return currentState.getColor();
    }
}

// Client Code
public class TrafficLightDemo {
    public static void main(String[] args) {
        TrafficLightContext light = new TrafficLightContext();

        for (int i = 0; i < 5; i++) {
            light.update();
            // Simulate time passing
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


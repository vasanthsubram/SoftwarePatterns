package patterns.creational.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;


public class ConsoleNotifier implements Notifier {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleNotifier.class);

    @PostConstruct
    public void register(){
        Notifier.registerNotifier(getNotifierType(), this);
    }

    @Override
    public void notify(HealthCheckConfiguration healthCheckConfiguration, ServerStatus serverStatus) {
        LOGGER.info("NOTIFICATION: Status changed to : " + serverStatus.toString()
                + " for server at :" + healthCheckConfiguration.getConnection());
    }
    @Override
    public NotifierType getNotifierType() {
        return NotifierType.CONSOLE;
    }
}

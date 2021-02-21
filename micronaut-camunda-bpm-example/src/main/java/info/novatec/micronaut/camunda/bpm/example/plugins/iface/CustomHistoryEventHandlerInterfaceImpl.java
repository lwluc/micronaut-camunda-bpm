package info.novatec.micronaut.camunda.bpm.example.plugins.iface;

import org.camunda.bpm.engine.impl.history.event.HistoryEvent;
import org.camunda.bpm.engine.impl.history.handler.HistoryEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomHistoryEventHandlerInterfaceImpl implements HistoryEventHandler {

    private static final Logger log = LoggerFactory.getLogger(CustomHistoryEventHandlerInterfaceImpl.class);

    @Override
    public void handleEvent(HistoryEvent historyEvent) {
        log.info("{} handling event {}", this.getClass().getSimpleName(), historyEvent);
    }

    @Override
    public void handleEvents(List<HistoryEvent> historyEvents) {
        historyEvents.forEach(this::handleEvent);
    }
}

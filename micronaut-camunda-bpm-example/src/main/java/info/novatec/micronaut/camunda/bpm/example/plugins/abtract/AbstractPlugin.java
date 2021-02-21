package info.novatec.micronaut.camunda.bpm.example.plugins.abtract;

import org.camunda.bpm.engine.impl.cfg.AbstractProcessEnginePlugin;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.history.handler.CompositeDbHistoryEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractPlugin extends AbstractProcessEnginePlugin {

    private static final Logger log = LoggerFactory.getLogger(AbstractPlugin.class);

    public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
        log.info("Registering AbstractPlugin");
        processEngineConfiguration.setHistoryEventHandler(new CompositeDbHistoryEventHandler(new CustomHistoryEventHandlerAbstractImpl()));
    }
}

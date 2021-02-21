package info.novatec.micronaut.camunda.bpm.example.plugins.iface;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.engine.impl.history.handler.CompositeDbHistoryEventHandler;
import org.camunda.bpm.engine.impl.history.handler.HistoryEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterfacePlugin implements ProcessEnginePlugin {

    private static final Logger log = LoggerFactory.getLogger(InterfacePlugin.class);

    @Override
    public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
        log.info("preInit InterfacePlugin");
        processEngineConfiguration.setHistoryEventHandler(new CompositeDbHistoryEventHandler(new HistoryEventHandler[]{new CustomHistoryEventHandlerInterfaceImpl()}));
    }

    @Override
    public void postInit(ProcessEngineConfigurationImpl processEngineConfiguration) {

    }

    @Override
    public void postProcessEngineBuild(ProcessEngine processEngine) {

    }

}

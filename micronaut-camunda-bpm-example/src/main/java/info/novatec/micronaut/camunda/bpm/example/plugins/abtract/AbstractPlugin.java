package info.novatec.micronaut.camunda.bpm.example.plugins.abtract;

import org.camunda.bpm.engine.impl.bpmn.parser.BpmnParseListener;
import org.camunda.bpm.engine.impl.cfg.AbstractProcessEnginePlugin;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AbstractPlugin extends AbstractProcessEnginePlugin {

    private static final Logger log = LoggerFactory.getLogger(AbstractPlugin.class);

    public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
        log.info("Registering AbstractPlugin");
        List<BpmnParseListener> preParseListeners = processEngineConfiguration.getCustomPreBPMNParseListeners();
        if (preParseListeners == null) {
            preParseListeners = new ArrayList<BpmnParseListener>();
            processEngineConfiguration.setCustomPreBPMNParseListeners(preParseListeners);
        }
        preParseListeners.add(new CustomParseListener());
    }
}

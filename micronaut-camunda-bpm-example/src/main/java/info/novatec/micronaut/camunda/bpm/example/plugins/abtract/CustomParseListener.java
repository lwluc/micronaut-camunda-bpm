package info.novatec.micronaut.camunda.bpm.example.plugins.abtract;

import org.camunda.bpm.engine.impl.bpmn.parser.AbstractBpmnParseListener;
import org.camunda.bpm.engine.impl.pvm.process.ActivityImpl;
import org.camunda.bpm.engine.impl.pvm.process.ScopeImpl;
import org.camunda.bpm.engine.impl.util.xml.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomParseListener extends AbstractBpmnParseListener {

    private static final Logger log = LoggerFactory.getLogger(CustomParseListener.class);

    @Override
    public void parseStartEvent(Element startEventElement, ScopeImpl scope, ActivityImpl startEventActivity) {
        super.parseStartEvent(startEventElement, scope, startEventActivity);
        log.info("{} parsing startEventElement {}", this.getClass().getSimpleName(), startEventElement);
    }
}

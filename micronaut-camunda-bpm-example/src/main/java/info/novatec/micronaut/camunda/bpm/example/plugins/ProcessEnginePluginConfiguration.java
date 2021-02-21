package info.novatec.micronaut.camunda.bpm.example.plugins;

import info.novatec.micronaut.camunda.bpm.example.plugins.abtract.AbstractPlugin;
import info.novatec.micronaut.camunda.bpm.example.plugins.iface.InterfacePlugin;
import info.novatec.micronaut.camunda.bpm.feature.DefaultProcessEngineConfigurationCustomizer;
import info.novatec.micronaut.camunda.bpm.feature.MnProcessEngineConfiguration;
import info.novatec.micronaut.camunda.bpm.feature.ProcessEngineConfigurationCustomizer;
import io.micronaut.context.annotation.Replaces;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.identity.impl.ldap.plugin.LdapIdentityProviderPlugin;

import javax.inject.Singleton;
import java.util.List;

@Singleton
@Replaces(DefaultProcessEngineConfigurationCustomizer.class)
public class ProcessEnginePluginConfiguration implements ProcessEngineConfigurationCustomizer {

    @Override
    public void customize(MnProcessEngineConfiguration processEngineConfiguration) {
        List<ProcessEnginePlugin> plugins = processEngineConfiguration.getProcessEnginePlugins();
        plugins.add(ldapIdentityProvider());
        plugins.add(new AbstractPlugin());
        plugins.add(new InterfacePlugin());
        processEngineConfiguration.setProcessEnginePlugins(plugins);
    }

    // Using an open online LDAP to provide an example
    // https://www.forumsys.com/tutorials/integration-how-to/ldap/online-ldap-test-server/
    // Log in e.g. with einstein + password
    private LdapIdentityProviderPlugin ldapIdentityProvider() {
        LdapIdentityProviderPlugin ldap = new LdapIdentityProviderPlugin();
        ldap.setServerUrl("ldap://ldap.forumsys.com:389");
        ldap.setManagerDn("cn=read-only-admin,dc=example,dc=com");
        ldap.setManagerPassword("password");
        ldap.setBaseDn("dc=example,dc=com");
        return ldap;
    }
}

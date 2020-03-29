package org.ServerInteractionDemo;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;

import org.ServerInteractionDemo.health.ConfigurationHealthCheck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class DataServerApplicationTest {
    final         Bootstrap<DataServerConfiguration> bootstrap   = mock(Bootstrap.class);
    private final Environment                        environment = mock(Environment.class);
    private final JerseyEnvironment                  jersey      = mock(JerseyEnvironment.class);
    private final HealthCheckRegistry                healthCheck = mock(HealthCheckRegistry.class);
    private final MetricRegistry                     metrics     = mock(MetricRegistry.class);
    private final DataServerApplication              app         = new DataServerApplication();
    private final DataServerConfiguration            config      = new DataServerConfiguration();

    @BeforeEach
    public void setup() throws Exception {
        this.config.setServer(new Object());
        when(this.environment.healthChecks()).thenReturn(this.healthCheck);
        when(this.environment.metrics()).thenReturn(this.metrics);
        when(this.environment.jersey()).thenReturn(this.jersey);
    }

    @Test
    void testRun() {
        this.app.run(this.config, this.environment);
        verify(this.jersey, times(1)).register(any());
        verify(this.healthCheck).register(any(), isA(ConfigurationHealthCheck.class));
    }

    @Test
    void testSwagger() {
        this.app.initialize(this.bootstrap);
        verify(this.bootstrap).addBundle(isA(SwaggerBundle.class));
    }

    @Test
    void testGetName() {
        assertEquals("DataServer", this.app.getName());
    }
}
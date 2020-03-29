package org.ServerInteractionDemo;

import org.ServerInteractionDemo.api.exceptions.mappers.InvalidOperandExceptionMapper;
import org.ServerInteractionDemo.health.ConfigurationHealthCheck;
import org.ServerInteractionDemo.resources.OperationResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class DataServerApplication extends Application<DataServerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DataServerApplication().run(args);
    }

    @Override
    public String getName() {
        return "DataServer";
    }

    @Override
    public void initialize(final Bootstrap<DataServerConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(new SwaggerBundle<DataServerConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(final DataServerConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
    }

    @Override
    public void run(final DataServerConfiguration configuration,
                    final Environment env) {
        // HEALTH Check
        env.healthChecks()
           .register("ConfigurationHealthCheck",
                     ConfigurationHealthCheck.builder().serverConfiguration(configuration.getServer()).build());

        // EXCEPTION MAPPERS
        env.jersey().register(new InvalidOperandExceptionMapper(env.metrics()));

        // RESOURCES
        env.jersey().register(OperationResource.class);

    }

}

package org.ServerInteractionDemo;

import org.ServerInteractionDemo.health.ConfigurationHealthCheck;
import org.ServerInteractionDemo.resources.StaticResource;

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
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(DataServerConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
    }

    @Override
    public void run(final DataServerConfiguration configuration,
                    final Environment env) {
        // TODO: implement application
        env.healthChecks().register("ConfigurationHealthCheck", ConfigurationHealthCheck.builder().serverConfiguration(configuration.getServer()).build());
        env.jersey().register(StaticResource.class);

    }

}

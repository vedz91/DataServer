package org.ServerInteractionDemo;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
    }

    @Override
    public void run(final DataServerConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}

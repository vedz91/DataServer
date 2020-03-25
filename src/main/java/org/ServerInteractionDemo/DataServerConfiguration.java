package org.ServerInteractionDemo;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.Getter;

@Getter
public class DataServerConfiguration extends Configuration {
    // TODO: implement service configuration
    Object server;

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;
}

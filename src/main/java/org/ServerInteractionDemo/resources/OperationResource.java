package org.ServerInteractionDemo.resources;

import org.ServerInteractionDemo.api.OperationResponse;
import org.ServerInteractionDemo.core.Operation;
import org.ServerInteractionDemo.core.OperationFactory;
import org.ServerInteractionDemo.core.OperationType;
import org.ServerInteractionDemo.literals.SwaggerLiterals;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Path("/operation")
@Api(SwaggerLiterals.OR_API)
public class OperationResource {

    //todo: make default type configurable
    final OperationType DEFAULT_TYPE = OperationType.MULTIPLY;

    @GET
    @ApiOperation(SwaggerLiterals.OR_GET_API)
    @Produces(MediaType.APPLICATION_JSON)
    public OperationResponse compute(
            @QueryParam("type") @ApiParam(defaultValue = "MULTIPLY") final Optional<OperationType> type,
            @QueryParam("opperand1") @ApiParam(required = true) final Double valA,
            @QueryParam("opperand2") @ApiParam(required = true) final Double valB) {

        final Operation operation = OperationFactory.getOperation(type.orElse(this.DEFAULT_TYPE), valA, valB);
        operation.validate();
        return OperationResponse.builder().type(type.orElse(this.DEFAULT_TYPE)).result(operation.compute()).build();
    }
}

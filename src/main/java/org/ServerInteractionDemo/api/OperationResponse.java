package org.ServerInteractionDemo.api;

import org.ServerInteractionDemo.core.OperationType;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OperationResponse {
    OperationType type;
    Double        result;
}

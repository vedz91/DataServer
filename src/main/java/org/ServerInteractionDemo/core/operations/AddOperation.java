package org.ServerInteractionDemo.core.operations;

import org.ServerInteractionDemo.core.OperationBase;

import lombok.Builder;

public class AddOperation extends OperationBase {

    @Builder
    public AddOperation(Double varA, Double varB) {
        super(varA, varB);
    }

    @Override
    public Double compute() {
        return getVarA() + getVarB();
    }

}

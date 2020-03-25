package org.ServerInteractionDemo.core.operations;

import org.ServerInteractionDemo.core.OperationBase;

import lombok.Builder;

public class SubtractOperation extends OperationBase {

    @Builder
    public SubtractOperation(Double varA, Double varB) {
        super(varA, varB);
    }

    @Override
    public Double compute() {
        return getVarA() - getVarB();
    }

}

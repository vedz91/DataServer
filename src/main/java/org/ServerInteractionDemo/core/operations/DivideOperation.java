package org.ServerInteractionDemo.core.operations;

import org.ServerInteractionDemo.api.exceptions.InvalidOperandException;
import org.ServerInteractionDemo.core.OperationBase;
import org.ServerInteractionDemo.literals.ExceptionLiterals;

import lombok.Builder;

public class DivideOperation extends OperationBase {

    @Builder
    public DivideOperation(final Double varA, final Double varB) {
        super(varA, varB);
    }

    @Override
    public Double compute() {
        return this.getVarA() / this.getVarB();
    }

    @Override
    public void validate() {
        super.validate();
        if (this.getVarB() == 0) {
            throw new InvalidOperandException(ExceptionLiterals.E_DIVIDE_BY_ZERO);
        }
    }
}

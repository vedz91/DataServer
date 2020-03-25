package org.ServerInteractionDemo.core;

import org.ServerInteractionDemo.api.exceptions.InvalidOperandException;
import org.ServerInteractionDemo.literals.ExceptionLiterals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class OperationBase implements Operation {
    private Double varA;
    private Double varB;

    @Override
    public void validate() {
        if (this.varA == null || this.varB == null) {
            throw new InvalidOperandException(ExceptionLiterals.E_MISSING_OPERAND);
        }
    }
}

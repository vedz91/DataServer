package org.ServerInteractionDemo.core;

import org.ServerInteractionDemo.api.exceptions.InvalidOperandException;
import org.ServerInteractionDemo.core.operations.AddOperation;
import org.ServerInteractionDemo.core.operations.DivideOperation;
import org.ServerInteractionDemo.core.operations.MultiplyOperation;
import org.ServerInteractionDemo.core.operations.SubtractOperation;
import org.ServerInteractionDemo.literals.ExceptionLiterals;

public class OperationFactory {

    public static Operation getOperation(final OperationType type, final Double varA, final Double varB) {
        if (type == OperationType.ADD) {
            return AddOperation.builder().varA(varA).varB(varB).build();
        }
        else if (type == OperationType.SUBTRACT) {
            return SubtractOperation.builder().varA(varA).varB(varB).build();
        }
        else if (type == OperationType.MULTIPLY) {
            return MultiplyOperation.builder().varA(varA).varB(varB).build();
        }
        else if (type == OperationType.DIVIDE) {
            return DivideOperation.builder().varA(varA).varB(varB).build();
        }
        throw new InvalidOperandException(ExceptionLiterals.E_INVALID_TYPE);
    }
}

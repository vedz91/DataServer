package org.ServerInteractionDemo.core;

import org.ServerInteractionDemo.api.exceptions.InvalidOperandException;
import org.ServerInteractionDemo.core.operations.AddOperation;
import org.ServerInteractionDemo.core.operations.DivideOperation;
import org.ServerInteractionDemo.core.operations.MultiplyOperation;
import org.ServerInteractionDemo.core.operations.SubtractOperation;
import org.ServerInteractionDemo.literals.ExceptionLiterals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationFactoryTest {

    final Double varA = 2d;
    final Double varB = 3d;

    @Test
    void testGetAddOperation() {
        final Operation op1 = OperationFactory.getOperation(OperationType.ADD, this.varA, this.varB);
        assertEquals(AddOperation.class, op1.getClass());
    }

    @Test
    void testGetDivideOperation() {
        final Operation op1 = OperationFactory.getOperation(OperationType.DIVIDE, this.varA, this.varB);
        assertEquals(DivideOperation.class, op1.getClass());
    }

    @Test
    void testGetMultiplyOperation() {
        final Operation op1 = OperationFactory.getOperation(OperationType.MULTIPLY, this.varA, this.varB);
        assertEquals(MultiplyOperation.class, op1.getClass());
    }

    @Test
    void testGetSubstractOperation() {
        final Operation op1 = OperationFactory.getOperation(OperationType.SUBTRACT, this.varA, this.varB);
        assertEquals(SubtractOperation.class, op1.getClass());
    }

    @Test
    void testGetInvalidOperation() {
        final Exception exception = assertThrows(InvalidOperandException.class,
                                                 () -> OperationFactory.getOperation(null, this.varA, this.varB));
        assertEquals(ExceptionLiterals.E_INVALID_TYPE, exception.getMessage());
    }
}
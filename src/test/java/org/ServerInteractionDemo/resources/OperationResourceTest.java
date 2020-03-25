package org.ServerInteractionDemo.resources;

import org.ServerInteractionDemo.api.OperationResponse;
import org.ServerInteractionDemo.api.exceptions.InvalidOperandException;
import org.ServerInteractionDemo.core.OperationType;
import org.ServerInteractionDemo.literals.ExceptionLiterals;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationResourceTest {

    final Double varA = 2d;
    final Double varB = 3d;

    @Test
    void testComputeWithType() {
        final OperationResource resource = new OperationResource();
        final OperationResponse response = resource.compute(Optional.of(OperationType.ADD), this.varA, this.varB);

        assertEquals(this.varA + this.varB, response.getResult());
        assertEquals(OperationType.ADD, response.getType());
    }

    @Test
    void testComputeWithoutType() {
        final OperationResource resource = new OperationResource();
        final OperationResponse response = resource.compute(Optional.empty(), this.varA, this.varB);

        assertEquals(this.varA * this.varB, response.getResult());
        assertEquals(OperationType.MULTIPLY, response.getType());
    }

    @Test
    void testComputeWithoutOperand() {
        final OperationResource resource = new OperationResource();
        final Exception exception = assertThrows(InvalidOperandException.class,
                                                 () -> resource.compute(Optional.of(OperationType.DIVIDE),
                                                                        this.varA,
                                                                        null));
        assertEquals(ExceptionLiterals.E_MISSING_OPERAND, exception.getMessage());
    }

    @Test
    void testComputeDivideByZero() {
        final OperationResource resource = new OperationResource();
        final Exception exception = assertThrows(InvalidOperandException.class,
                                                 () -> resource.compute(Optional.of(OperationType.DIVIDE),
                                                                        this.varA,
                                                                        0d));
        assertEquals(ExceptionLiterals.E_DIVIDE_BY_ZERO, exception.getMessage());
    }
}
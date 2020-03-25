package org.ServerInteractionDemo.core.operations;

import org.ServerInteractionDemo.core.OperationBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplyOperationTest {

    final Double varA = 2d;
    final Double varB = 3d;

    private OperationBase getSampleOperation() {
        return MultiplyOperation.builder().varA(varA).varB(varB).build();
    }

    @Test
    void testBuilder() {
        OperationBase op1 = getSampleOperation();
        assertEquals(varA, op1.getVarA());
        assertEquals(varB, op1.getVarB());
    }

    @Test
    void testCompute() {
        OperationBase op1 = getSampleOperation();
        assertEquals(varA * varB, op1.compute());
    }


}
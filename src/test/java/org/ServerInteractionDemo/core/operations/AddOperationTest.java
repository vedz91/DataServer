package org.ServerInteractionDemo.core.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddOperationTest {

    final Double varA = 2d;
    final Double varB = 3d;

    private AddOperation getSampleOperation() {
        return AddOperation.builder().varA(this.varA).varB(this.varB).build();
    }

    @Test
    void testBuilder() {
        final AddOperation op1 = this.getSampleOperation();
        assertEquals(this.varA, op1.getVarA());
        assertEquals(this.varB, op1.getVarB());
    }

    @Test
    void testCompute() {
        final AddOperation op1 = this.getSampleOperation();
        assertEquals(this.varA + this.varB, op1.compute());
    }


}
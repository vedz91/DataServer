package org.ServerInteractionDemo.core.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivideOperationTest {

    final Double varA = 2d;
    final Double varB = 3d;

    private DivideOperation getSampleOperation() {
        return DivideOperation.builder().varA(varA).varB(varB).build();
    }

    @Test
    void testBuilder() {
        DivideOperation op1 = getSampleOperation();
        assertEquals(varA, op1.getVarA());
        assertEquals(varB, op1.getVarB());
    }

    @Test
    void testCompute() {
        DivideOperation op1 = getSampleOperation();
        assertEquals(varA / varB, op1.compute());
    }


}
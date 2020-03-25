package org.ServerInteractionDemo.core;

import org.ServerInteractionDemo.core.operations.AddOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationBaseTest {

    @Test
    void testBaseConstructor() {
        final Double varA = 2d;
        final Double varB = 3d;
        final OperationBase base = AddOperation.builder().varA(2d).varB(3d).build();
        assertEquals(varA, base.getVarA());
        assertEquals(varB, base.getVarB());
    }
}
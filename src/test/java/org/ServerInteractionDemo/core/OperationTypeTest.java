package org.ServerInteractionDemo.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationTypeTest {

    @Test
    void testToString() {
        final OperationType type = OperationType.ADD;
        assertEquals("add", type.toString());
    }
}
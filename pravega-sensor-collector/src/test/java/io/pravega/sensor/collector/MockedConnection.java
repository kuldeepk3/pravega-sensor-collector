/**
 * Copyright (c) Dell Inc., or its subsidiaries. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package io.pravega.sensor.collector;

import io.pravega.sensor.collector.util.TransactionCoordinator;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.mockito.Mockito.when;

public abstract class MockedConnection {

    @Mock
    protected Connection mockConnection;

    @Mock
    protected Statement mockStatement;

    @Mock
    protected ResultSet mockResultSet;

    @Mock
    protected TransactionCoordinator transactionCoordinator;


    protected void before() throws SQLException {
        MockitoAnnotations.initMocks(this);
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery("select count(id) from Queue")).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
    }


}

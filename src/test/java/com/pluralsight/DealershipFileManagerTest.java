package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealershipFileManagerTest {

    @Test
    void testVehicleListLoads() {

        DealershipFileManager.readFile();

        assertFalse(DealershipFileManager.dealership.getAllVehicles().isEmpty());
    }
}
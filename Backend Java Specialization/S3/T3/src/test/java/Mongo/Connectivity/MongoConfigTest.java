package Mongo.Connectivity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MongoConfigTest {

    @Test
    void getConnectionString() {
        assertEquals("mongodb://it-academy-access:fneH5P95Yqmfnm@localhost:27017/?authSource=gardenShop", MongoConfig.getConnectionString());
    }

    @Test
    void getSimpleConnectionString() {
        assertEquals("mongodb://localhost:27017/", MongoConfig.getSimpleConnectionString());
    }

    @Test
    void createDatabaseAndUserIfNotExist() {
        assertTrue(MongoConfig.createDatabaseAndUserIfNotExist());
    }
}
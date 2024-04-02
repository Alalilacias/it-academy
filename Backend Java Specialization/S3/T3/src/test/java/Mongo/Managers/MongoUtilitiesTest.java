package Mongo.Managers;

import org.junit.jupiter.api.Test;

class MongoUtilitiesTest {

    @Test
    public void enterGardenShop() {
        assertTrue(MongoUtilities.enterGardenShop("IT-Flowers"));
        assertFalse(MongoUtilities.enterGardenShop("Petunias"));
    }
}
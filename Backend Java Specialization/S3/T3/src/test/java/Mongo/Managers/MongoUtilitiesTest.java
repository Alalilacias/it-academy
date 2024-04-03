package Mongo.Managers;

import Generic.Utilities.ConnectType;
import Generic.Managers.MongoUtilities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MongoUtilitiesTest {

    @Test
    public void enterGardenShop() {
        assertTrue(MongoUtilities.enterGardenShop("IT-Flowers", ConnectType.MONGO));
        assertFalse(MongoUtilities.enterGardenShop("Petunias", ConnectType.MONGO));
    }
}
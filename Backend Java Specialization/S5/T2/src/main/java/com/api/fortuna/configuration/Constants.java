package com.api.fortuna.configuration;

/**
 * TODO Consider if testing is even necessary, test if so.
 */
public class Constants {
    public static class Security{
        public static final String[] AUTHORIZED_REQUESTS = {"/","/auth/**"};
        public static final String[] GUEST_REQUESTS = {"/public/**"};
        public static final String[] USER_REQUESTS = {"/game/**"};
        public static final String[] ADMIN_REQUESTS = {};
    }

    public static class Controllers {
        public static class Players {
            public static final String MAPPING = "/player";
            public static final String ANONYMOUS = "ANONYMOUS";
        }
    }
}

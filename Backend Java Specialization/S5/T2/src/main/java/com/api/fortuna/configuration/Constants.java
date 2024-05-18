package com.api.fortuna.configuration;

/**
 * TODO Consider if testing AND THIS CLAS are even necessary, test if so, delete if not.
 */
public class Constants {
    public static class Security{
        public static final String[] AUTHORIZED_REQUESTS = {"/","player/auth/**"};
        public static final String[] GUEST_REQUESTS = {"/public/**"};
        public static final String[] USER_REQUESTS = {"/game/**", "player/**"};
        public static final String[] ADMIN_REQUESTS = {};
    }
}

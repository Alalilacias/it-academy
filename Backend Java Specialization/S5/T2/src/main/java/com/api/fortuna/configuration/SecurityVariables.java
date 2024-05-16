package com.api.fortuna.configuration;

public class SecurityVariables {
    public static final String[] AUTHORIZED_REQUESTS = {"/","/auth/**"};
    public static final String[] GUEST_REQUESTS = {"/public/**"};
    public static final String[] USER_REQUESTS = {};
    public static final String[] ADMIN_REQUESTS = {};
}

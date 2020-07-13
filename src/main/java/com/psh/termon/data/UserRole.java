package com.psh.termon.data;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    USER,
    MODER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}

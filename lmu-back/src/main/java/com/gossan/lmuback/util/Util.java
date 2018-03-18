package com.gossan.lmuback.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Util {
    public final static PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
}

package com.lcaohoanq.formhandling;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvUtils {

    private static Dotenv env = Dotenv.configure().load();

    public static String get(String key) {
        return env.get(key);
    }

}

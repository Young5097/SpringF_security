package org.hdivsamples.filter;

import java.util.Arrays;
import java.util.List;

public class AllowedCommands {

    private static final List<String> allowed = Arrays.asList("date", "to account");

    public static boolean isAllowed(String inputCommand) {
        return allowed.contains(inputCommand);
    }
}

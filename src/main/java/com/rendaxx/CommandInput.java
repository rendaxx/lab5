package com.rendaxx;

import java.util.Arrays;

public class CommandInput {
    private String name;
    private String[] args;

    public CommandInput(String line) {
        String[] words = line.split("\\s");
        this.name = words[0];
        if (words.length > 1) {
            this.args = Arrays.copyOfRange(words, 1, words.length);
        }
    }

    public String getName() {
        return name;
    }

    public String[] getArgs() {
        return args;
    }
}

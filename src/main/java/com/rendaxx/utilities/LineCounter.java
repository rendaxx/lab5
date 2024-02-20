package com.rendaxx.utilities;

import lombok.Getter;

@Getter
public class LineCounter {
    int linesCount = 0;
    public void increment() {
        linesCount++;
    }
}

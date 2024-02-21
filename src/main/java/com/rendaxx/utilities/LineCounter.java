package com.rendaxx.utilities;

import lombok.Getter;
/**
 * Class for counting lines.
 */
@Getter
public class LineCounter {
    int linesCount = 0;
    public void increment() {
        linesCount++;
    }
}

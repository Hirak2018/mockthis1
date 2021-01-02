package com.mockthis.domock.mock;

import java.io.IOException;
import java.lang.instrument.Instrumentation;

public class Agent {
    public static void premain(String agentArguments,
                               Instrumentation inst) throws IOException {
        inst.addTransformer(new SimpleClassTransformer());
    }
}

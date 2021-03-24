//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ai.yuhan.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;

public class Utils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public Utils() {
    }

    public static String generateNewUUID() {
        String str = UUID.randomUUID().toString().replace("-", "");
        return str;
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

}

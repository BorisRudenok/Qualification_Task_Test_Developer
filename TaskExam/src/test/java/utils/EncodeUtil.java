package utils;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;

public class EncodeUtil {
    public String screenshotToBase64(byte[] screenshot) {
        byte[] encoded = Base64.encodeBase64(screenshot);
        return new String(encoded, StandardCharsets.US_ASCII);
    }
}

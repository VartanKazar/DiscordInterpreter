package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {
    public static String getToken() {
        String text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get("token.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }
}

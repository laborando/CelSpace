package dimensions.common.structure;

import cel.space.Main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class StructureParser {



    public static Structure parse(){

        return null;
    }



    public static void readInternal(String resourcePath){

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(resourcePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            if (inputStream == null) {
                System.err.println("Datei nicht gefunden: " + resourcePath);
                return;
            }

            String line;
            while ((line = reader.readLine()) != null) {
                //Noch Debug!
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

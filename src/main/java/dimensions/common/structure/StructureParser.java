package dimensions.common.structure;

import cel.space.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class StructureParser {


    public static Structure parse(String path, boolean isInternal) {

        BufferedReader reader = null;

        if(isInternal){
            reader = readInternal(path);

        }else{
            //TODO External Reader
        }

        if(reader == null){
            Logger.getGlobal().warning("Did not found source for Structure: " + path + "; isInternal: " + isInternal);
            return null;
        }

        String line;

        try {
            while ((line = reader.readLine()) != null) {

                StaticStructureBuilder.executeInstruction(line);

            }
        }catch (RuntimeException | IOException e){
            e.printStackTrace();
        }


        return StaticStructureBuilder.getStructure();
    }


    public static BufferedReader readInternal(String resourcePath) {

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(resourcePath);

             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            if (inputStream == null) {
                System.err.println("Datei nicht gefunden: " + resourcePath);
                return null;
            }

            return reader;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}

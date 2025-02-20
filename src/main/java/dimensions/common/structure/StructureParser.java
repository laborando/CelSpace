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

        StructureBuilder sb = new StructureBuilder();

        String line;

        try {
            while ((line = reader.readLine()) != null) {

                if(line.equalsIgnoreCase("return()"))
                    break;


                if(!(line.isEmpty() || line.startsWith("#")))
                    sb.executeInstruction(line);

            }
        }catch (RuntimeException | IOException e){
            e.printStackTrace();
        }


        return sb.getStructure();
    }


    public static BufferedReader readInternal(String resourcePath) {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(resourcePath);

        if (inputStream == null) {
            System.err.println("File not found: " + resourcePath);
            return null;
        }

        return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }


}

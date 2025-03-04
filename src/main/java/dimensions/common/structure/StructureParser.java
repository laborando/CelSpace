package dimensions.common.structure;

import cel.space.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class StructureParser {


    public synchronized static Structure parse(String path, boolean isInternal) {

        BufferedReader reader = null;

        if(isInternal){
            reader = readInternal(path);

        }else{
            //TODO External Reader
        }

        if(reader == null){
            Logger.getGlobal().warning("Did not found source for Structure: " + path + "; isInternal: " + isInternal);
            System.err.println("Falling back to empty structure to prevent crash! Please restart your server and contact the dev of CelSpace if this error keeps happening!");

            System.err.println("Was not able to place feature!");

            return new Structure(0,0,0);
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


    private static BufferedReader readInternal(String resourcePath) {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(resourcePath);

        if (inputStream == null) {
            System.err.println("File not found: " + resourcePath);
            return null;
        }

        return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }


}

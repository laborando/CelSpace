package dimensions.common.structure;

import cel.space.Main;
import dimensions.common.structure.object.CustomLoottable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class LoottableParser {


    public synchronized static CustomLoottable parse(String path, boolean isInternal) {

        BufferedReader reader = null;

        if(isInternal){
            reader = readInternal(path);

        }else{
            //TODO External Reader
        }

        if(reader == null){
            Logger.getGlobal().warning("Did not found source for Loottable: " + path + "; isInternal: " + isInternal);
            return null;
        }

        LoottableBuilder sb = new LoottableBuilder();

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


        return sb.getClt();
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

package dimensions.common.structure;

import dimensions.common.structure.object.SimpleBlock;
import org.bukkit.Material;

import java.util.logging.Logger;

public class StaticStructureBuilder {

    private enum InstructionState {
        OUTSIDE,
        STRUCTURE,
        PRE,
        PAST,
        LOOTTABLES
    }

    private static InstructionState crrState = InstructionState.OUTSIDE;
    private static Structure structure = null;

    public static synchronized void executeInstruction(String instruction) {

        instruction = instruction.toLowerCase();


        //GROß Instructions
        if (instruction.startsWith(";")) {

            if (crrState == InstructionState.OUTSIDE) {
                switch (instruction) {
                    case ";structure":
                        crrState = InstructionState.STRUCTURE;
                        break;
                    case ";pre":
                        crrState = InstructionState.PRE;
                        break;
                    case ";final":
                        crrState = InstructionState.PAST;
                        break;
                    case ";loot":
                        crrState = InstructionState.LOOTTABLES;
                        break;

                }
            } else if (instruction.equalsIgnoreCase(";out")) {
                crrState = InstructionState.OUTSIDE;
            } else {
                handleOutside(instruction);
            }

        }

        //Klein instructions
        switch (crrState) {
            case OUTSIDE -> {
                Logger.getGlobal().warning("StaticStructureBuilder: Outside of Instruction State! Instruction: " + instruction);
            }
            case STRUCTURE -> {
                handleStructure(instruction);
            }
            case PRE -> {
                handlePre(instruction);
            }
            case PAST -> {
                handlePast(instruction);
            }
            case LOOTTABLES -> {
                handleLoottables(instruction);
            }
        }

    }

    private static void handleOutside(String instruction) {
        /// Not jet
    }

    /**
     * Gets the generated Structure,
     * ONLY call when the instruction return() is called!
     *
     * @return Previously generated Structure
     */
    public static Structure getStructure() {
        return structure;
    }

    private static void handleStructure(String instruction) {

        String[] parts = instruction.split("=");

        String[] coords = parts[0].split(",");

        structure.addBlock(new SimpleBlock(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2]),false, Material.valueOf(parts[1])));

    }

    private static void handlePast(String instruction) {
        /// Not jet
    }

    private static void handleLoottables(String instruction) {
        /// Not jet
    }

    private static void handlePre(String instruction) {
        if (instruction.equalsIgnoreCase("innit()")) {
            structure = new Structure(0, 0, 0);
        } else if (instruction.startsWith("x=")) {
            int xValue = Integer.parseInt(instruction.substring(2));
            structure.setX(xValue);
        } else if (instruction.startsWith("y=")) {
            int yValue = Integer.parseInt(instruction.substring(2));
            structure.setY(yValue);
        } else if (instruction.startsWith("z=")) {
            int zValue = Integer.parseInt(instruction.substring(2));
            structure.setZ(zValue);
        } else if (instruction.startsWith("rel=false")) {
            structure.setRelative(false);
        } else if (instruction.startsWith("rel=true")) {
            structure.setRelative(true);
        }

        /// Here possible space for future

    }

}

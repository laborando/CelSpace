package dimensions.common.structure;

import dimensions.common.structure.object.SimpleBlock;
import org.bukkit.Material;

import java.util.logging.Logger;

public class StructureBuilder {

    private enum InstructionState {
        OUTSIDE,
        STRUCTURE,
        PRE,
        PAST,
        LOOTTABLES
    }

    private  InstructionState crrState = InstructionState.OUTSIDE;
    private  Structure structure = null;

    public  synchronized void executeInstruction(String instruction) {




        //GROß Instructions
        if (instruction.startsWith(";")) {
            instruction = instruction.toLowerCase();
            if (crrState == InstructionState.OUTSIDE) {
                switch (instruction) {
                    case ";structure":
                        crrState = InstructionState.STRUCTURE;
                        return;
                    case ";pre":
                        crrState = InstructionState.PRE;
                        return;
                    case ";final":
                        crrState = InstructionState.PAST;
                        return;
                    case ";loot":
                        crrState = InstructionState.LOOTTABLES;
                        return;

                }
            } else if (instruction.equalsIgnoreCase(";out")) {
                crrState = InstructionState.OUTSIDE;
                return;
            } else {
                handleOutside(instruction);
                return;
            }

        }

        //Klein instructions
        switch (crrState) {
            case OUTSIDE -> {
                Logger.getGlobal().warning("StructureBuilder: Outside of Instruction State! Instruction: " + instruction);
            }
            case STRUCTURE -> {
                handleStructure(instruction);
                return;
            }
            case PRE -> {
                handlePre(instruction);
                return;
            }
            case PAST -> {
                handlePast(instruction);
                return;
            }
            case LOOTTABLES -> {
                handleLoottables(instruction);
                return;
            }
        }

    }

    private  void handleOutside(String instruction) {
        /// Not jet
    }

    /**
     * Gets the generated Structure,
     * ONLY call when the instruction return() is called!
     *
     * @return Previously generated Structure
     */
    public Structure getStructure() {
        return structure;
    }

    private void handleStructure(String instruction) {

        String[] parts = instruction.split("=");

        String[] coords = parts[0].split(",");

        structure.addBlock(new SimpleBlock(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2]),false, Material.valueOf(parts[1])));

    }

    private void handlePast(String instruction) {
        /// Not jet
    }

    private void handleLoottables(String instruction) {
        /// Not jet
    }

    private void handlePre(String instruction) {

        instruction = instruction.toLowerCase();

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

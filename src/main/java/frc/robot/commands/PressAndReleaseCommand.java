package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PressAndReleaseSubsystem;

public class PressAndReleaseCommand extends Command{

    private PressAndReleaseSubsystem PAndR; 

    public PressAndReleaseCommand(PressAndReleaseSubsystem PAndR){ 
        this.PAndR= PAndR;
        addRequirements(PAndR);
    }


    
}

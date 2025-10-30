package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.MotorSubsystem;
import frc.robot.subsystems.PressAndReleaseSubsystem;

public class PressAndReleaseCommand extends Command{

   private MotorSubsystem motor;
   private RobotContainer Controller;
    

    public PressAndReleaseCommand(MotorSubsystem motor){ 
       this.motor =motor;
    }
    @Override
    public void initialize() {
       while( Controller.configureBindings)
    }



    
}

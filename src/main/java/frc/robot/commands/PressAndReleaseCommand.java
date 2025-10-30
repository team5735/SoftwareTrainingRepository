package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;


public class PressAndReleaseCommand extends Command{

   private MotorSubsystem motor;    

    public PressAndReleaseCommand(MotorSubsystem motor){ 
       this.motor =motor;
    }
    @Override
    public void initialize() {
      motor.startMotorLeftt();
      motor.stopMotorRight();
    }



    @Override
    public void end(boolean interrupted) {
        motor.startMotorRight();
        motor.stopMotorLeft();
    }



    
}

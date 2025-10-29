package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;

public class MotorCommand extends Command {
     private  MotorSubsystem motor ;


    public MotorCommand(MotorSubsystem motor){
      this.motor = motor;
        
      addRequirements(motor);
    }
    
    @Override
    public void initialize() {
        motor.startMotor();

       
    }

    @Override
    public void end(boolean interrupted) {
        motor.endMotor();
    }




}

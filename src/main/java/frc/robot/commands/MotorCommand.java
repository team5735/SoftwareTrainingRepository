package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;



public class MotorCommand extends Command{
private final MotorSubsystem motor;

public MotorCommand(MotorSubsystem mot){
    motor = mot; 
    addRequirements(motor);
}


    @Override
    public void initialize() {
        motor.pull();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        motor.stop();
    }

    
}
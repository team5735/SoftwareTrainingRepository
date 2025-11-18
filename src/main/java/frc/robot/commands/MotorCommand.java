package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;

public class MotorCommand extends Command {
    private MotorSubsystem sub;

    public MotorCommand(MotorSubsystem sub) {
        //correlating MotorCommand motor to the MotorSubsystem motor
        //so the code knows they're indicating the same thing, cool cheese
        this.sub = sub;
        addRequirements(sub);
    }

    //make the motor spin clockwise
    @Override
    public void initialize() {
        sub.spinClockwise();
    }

    @Override
    public void end(boolean interrupted) {
        sub.stopMotor();
    }
}

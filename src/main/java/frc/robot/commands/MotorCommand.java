package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;

public class MotorCommand extends Command {
    private MotorSubsystem motors;

    public MotorCommand(MotorSubsystem motors) {
        // Correlating MotorCommand motors to the MotorSubsystem motors
        // ---> the code knows they're indicating the same thing
        this.motors = motors;
        addRequirements(motors);
    }

    // [button a] ---> stop the right motor, spin the left motor]
    @Override
    public void initialize() {
        motors.leftSpin();
    }

    // let go of [button a] ---> stop the left motor, start the right motor
    @Override
    public void end(boolean interrupted) {
        motors.rightSpin();
    }

}

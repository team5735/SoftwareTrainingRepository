package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.constants.MotorConstants;

public class MotorSubsystem extends SubsystemBase{
    
    private final SparkMax motor = new SparkMax(Constants.MOTOR_ID, MotorType.kBrushless);

    public MotorSubsystem() {}

    public void spinClockwise() {
        motor.setVoltage(MotorConstants.VOLTAGE);
    }

    public void spinCounterwise() {
        motor.setVoltage(-MotorConstants.VOLTAGE);

    }

    public void stopMotor() {
        motor.setVoltage(0);
    }




}
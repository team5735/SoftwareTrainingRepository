package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.constants.MotorConstants;

public class MotorSubsystem extends SubsystemBase{

    private final SparkMax leftMotor = new SparkMax(Constants.SPARK_ID, MotorType.kBrushless);
    private final TalonFX rightMotor = new TalonFX(Constants.TALON_ID);


    public MotorSubsystem() {
        this.rightSpin();
        // so as soon as the motor is connected to the code, it'll start spinning?
        // will the motors NEVER stop???????? unless we stop the code or whatever?
    }

    public void leftSpin() {
        leftMotor.setVoltage(MotorConstants.VOLTAGE);
        rightMotor.setVoltage(0);
    }

    public void rightSpin() {
        rightMotor.setVoltage(MotorConstants.VOLTAGE);
        leftMotor.setVoltage(0);
    }

}
package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;
import frc.robot.RobotContainer;


public class MotorSubsystem extends SubsystemBase{
    private final TalonFX motorRight = new TalonFX(Constants.MOTOR_ID_TALONFX);
    private final SparkMax motorLeft = new SparkMax(Constants.MOTOR_ID_SPARKMAX, MotorType.kBrushless);
    private double triggerVal = new RobotContainer().configureBindings2();

    public MotorSubsystem(){
       
    }

    public void startMotorRight(){
        motorRight.setVoltage(1+triggerVal);
     
    }
    public void stopMotorRight(){
        motorRight.setVoltage(0);
    }
    public void startMotorLeftt(){
        motorLeft.setVoltage(1+triggerVal);
    }
    public void stopMotorLeft(){
        
        motorLeft.setVoltage(0);
    }
    
    
}

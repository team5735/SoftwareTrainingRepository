package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class MotorSubsystem extends SubsystemBase{
    private final TalonFX motorRight = new TalonFX(Constants.MOTOR_ID);
    private final SparkMax motorLeft = new TalonFX(Constants.MOTOR_ID);
    
    
 

    public MotorSubsystem(){}


    public void startMotorRight(){
        motorRight.setVoltage(1);
     


    }


    public void stopMotorRight(){
        motorRight.setVoltage(0);
        
    }


    public void startMotorLeftt(){
    
        motorLeft.setVoltage(1);


    
    }


    public void stopMotorLeft(){
        
        motorLeft.setVoltage(0);
    }
    
    




    
}

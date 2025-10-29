package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class MotorSubsystem extends SubsystemBase{
    private final TalonFX motor = new TalonFX(Constants.OperatorConstants.TalonDeviceIDNum);
 

    public MotorSubsystem(){}


    public void startMotor(){
        motor.setVoltage(1);

    
    }


    public void endMotor(){
        motor.setVoltage(0);
    }





    
    





    
}

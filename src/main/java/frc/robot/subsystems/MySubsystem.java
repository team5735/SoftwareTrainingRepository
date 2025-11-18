package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.constants.MySubsystemConstants;

public class MySubsystem extends SubsystemBase {


    private final SparkMax motor = new SparkMax(Constants.FISH, MotorType.kBrushless);
    private final TalonFX motor2 = new TalonFX(Constants.TALONID);
    public boolean isPressed = false;

    private final SparkMaxConfig con = new SparkMaxConfig();

    public MySubsystem() {
        con.inverted(true);
        motor.configure(con, null, null);
    }

    public void clockSpin(){
        motor.setVoltage(MySubsystemConstants.VOLTS);
        if(isPressed){
            motor2.setVoltage(MySubsystemConstants.VOLTS);
            motor.setVoltage(0);

        }
    }
    
    public void counterSpin(){
        motor.setVoltage(-MySubsystemConstants.VOLTS);
        if(isPressed){
            motor2.setVoltage(-MySubsystemConstants.VOLTS);
            motor.setVoltage(0);

        }
    }

    public void stop(){
        motor.setVoltage(0);
        motor.setVoltage(0);
    }

    
    
    

}

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.constants.MySubsystemConstants;

public class MySubsystem extends SubsystemBase {


    private final SparkMax motor = new SparkMax(Constants.FISH, MotorType.kBrushless);

    private final SparkMaxConfig con = new SparkMaxConfig();

    public MySubsystem() {
        con.inverted(true);
        motor.configure(con, null, null);
    }

    public void clockSpin(){
        motor.setVoltage(MySubsystemConstants.VOLTS);
    }
    
    public void counterSpin(){
        motor.setVoltage(-MySubsystemConstants.VOLTS);
    }

    public void stop(){
        motor.setVoltage(0);
    }


}

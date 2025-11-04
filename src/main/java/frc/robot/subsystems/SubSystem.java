package frc.robot.subsystems;

import java.io.ObjectInputFilter.Config;

import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.constants.SubSystemConstants;

public class SubSystem extends SubsystemBase{
    private final SparkMax sparkMax_pull = new SparkMax(Constants.sixseven, MotorType.kBrushless);
    private final SparkBaseConfig theConfig = new SparkMaxConfig().inverted(true);
    public SubSystem(){
        sparkMax_pull.configure(theConfig , ResetMode.kNoResetSafeParameters , PersistMode.kNoPersistParameters);
    }
public void pull(){
    sparkMax_pull.setVoltage(SubSystemConstants.PULL_VOLTS);
}

public void push(){
    sparkMax_pull.setVoltage(-SubSystemConstants.PUSH_VOLTS);
}
public void stop(){
    sparkMax_pull.setVoltage(0);
}
public Command pullStopCommand(){
    return startEnd(()-> pull(),()->stop());
}
public Command pushStopCommand(){
    return runOnce(()->push());
}
public Command stopCommand(){
    return runOnce(()->stop());
}
}
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar; //If your team uses victors, import them instead
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * This program is used to test out the AS5145B encoder with the WPILIB Encoder class for incremental, quadrature input
 * 
 * 
 * wiring:
 * encoder to digital sidecar:
 * A and B pin on the encoder to SIG pins on the digital IO on the digital sidecar
 * both GND pins to two (or one if you want to solder them together) ground pins(-) on the digital IO on the digital sidecar
 * CSn pin to a ground pin (-) on the digital IO on the digital sidecar
 * 5V pin to a Power pin (PWR) on the digital IO on the digital sidecar
 * 
 * optional wiring:
 * encoder to digital sidecar:
 * one wire to each the Mag DECn pin and the Mag INCn for testing to a signal pin(SIG) on the digital IO on the digital sidecar 
 * see section 4.1 of the manual for pin descriptions 
 */
public class IncrementalEncoderTest extends SimpleRobot {
    
    private final int CONTROLLER_PWM_OUT = 2;
    private final SpeedController speedController = new Jaguar(CONTROLLER_PWM_OUT);
    
    private final int A_QUADRATURE_INPUT = 5;
    private final int B_QUADRATURE_INPUT = 6;
    private final Encoder encoder = new Encoder(A_QUADRATURE_INPUT,B_QUADRATURE_INPUT);
    
    private final int JOYSTICK_DRIVER_STATION_POSITION = 1;
    private final int JOYSTICK_AXES = 2; // My joystick isn't typical, so I need to input the raw axis number
    Joystick joystick = new Joystick(JOYSTICK_DRIVER_STATION_POSITION);


    // these inputs are to test weather the magnetic encoder is in the correct field.
    // These don't need to be used.
    static final int MAGNETIC_FIELD_DECREASING_TEST = 4;
    static final int MAGNETIC_FIELD_INCREASING_TEST = 3;
    DigitalInput magdec = new DigitalInput(MAGNETIC_FIELD_DECREASING_TEST);
    DigitalInput maginc = new DigitalInput(MAGNETIC_FIELD_INCREASING_TEST);
    
    public void operatorControl() {
        //start recording changes in position
        encoder.start();
        
        while(true){
            // the encoder get function in normalized to 1024 ticks
            double rotations = ((double)encoder.get())/1024;
            System.out.println("rotation:" + rotations);
            SmartDashboard.putBoolean("direction", encoder.getDirection());
            SmartDashboard.putBoolean("sStopped", encoder.getStopped());
            SmartDashboard.putNumber("raw", encoder.getRaw());
            SmartDashboard.putNumber("getcount", encoder.get());
            SmartDashboard.putNumber("rotations", rotations);
            SmartDashboard.putBoolean("magdec", magdec.get());
            SmartDashboard.putBoolean("maginc", maginc.get());


            //control a motor with one of its axes, and make it go 10 times slower
            speedController.set(joystick.getRawAxis(JOYSTICK_AXES) * .1);
        }        
    }
}

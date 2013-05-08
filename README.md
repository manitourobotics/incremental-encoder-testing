This sample is used for testing the AS5145B encoder using a magnet on a motor shaft. The code simply dumps out information using class functions if the encoder is working correctly.

# Wiring

 Connect the A and B pin on the encoder to SIG pins on the digital IO on the digital sidecar.  Connect both GND pins to two ground pins(-) on the digital IO on the digital sidecar. Connect the CSn pin to a ground pin (-) on the digital IO on the digital sidecar. Connect the 5V pin to a Power pin (PWR) on the digital IO on the digital sidecar

# Requirements

* CRIO & Sidecar
* SmartDashboard
* Lots and lots of wiring
* A motor and a motorcontroller(may need to adjust the code to use your motor controller and PWM port of choice)
* A calibrated magnet(comes with the encoder) fitted on a shaft

 See the [datasheet](http://www.ams.com/eng/content/download/50206/533867/34237)([source](http://www.ams.com/eng/Products/Magnetic-Position-Sensors/Magnetic-Rotary-Position-Sensors/AS5145B)) for additional guidance.


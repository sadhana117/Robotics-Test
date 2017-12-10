package org.usfirst.frc.team86.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;


public class Drive {
	private Victor leftfrontDrive;
	private Victor leftrearDrive;
	private Victor rightfrontDrive;
	private Victor rightrearDrive;
	private RobotDrive drive;
	private double timeElapsed;
	private double preTime;
	int state = 0;
	
	public Drive(Victor lfd, Victor lrd, Victor rfd, Victor rrd){	
		leftfrontDrive = lfd;
		leftrearDrive = lrd;
		rightfrontDrive = rfd;
		rightrearDrive = rrd;
		drive = new RobotDrive(leftfrontDrive, leftrearDrive, rightfrontDrive, rightrearDrive); 
		
		}
	
	public void init(){
		leftfrontDrive.set(0);
		leftrearDrive.set(0);
		rightfrontDrive.set(0);
		rightrearDrive.set(0);
	}
	
	public void autoUpdate(){
		switch (state) {
		
		case '1' :
			preTime = System.currentTimeMillis();
			state++;
			break;
					
		case '2' :
			timeElapsed = System.currentTimeMillis();
			 if (timeElapsed - preTime > 3000){
					preTime = System.currentTimeMillis();
					state++;
			 }
				 else{
					 drive.set(.5, .5);
				 }
			 break;
			 
		case '3' :
			timeElapsed = System.currentTimeMillis();
			if (timeElapsed - preTime > 2500){
				preTime = System.currentTimeMillis();
			}
			else{
				drive.set(.25, -.25);
			}
			 break;
			
		case '4' :
			timeElapsed = System.currentTimeMillis();
			if (timeElapsed - preTime > 3000){
				preTime = System.currentTimeMillis();	
		}
			else{
				drive.set(-.5, -.5);
				}
			break;
			default:
				drive.set(0, 0);
		}		break;
	}
	
	public void teleopUpdate(){
		double leftY = (IO.leftJoystick.getY());
		double rightY = (IO.rightJoystick.getY());
		drive.tankDrive(leftY,rightY);
	}
	
	
	
	
	
	
}

/*
 * Created on May 9, 2018
 *
 */
package test;

import java.awt.TextArea;
import java.util.Scanner;

import javax.swing.JTextArea;

import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {

    public static final Scanner IN = new Scanner(System.in);
    
    private Singer pattiSmith;
    private Singer bruceSpringsteen;
    private Singer chorusPart;
    
    private void initializeSingingInThreads(JTextArea a,int row) {
        String lyrics1 = "Because the night";
        String lyrics2 = "Belongs to lovers";
        String chorus= "Come on now try and understand\r\n" + 
        		"The way I feel when I'm in your hands\r\n" + 
        		"Take my hand come undercover\r\n" + 
        		"They can't hurt you now\r\n" + 
        		"Can't hurt you now, can't hurt you now.";
        
        boolean stopIt = false;
        Synchronizer synch = new Synchronizer(true, false, false, a, row);

		if (row == 2)
			synch = new Synchronizer(false, true, false, a, row);
		else if (row == 3)
			synch = new Synchronizer(false, false, true, a, row);
        
        Performance firstVoicePerformance = new Performance(lyrics1, 1500);
        Performance secondVoicePerformance = new Performance(lyrics2, 1500);
        Performance chorusPerformance = new Performance(chorus, 3000);
        
        pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
        bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, synch);
		chorusPart = new Singer("Chorus :", Voice.BACKGROUND,chorusPerformance, stopIt, synch);

    }
    
    public void testSingInThreads(JTextArea a) {
    	initializeSingingInThreads(a, 4);

		pattiSmith.start();
		bruceSpringsteen.start();
		chorusPart.start();
        
    }
    public synchronized void startChoosenThread(int row, JTextArea a) {

		if (row == 1) {
			initializeSingingInThreads(a, 1);
			pattiSmith.start();
		} else if (row == 2) {
			initializeSingingInThreads(a, 2);
			bruceSpringsteen.start();
		} else {
			initializeSingingInThreads(a, 3);
			chorusPart.start();
		}
	}
	public synchronized void stopFirstThread() {
		try {
			pattiSmith.setStopIt(true);
		} catch (Exception e) {
		}
	}

	public synchronized void stopSecondThread() {
		try {
			bruceSpringsteen.setStopIt(true);
		} catch (Exception e) {
		}
	}

	public synchronized void stopThirdThread() {
		try {
			chorusPart.setStopIt(true);
		} catch (Exception e) {
		}
	}

	public synchronized void stopSingingThreads() {
		try {
			pattiSmith.setStopIt(true);
			bruceSpringsteen.setStopIt(true);
			chorusPart.setStopIt(true);
		} catch (Exception e) {
		}
	}

   
    
    public synchronized void threadWaitDelay() {
        WaitThread w1 = new WaitThread("t1");
        WaitThread w2 = new WaitThread("t2");
        System.out.println("Two threads...");
        w1.start();
        try {
            wait(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w2.start();
    }
    
}


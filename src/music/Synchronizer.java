package music;

import javax.swing.JTextArea;

public class Synchronizer {

	private boolean firstVoiceFlag;
	private boolean secondVoiceFlag;
	private boolean chorusFlag;
	private JTextArea ta;
	private int mode;

	public Synchronizer(boolean firstVoiceFlag, boolean secondVoiceFlag, boolean chorusFlag, JTextArea ta, int mode) {
		super();
		this.firstVoiceFlag = firstVoiceFlag;
		this.secondVoiceFlag = secondVoiceFlag;
		this.chorusFlag= chorusFlag;
		this.ta = ta;
		this.mode = mode;
	}

	public synchronized void singFirstVoice(String lyrics, int delay) {
		while (!firstVoiceFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	public synchronized void singSecondVoice(String lyrics, int delay) {
		while (!secondVoiceFlag || firstVoiceFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	public synchronized void singChorus(String lyrics, int delay) {
		while (!chorusFlag || firstVoiceFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	private void sing(String lyrics, int delay) {
		// System.out.println(lyrics);
		ta.append(lyrics + "\n");

		try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (mode == 4) {
			if (firstVoiceFlag) {
				firstVoiceFlag = false;
				secondVoiceFlag = true;
				chorusFlag = false;
			} else {
				if (secondVoiceFlag) {
					firstVoiceFlag = false;
					secondVoiceFlag = false;
					chorusFlag = true;
				} else if (chorusFlag) {
					firstVoiceFlag = true;
					secondVoiceFlag = false;
					chorusFlag = false;
				}
			}
			notifyAll();
		} else {
			if (mode == 1) {
				firstVoiceFlag = true;
				secondVoiceFlag = false;
				chorusFlag = false;
				notifyAll();
			} else if (mode == 2) {
				firstVoiceFlag = false;
				secondVoiceFlag = true;
				chorusFlag = false;
				notifyAll();
			} else if (mode == 3) {
				firstVoiceFlag = false;
				secondVoiceFlag = false;
				chorusFlag = true;
				notifyAll();
			}
		}

	}
}

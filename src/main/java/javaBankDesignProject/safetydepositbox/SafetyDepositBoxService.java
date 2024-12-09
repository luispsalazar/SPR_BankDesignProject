package javaBankDesignProject.safetydepositbox;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class SafetyDepositBoxService {

    private static SafetyDepositBoxService instance;
    private List<SafetyDepositBox> safetyDepositBoxes;
    private static int numberOfSafetyDepositBox;

    private SafetyDepositBoxService() {
	safetyDepositBoxes = new LinkedList<>();
    }

    public static SafetyDepositBoxService getInstance() {
	if (instance == null) {
	    synchronized (SafetyDepositBoxService.class) {
		if (instance == null) {
		    instance = new SafetyDepositBoxService();
		}
	    }
	}
	return instance;
    }

    public static void setNumberOfSafetyDepositBoxes(int numberOfSafetyDepositBox) {
	SafetyDepositBoxService.numberOfSafetyDepositBox = numberOfSafetyDepositBox;
    }

    public static int getNumberOfSafetyDepositBoxes() {
	return numberOfSafetyDepositBox;
    }

    public SafetyDepositBox allocateSafetyDepositBox() {
	Optional<SafetyDepositBox> returnedBox1 = getRelesedSafetyDepositBox();
	SafetyDepositBox box = null;

	if (returnedBox1.isPresent()) {
	    return box = returnedBox1.get();
	} else {
	    if (getNumberOfAvailableSafetyDepositBoxes() > 0) {
		SafetyDepositBox box2 = new SmallSafetyDepositBox();
		safetyDepositBoxes.add(box2);
		return box = box2;
	    } else {
		while (getNumberOfAvailableSafetyDepositBoxes() <= 0) {
		    try {
			wait();
			Optional<SafetyDepositBox> returnedBox3 = getRelesedSafetyDepositBox();
			return box = returnedBox3.get();
		    } catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		    }
		}
	    }
	}
	return box;
    }

    public void releaseSafetyDepositBox(SafetyDepositBox safetyDepositBox) {
	safetyDepositBox.setAlloted(false);
	notify();
    }

    public int getNumberOfAvailableSafetyDepositBoxes() {
	return numberOfSafetyDepositBox - safetyDepositBoxes.size();
    }

    public synchronized Optional<SafetyDepositBox> getRelesedSafetyDepositBox() {
	for (SafetyDepositBox box : safetyDepositBoxes) {
	    if (!box.isAlloted()) {
		return Optional.of(box);
	    }
	}
	return Optional.empty();
    }

    public List<SafetyDepositBox> getSafetyDepositBoxes() {
	return safetyDepositBoxes;
    }
}
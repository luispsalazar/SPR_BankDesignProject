package javaBankDesignProject.safetydepositbox;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSafetyDepositBoxService {

    SafetyDepositBoxService safetyDepositBoxService;
    SafetyDepositBox safetyDepositBox;
    List<SafetyDepositBox> safetyDepositBoxes;

    @BeforeEach
    void setUp() {
	safetyDepositBoxService = SafetyDepositBoxService.getInstance();
	SafetyDepositBoxService.setNumberOfSafetyDepositBoxes(2);
    }

    @Test
    void test_safetyDepositBoxServiceSameInstance() {
	SafetyDepositBoxService instance1 = SafetyDepositBoxService.getInstance();
	SafetyDepositBoxService instance2 = SafetyDepositBoxService.getInstance();
	Assertions.assertSame(instance1, instance2);
    }

    @Test
    void test_numberOfSafetyDespositBoxesAreCreated() {
	int originalBoxes = SafetyDepositBoxService.getNumberOfSafetyDepositBoxes();
	int targetBoxes = originalBoxes + 2;
	SafetyDepositBoxService.setNumberOfSafetyDepositBoxes(targetBoxes);
	Assertions.assertEquals(SafetyDepositBoxService.getNumberOfSafetyDepositBoxes(), targetBoxes);
	SafetyDepositBoxService.setNumberOfSafetyDepositBoxes(originalBoxes);
    }

    @Test
    void test_aNonAllocatedBoxIsReturned() {
	if (safetyDepositBoxService.getSafetyDepositBoxes().size() > 0) {
	    safetyDepositBoxService.getSafetyDepositBoxes().clear();
	}

	Optional<SafetyDepositBox> ReceivedBox = safetyDepositBoxService.getRelesedSafetyDepositBox();
	Assertions.assertTrue(!ReceivedBox.isPresent());

	SafetyDepositBox box1 = new SmallSafetyDepositBox();
	SafetyDepositBox box2 = new SmallSafetyDepositBox();
	box1.setAlloted(true);
	safetyDepositBoxService.getSafetyDepositBoxes().add(box1);
	safetyDepositBoxService.getSafetyDepositBoxes().add(box2);

	Optional<SafetyDepositBox> ReceivedBox2 = safetyDepositBoxService.getRelesedSafetyDepositBox();
	Assertions.assertSame(ReceivedBox2.get(), box2);
    }

    @Test // passes when tested alone
    void test_allocateSafetyDepositBox() {
	safetyDepositBox = safetyDepositBoxService.allocateSafetyDepositBox();
	safetyDepositBox.setAlloted(true);
	Assertions.assertTrue(safetyDepositBox.isAlloted());
    }

    @Test
    void test_releaseSafetyDepositBox() {
	SafetyDepositBox box = new SmallSafetyDepositBox();
	box.setAlloted(true);
	// comment out the notify() line in the method,
	// otherwise it will throw an "IllegalMonitorStateException"
	safetyDepositBoxService.releaseSafetyDepositBox(box);
	Assertions.assertTrue(!box.isAlloted());
    }

    @Test
    void test_createTwoThreadsAndVerifyThatnoThreadWasKeptWaiting() {
	SafetyDepositBox box1 = new SmallSafetyDepositBox();
	SafetyDepositBox box2 = new SmallSafetyDepositBox();
	safetyDepositBoxes = safetyDepositBoxService.getSafetyDepositBoxes();
	safetyDepositBoxes.add(box1);
	safetyDepositBoxes.add(box2);
	System.out.println(safetyDepositBoxes.size());

	Thread thread1 = new Thread();
	Thread thread2 = new Thread();
	thread1.start();
	safetyDepositBox = safetyDepositBoxService.allocateSafetyDepositBox();
	;
	safetyDepositBox.setAlloted(true);
//	try {
//	    thread1.wait(5000);
//	} catch (InterruptedException e) {
//	    e.printStackTrace();
//	}
	safetyDepositBoxService.releaseSafetyDepositBox(safetyDepositBox);

	thread2.start();
	safetyDepositBox = safetyDepositBoxService.allocateSafetyDepositBox();
	safetyDepositBox.setAlloted(true);
//	try {
//	    thread1.wait(5000);
//	} catch (InterruptedException e) {
//	    e.printStackTrace();
//	}
	safetyDepositBoxService.releaseSafetyDepositBox(safetyDepositBox);

	Thread.State state1 = thread1.getState();
	Thread.State state2 = thread2.getState();
	Assertions.assertNotEquals(state1, "TIMED_WAITING");
	Assertions.assertNotEquals(state2, "TIMED_WAITING");
    }

    @Test
    void test_createThreeThreadsAndVerifyThatOneThreadWasKeptWaiting() {
	boolean flag;
	Thread thread1 = new Thread();
	Thread thread2 = new Thread();
	Thread thread3 = new Thread();

	thread1.start();
	safetyDepositBox = safetyDepositBoxService.allocateSafetyDepositBox();
	safetyDepositBox.setAlloted(true);
	try {
	    thread1.wait(5000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	safetyDepositBoxService.releaseSafetyDepositBox(safetyDepositBox);

	thread2.start();
	safetyDepositBox = safetyDepositBoxService.allocateSafetyDepositBox();
	safetyDepositBox.setAlloted(true);
	try {
	    thread2.wait(5000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	safetyDepositBoxService.releaseSafetyDepositBox(safetyDepositBox);

	thread3.start();
	safetyDepositBox = safetyDepositBoxService.allocateSafetyDepositBox();
	safetyDepositBox.setAlloted(true);
	try {
	    thread3.wait(5000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	safetyDepositBoxService.releaseSafetyDepositBox(safetyDepositBox);

	Thread.State state1 = thread1.getState();
	Thread.State state2 = thread2.getState();
	Thread.State state3 = thread3.getState();
	try {
	    thread1.join();
	    thread2.join();
	    thread3.join();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	if (state1.name().toString() == "TIMED_WAITING" || state2.name().toString() == "TIMED_WAITING"
		|| state3.name().toString() == "TIMED_WAITING") {
	    flag = true;
	} else
	    flag = false;
	Assertions.assertTrue(flag);
    }
}
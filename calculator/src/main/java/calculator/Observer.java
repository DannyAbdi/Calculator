package calculator;

/**
 * Functional interface that notifies the observers.
 * 
 * @author danny
 *
 */
@FunctionalInterface
public interface Observer {
	public void notifyObservers();
}

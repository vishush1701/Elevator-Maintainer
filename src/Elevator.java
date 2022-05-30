import java.util.Deque;

public class Elevator {
	private int totalFloor;
	private int currentFloor;
	private ElevatorStatus status;
	private Deque<Integer> requests;
	
	public Elevator(int totalFloor, int currentFloor, ElevatorStatus status, Deque<Integer> requests, int priority) {
		this.totalFloor = totalFloor;
		this.currentFloor = currentFloor;
		this.status = status;
		this.requests = requests;
		this.priority = priority;
	}
	private int priority;
	
	public int getTotalFloor() {
		return totalFloor;
	}
	public void setTotalFloor(int totalFlorr) {
		this.totalFloor = totalFlorr;
	}
	public int getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	public ElevatorStatus getStatus() {
		return status;
	}
	public void setStatus(ElevatorStatus status) {
		this.status = status;
	}
	public synchronized Deque<Integer> getRequests() {
		return requests;
	}
	public void setRequests(Deque<Integer> requests) {
		this.requests = requests;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
}

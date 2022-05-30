
public enum ElevatorStatus {
	
	move(1),idle(0);
	private ElevatorStatus(int i) {
		this.i = i;
	}
	private int i;
}

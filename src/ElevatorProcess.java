public class ElevatorProcess {
	private Elevator elevator;
	public ElevatorProcess(Elevator elevator) {
		this.elevator = elevator;
	}

	public Elevator getElevator() {
		return elevator;
	}

	public void setElevator(Elevator elevator) {
		this.elevator = elevator;
	}

	public void processRequest() {
		if(elevator.getStatus() == ElevatorStatus.idle) {
			if(elevator.getPriority() == 0) {
				elevator.setStatus(ElevatorStatus.move);
				move(elevator.getRequests().poll());
				elevator.setStatus(ElevatorStatus.idle);
			}
			else {
				int requestedFloor1 = elevator.getRequests().poll();
				int requestedFloor2 = elevator.getRequests().poll();
				
				//case when both buttons are pressed at a time
				if(requestedFloor1 == requestedFloor2) {
					elevator.setStatus(ElevatorStatus.move);
					move(elevator.getRequests().poll());
					elevator.setStatus(ElevatorStatus.idle);
				}
				//case when both buttons are pressed but at different floors
				else {
					elevator.setStatus(ElevatorStatus.move);
					move(getNearestFloor(requestedFloor1, requestedFloor2));
					elevator.getRequests().addFirst(requestedFloor1+requestedFloor2-getNearestFloor(requestedFloor1,requestedFloor2));
					elevator.setStatus(ElevatorStatus.idle);
				}
				elevator.setPriority(0);
			}
		}
	}

	private int getNearestFloor(int requestedFloor1, int requestedFloor2) {
		if(requestedFloor1 == elevator.getCurrentFloor() || requestedFloor2 == elevator.getCurrentFloor())return elevator.getCurrentFloor();
		int nearestFloor = elevator.getCurrentFloor();
		if(Math.round(requestedFloor2-elevator.getCurrentFloor()) < Math.round(requestedFloor1-elevator.getCurrentFloor())) {
			nearestFloor = requestedFloor2;
		}
		else {
			nearestFloor = requestedFloor1;
		}
		return nearestFloor;
	}

	private void move(int requestedFloor) {
		
		System.out.println("On Floor:"+elevator.getCurrentFloor());
		if(requestedFloor == elevator.getCurrentFloor()) {
			System.out.println("On same floor, Doors open ");
		}
		if(requestedFloor < elevator.getCurrentFloor()) {
			System.out.println("moving down to "+requestedFloor);
		}
		else {
			System.out.println("moving up to "+requestedFloor);
		}
	}
}

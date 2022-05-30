import java.util.LinkedList;

public class TestElevator {

	public static void main(String[] args) throws Exception{
		Elevator elevator = new Elevator(10,5,ElevatorStatus.idle,new LinkedList<Integer>(),0);
		ElevatorProcess elevatorProcess = new ElevatorProcess(elevator);
		
		//continously monitor requests and process it
		Thread monitorRequest = new Thread(()->{
			while(true) {
				if(elevatorProcess.getElevator().getStatus() == ElevatorStatus.idle && elevatorProcess.getElevator().getRequests().isEmpty() != true) {
					elevatorProcess.processRequest();
				}
				
			}
		});
		
		
		
		//create Requests
//		elevatorProcess.getElevator().getRequests().addLast(10);
//		elevatorProcess.getElevator().getRequests().addLast(1);
//		
//		//to mark that two buttons are pressed at a time
//		elevatorProcess.getElevator().setPriority(1);
		
		elevatorProcess.getElevator().getRequests().addLast(5);
		elevatorProcess.getElevator().getRequests().addLast(0);
		elevatorProcess.getElevator().setPriority(1);
		
		monitorRequest.start();
		monitorRequest.join();
		
		
	}

}

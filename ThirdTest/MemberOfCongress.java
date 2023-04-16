class Citizen {
	public static void speech() {
		System.out.println("off the cuff ");
	}
	public void handshake() {
		System.out.println("shake on it ");
	}
}

class Candidate extends Citizen {
	public static void speech() {
		System.out.println("make promise ");
	}
	public void handshake() {
		System.out.println("many times ");
	}
}

public class MemberOfCongress extends Candidate {
	public static void speech() {
		System.out.println("canned ");
	}
	public void handshake() {
		System.out.println("sincere ");
	}

	public static void main(String[] args) {
		Citizen chu = new Candidate();
		chu.handshake();
		chu.speech();

		Citizen gopal = new MemberOfCongress();
		gopal.handshake();
		gopal.speech();
		
		MemberOfCongress jones = new MemberOfCongress();
		jones.handshake();
		jones.speech();

		Candidate smith = jones;
		smith.handshake();
		smith.speech();
	}
}

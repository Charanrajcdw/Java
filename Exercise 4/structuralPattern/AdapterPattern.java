package structuralPattern;

abstract class NanoSim{
	abstract public void nanoWork();
}

abstract class NanoSimSlot{
	abstract public void acceptNano(NanoSim nano);
}

abstract class StandardSim{
	abstract public void standardWork();
}

abstract class StandardSimSlot{
	abstract public void acceptStandard(StandardSim standard);
}

class Jio extends NanoSim{
	@Override
	public void nanoWork() {
		System.out.println("jio sim works...");
	}
}

class JioSlot extends NanoSimSlot{
	@Override
	public void acceptNano(NanoSim nano) {
		nano.nanoWork();
	}
}

class BSNL extends StandardSim{
	@Override
	public void standardWork() {
		System.out.println("bsnl sim works...");
	}
}

class BSNLSlot extends StandardSimSlot{
	@Override
	public void acceptStandard(StandardSim standard) {
		standard.standardWork();
	}
}

class SimAdapter extends StandardSim{
	NanoSim sim;
	public SimAdapter(NanoSim sim) {
		this.sim=sim;
	}
	@Override
	public void standardWork() {
		sim.nanoWork();
	}
}

public class AdapterPattern {
	public static void main(String[] args) {
		Jio jio=new Jio();
		BSNLSlot bsnlSlot=new BSNLSlot();
		SimAdapter adapter=new SimAdapter(jio);
		bsnlSlot.acceptStandard(adapter);
	}
}

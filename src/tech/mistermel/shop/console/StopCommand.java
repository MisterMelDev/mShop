package tech.mistermel.shop.console;

public class StopCommand implements Command {

	@Override
	public void execute(String[] args) {
		System.exit(0);
	}
	
}

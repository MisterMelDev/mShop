package tech.mistermel.shop.console;

import tech.mistermel.shop.Webshop;

public class ReloadCommand implements Command {

	private Webshop instance;
	
	public ReloadCommand(Webshop instance) {
		this.instance = instance;
	}
	
	@Override
	public void execute(String[] args) {
		instance.reload();
		System.out.println("System reloaded.");
	}
	
}

package tech.mistermel.shop.console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleManager extends Thread {

	private Map<String, Command> commands = new HashMap<>();
	
	public ConsoleManager() {
		super("Console");
	}
	
	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		String line;
		System.out.print("> ");
		while((line = scan.nextLine()) != null) {
			String[] args = line.split(" ");
			Command cmd = commands.get(args[0]);
			if(cmd != null) {
				cmd.execute(Arrays.copyOfRange(args, 1, args.length));
				System.out.print("> ");
				continue;
			}
			System.out.println("Command not found");
			System.out.print("> ");
		}
		scan.close();
	}
	
	public void registerCommand(String label, Command cmd) {
		commands.put(label, cmd);
	}
	
}

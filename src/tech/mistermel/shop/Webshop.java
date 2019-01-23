package tech.mistermel.shop;

import java.io.IOException;

import fi.iki.elonen.NanoHTTPD;
import tech.mistermel.shop.console.ConsoleManager;
import tech.mistermel.shop.console.ReloadCommand;
import tech.mistermel.shop.console.StopCommand;
import tech.mistermel.shop.order.OrderManager;
import tech.mistermel.shop.product.ProductManager;
import tech.mistermel.shop.user.UserManager;
import tech.mistermel.shop.util.SQLManager;
import tech.mistermel.shop.web.WebRouter;

public class Webshop extends NanoHTTPD {

	private WebRouter router;
	
	private SQLManager sql;
	private OrderManager orders;
	private ProductManager products;
	private UserManager users;
	private ConsoleManager console;
	
	public Webshop() {
		super(80);
		
		this.console = new ConsoleManager();
		this.orders = new OrderManager();
		this.products = new ProductManager(this);
		this.users = new UserManager();
		this.sql = new SQLManager("127.0.0.1", "root", "root", "shop", 3306);
		
		this.router = new WebRouter(this);
		
		this.reload();
		console.registerCommand("stop", new StopCommand());
		console.registerCommand("reload", new ReloadCommand(this));
		console.start();
		
		try {
			this.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void reload() {
		products.load();
		router.reload();
	}
	
	@Override
	public Response serve(IHTTPSession session) {
		return router.route(session);
	}
	
	public OrderManager getOrderManager() { 
		return orders;
	}
	
	public ProductManager getProductManager() {
		return products;
	}
	
	public UserManager getUserManager() {
		return users;
	}
	
	public SQLManager getSQLManager() {
		return sql;
	}

}

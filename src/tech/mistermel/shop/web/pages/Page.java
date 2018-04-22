package tech.mistermel.shop.web.pages;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import fi.iki.elonen.NanoHTTPD.Response;
import tech.mistermel.shop.Webshop;
import tech.mistermel.shop.web.WebRouter;

public abstract class Page {

	private Webshop instance;
	private WebRouter router;
	
	public Page(Webshop instance, WebRouter router) {
		this.instance = instance;
		this.router = router;
	}
	
	protected Webshop getInstance() {
		return instance;
	}
	
	protected WebRouter getRouter() { 
		return router;
	}
	
	public abstract Response serve(IHTTPSession session);
	
	public void reload() {}
	
}

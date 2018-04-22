package tech.mistermel.shop.web.pages;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import fi.iki.elonen.NanoHTTPD.Response;
import tech.mistermel.shop.Webshop;
import tech.mistermel.shop.web.WebRouter;

public class HomePage extends Page {


	public HomePage(WebRouter router, Webshop instance) {
		super(instance, router);
	}

	@Override
	public Response serve(IHTTPSession session) {
		return Webshop.newFixedLengthResponse(this.getRouter().getFile("home"));
	}

}

package tech.mistermel.shop.web.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import fi.iki.elonen.NanoHTTPD.Response;
import tech.mistermel.shop.Webshop;
import tech.mistermel.shop.web.WebRouter;

public class AssetsPage extends Page {
	
	public AssetsPage(WebRouter router, Webshop instance) {
		super(instance, router);
	}

	@Override
	public Response serve(IHTTPSession session) {
		String identifier = session.getUri().replace("/assets/", "");
		if(identifier.equals("main.css")) {
			return Webshop.newFixedLengthResponse(Response.Status.OK, "text/css", this.getRouter().getFile("css"));
		}
		if(identifier.equals("test-image.png")) {
			File file = new File("pictures/test-picture.png");
			FileInputStream is = null;
			try {
				is = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return Webshop.newFixedLengthResponse(Response.Status.OK, "image/png", is, file.length()); 
		}
		return this.getRouter().getErrorPage(404);
	}

}

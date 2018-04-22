package tech.mistermel.shop.web;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import fi.iki.elonen.NanoHTTPD.Response;
import tech.mistermel.shop.Webshop;
import tech.mistermel.shop.util.WebUtils;
import tech.mistermel.shop.web.pages.AssetsPage;
import tech.mistermel.shop.web.pages.HomePage;
import tech.mistermel.shop.web.pages.Page;
import tech.mistermel.shop.web.pages.ProductPage;

public class WebRouter {

	private Map<String, String> files = new HashMap<String, String>();
	private Map<String, Page> pages = new HashMap<String, Page>();
	
	public WebRouter(Webshop instance) {
		files.put("home", WebUtils.readFile("index.html"));
		files.put("product", WebUtils.readFile("product.html"));
		files.put("css", WebUtils.readFile("main.css"));
		files.put("404", "404 Not found");
		
		pages.put("\\/artikel\\/.+", new ProductPage(this, instance));
		pages.put("\\/assets\\/.+", new AssetsPage(this, instance));
		pages.put("/", new HomePage(this, instance));
	}

	public Response route(IHTTPSession session) {
		for(String key : pages.keySet()) {
			if(Pattern.matches(key, session.getUri())) {
				return pages.get(key).serve(session);
			}
			key.startsWith("test");
		}
		return this.getErrorPage(404);
	}
	
	public void reload() {
		files.clear();
		files.put("home", WebUtils.readFile("index.html"));
		files.put("product", WebUtils.readFile("product.html"));
		files.put("css", WebUtils.readFile("main.css"));
		files.put("404", "404 Not found");
		
		for(Page p : pages.values()) {
			p.reload();
		}
	}
	
	public String getFile(String name) {
		return files.get(name);
	}
	
	public Response getErrorPage(int code) {
		switch(code) {
			case 404: return Webshop.newFixedLengthResponse(Response.Status.NOT_FOUND, "text/html", files.get("404"));
		}
		return null;
	}
	
}

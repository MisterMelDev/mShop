package tech.mistermel.shop.web.pages;

import java.util.HashMap;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import fi.iki.elonen.NanoHTTPD.Response;
import tech.mistermel.shop.Webshop;
import tech.mistermel.shop.product.Product;
import tech.mistermel.shop.util.WebUtils;
import tech.mistermel.shop.web.WebRouter;

public class ProductPage extends Page {

	private Map<Product, String> pages;
	
	public ProductPage(WebRouter router, Webshop instance) {
		super(instance, router);
		
		this.pages = new HashMap<Product, String>();
		this.reload();
	}
	
	@Override
	public void reload() {
		pages.clear();
		String page = this.getRouter().getFile("product");
		for(Product p : this.getInstance().getProductManager().getProducts()) {
			pages.put(p, constructPage(page, p));
		}
	}
	
	private String constructPage(String page, Product p) {
		String result = WebUtils.fillPlaceholders(page, "PRODUCT_NAME", p.getName(), "PRODUCT_PRICE", Double.toString(p.getPrice()), "PRODUCT_STOCK_COLOR", p.getStock() > 0 ? "green" : "red", "PRODUCT_STOCK", p.getFormattedStock(), "PRODUCT_DESC", p.getDescription());
		return result;
	}

	@Override
	public Response serve(IHTTPSession session) {
		String identifier = session.getUri().replace("/artikel/", "");
		Product product = this.getInstance().getProductManager().getProduct(identifier);
		if(identifier.isEmpty() || product == null) return this.getRouter().getErrorPage(404);
		return Webshop.newFixedLengthResponse(pages.get(product));
	}

}

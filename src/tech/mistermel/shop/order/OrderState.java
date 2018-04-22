package tech.mistermel.shop.order;

public enum OrderState {

	AWAITING_PAYMENT("Bestelling geplaatst", "Niet betaald"),
	PROCESSING("Bestelling betaald", "Betaald"),
	SENT("Bestelling verstuurd", "Verstuurd"),
	COMPLETED("Bestelling geleverd", "Geleverd");

	private String friendlyName, panelName;
	
	private OrderState(String friendlyName, String panelName) {
		this.friendlyName = friendlyName;
		this.panelName = panelName;
	}
	
	public String getFriendlyName() { 
		return friendlyName;
	}
	
	public String getPanelName() {
		return panelName;
	}
	
}

package constants;

public enum CommonApi {
	
	GET_FAVICON("/favicon.ico"),
	STOP_SERVICE("/stop/service");
	
	private String path;

	public String getPath() {
		return path;
	}

	private CommonApi(String path) {
		this.path = path;
	}
	
	
}

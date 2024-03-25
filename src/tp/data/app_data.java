package tp.data;

public enum app_data {
	APPNAME("To-Do-List"),	// PG Name
	APPICON(".jpg"),
	FONT("굴림");		// PG Icon

	private String value;
	
	app_data(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}

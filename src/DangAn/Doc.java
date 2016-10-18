package DangAn;

import java.sql.Timestamp;

public class Doc {
	private String ID;
	private String filename;
	private String creator;
	private String description;
	private Timestamp timestamp;

	public Doc(String iD, String creator2, Timestamp timestamp, String description2, String filename2) {
		// TODO Auto-generated constructor stub
		ID = iD;
		creator = creator2;
		description = description2;
		filename = filename2;
		this.timestamp = timestamp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getID() {
		return ID;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

package Modelos;

public class ModeloPerson {
	private Integer id;
	private String first_name;
	private String last_name;
	private String identity_document;
	private String grade;
	private String section;
	private String states;
	private String person_type;
	private String cellphone;

	public ModeloPerson() {
	}
	
	public ModeloPerson(Integer id, String first_name, String last_name, String identity_document, String grade, String section, String states, String person_type, String cellphone) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.identity_document = identity_document;
		this.grade = grade;
		this.section = section;
		this.states = states;
		this.person_type = person_type;
		this.cellphone = cellphone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getIdentity_document() {
		return identity_document;
	}

	public void setIdentity_document(String identity_document) {
		this.identity_document = identity_document;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public String getPerson_type() {
		return person_type;
	}

	public void setPerson_type(String person_type) {
		this.person_type = person_type;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	@Override
	public String toString() {
        String data = "[id: " + this.id;
        data += ", first_name: " + this.first_name;
        data += ", last_name: " + this.last_name;
        data += ", identity_document: " + this.identity_document;
        data += ", grade: " + this.grade;
        data += ", section: " + this.section;
        data += ", states: " + this.states;
        data += ", person_type: " + this.person_type;
        data += ", cellphone: " + this.cellphone;
        return data;
    }

	public void setNames(String string) {
		// TODO Auto-generated method stub
		
	}

}
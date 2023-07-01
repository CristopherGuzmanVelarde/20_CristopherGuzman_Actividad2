package Modelos;

public class ModeloLibrarian {
    private Integer id;
    private String identity_document;
    private String first_name;
    private String last_name;
    private String cellphone_librarian;
    private String states;

    public ModeloLibrarian() {
    }

    public ModeloLibrarian(Integer id, String identity_document, String first_name, String last_name, String cellphone_librarian, String states) {
        super();
        this.id = id;
        this.identity_document = identity_document;
        this.first_name = first_name;
        this.last_name = last_name;
        this.cellphone_librarian = cellphone_librarian;
        this.states = states;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentity_document() {
        return identity_document;
    }

    public void setIdentity_document(String identity_document) {
        this.identity_document = identity_document;
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

    public String getCellphone_librarian() {
        return cellphone_librarian;
    }

    public void setCellphone_librarian(String cellphone_librarian) {
        this.cellphone_librarian = cellphone_librarian;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    @Override
    public String toString() {
        String data = "[id: " + this.id;
        data += ", identity_document: " + this.identity_document;
        data += ", first_name: " + this.first_name;
        data += ", last_name: " + this.last_name;
        data += ", cellphone_librarian: " + this.cellphone_librarian;
        data += ", states: " + this.states;
        return data;
    }
}

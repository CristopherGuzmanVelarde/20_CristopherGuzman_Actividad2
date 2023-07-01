package Modelos;

public class ModeloBook {
    private Integer id;
    private String names;
    private String author;
    private String descriptions;
    private Integer quantity;
    private String states;

    public ModeloBook() {
    }

    public ModeloBook(Integer id, String names, String author, String descriptions, Integer quantity, String states) {
        this.id = id;
        this.names = names;
        this.author = author;
        this.descriptions = descriptions;
        this.quantity = quantity;
        this.states = states;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        data += ", names: " + this.names;
        data += ", author: " + this.author;
        data += ", descriptions: " + this.descriptions;
        data += ", quantity: " + this.quantity;
        data += ", states: " + this.states;
        return data;
    }

	public Object getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getYear() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}

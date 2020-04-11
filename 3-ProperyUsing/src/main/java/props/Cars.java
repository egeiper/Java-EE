package props;

public class Cars {
	
	public Cars() {
		System.out.println("Cars Call");
	}
	
	public Cars(String data) {
		
	}
	
	private String title;
	private int price;
	private String img;
	private int id;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	

}

package product;

public class Product
{
	private int proId;
	private String proName;
	private double proPrice;
	public Product(int proId, String proName, double proPrice) {
		this.proId = proId;
		this.proName = proName;
		this.proPrice = proPrice;
	}
	@Override
	public String toString() {
		return "Product [proId=" + proId + ", proName=" + proName + ", proPrice=" + proPrice + "]";
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public double getProPrice() {
		return proPrice;
	}
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	public Product()
	{
		
	}
}

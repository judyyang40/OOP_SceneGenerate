public class PointLight{
	Point p;
	RGB intensity;
	public PointLight(){
	}
	public PointLight(float x, float y, float z, float r, float g, float b){
		this.p = new Point(x, y, z);
		this.intensity = new RGB(r, g, b);
	}
	public PointLight(PointLight other){
		this.p = new Point(other.p);
		this.intensity = new RGB(other.intensity);
	}
}
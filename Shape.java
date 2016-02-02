public abstract class Shape{
	public RGB rd;
	public abstract Intersection Intersect(Ray ray);
	public abstract boolean IntersectP(Ray ray);
	public RGB getMaterial(){
		return new RGB(rd);
	}
}
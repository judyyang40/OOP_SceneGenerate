public class Intersection{
	public Point p;
	public Vector n;
	public Shape s;
	public Intersection(){
	}
	public Intersection(Intersection other){
		this.p = new Point(other.p);
		this.n = new Vector(other.n);
		if(other.s instanceof Sphere)
			this.s = new Sphere((Sphere) other.s);
		else
			this.s = new Triangle((Triangle) other.s);
	}
	public Intersection(Point p, Vector n, Sphere s){
		this.p = new Point(p);
		this.n = new Vector(n);
		this.s = new Sphere(s);
	}
	public Intersection(Point p, Vector n, Triangle s){
		this.p = new Point(p);
		this.n = new Vector(n);
		this.s = new Triangle(s);
	}
	public boolean equals(Intersection other){
		if(this.p.equals(other.p)&&this.n.equals(other.n)&&this.s.equals(other.s))
			return true;
		else
			return false;
	}
	public RGB Shade(PointLight[] light, int count){
		RGB shade = new RGB(0, 0, 0);
		for(int i=0;i<count;i++){
			Vector l = new Vector();
			l = light[i].p.sub(this.p);
			//l = this.p.sub(light[i].p);
			l = l.normalize();
			float c = this.n.dot(l);
			if(c>0){
				RGB temp = new RGB();
				temp = this.s.getMaterial();
				temp = temp.mul(light[i].intensity);
				temp = temp.scale(c);
				shade = shade.add(temp);
			}
		}
		return shade;
	}
}

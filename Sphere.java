import java.lang.Math;

public class Sphere extends Shape{
	public Point origin;
	public float radius;
	public Sphere(){
	}
	public Sphere(Point p, float r, RGB rd){
		this.origin = new Point(p);
		this.radius = r;
		this.rd = new RGB(rd);
	}
	public Sphere(Sphere other){
		this.origin = new Point(other.origin);
		this.radius = other.radius;
		this.rd = new RGB(other.rd);
	}
	public boolean equals(Sphere other){
		if(this.origin.equals(other.origin)&&this.radius==other.radius&&this.rd.equals(other.rd))
			return true;
		else
			return false;
	}
	public boolean equals(Triangle other){
		return false;
	}
	public Intersection Intersect(Ray ray){
		float a=ray.d.dot(ray.d);
		float b=2*(ray.d.x*(ray.o.x-this.origin.x)+ray.d.y*(ray.o.y-this.origin.y)+ray.d.z*(ray.o.z-this.origin.z));
		float c=(ray.o.x-this.origin.x)*(ray.o.x-this.origin.x)+(ray.o.y-this.origin.y)*(ray.o.y-this.origin.y)+(ray.o.z-this.origin.z)*(ray.o.z-this.origin.z)-this.radius*this.radius;
		float disc=b*b-4*a*c;
		float t0, t1;
		float thit;
		Intersection ni = null;
		if(disc<0){
			//System.out.println("disc<0");
			return ni;
		}
		else{
			//System.out.println("in else");
			t0=(-b-(float)Math.sqrt(disc))/(2*a);
			t1=(-b+(float)Math.sqrt(disc))/(2*a);
			if (t0 > ray.maxt || t1 < ray.mint)
				return ni;
			thit = t0;
			if (t0 < ray.mint) {
				thit = t1;
				if (thit > ray.maxt) 
					return ni;
			}
		}
		ray.maxt = thit;
		Point phit = new Point();
		phit=ray.at(thit);
		Vector n = new Vector();
		n.x=(phit.x-this.origin.x)/this.radius;
		n.y=(phit.y-this.origin.y)/this.radius;
		n.z=(phit.z-this.origin.z)/this.radius;
				
		Intersection i = new Intersection(phit, n, this);
		return i;
	}
	public boolean IntersectP(Ray ray){
		float a=ray.d.dot(ray.d);
		float b=2*(ray.d.x*(ray.o.x-this.origin.x)+ray.d.y*(ray.o.y-this.origin.y)+ray.d.z*(ray.o.z-this.origin.z));
		float c=(ray.o.x-this.origin.x)*(ray.o.x-this.origin.x)+(ray.o.y-this.origin.y)*(ray.o.y-this.origin.y)+(ray.o.z-this.origin.z)*(ray.o.z-this.origin.z)-this.radius*this.radius;
		float disc=b*b-4*a*c;
		float t0, t1;
		if(disc<0)
			return false;
		else{
			t0=(-b-(float)Math.sqrt(disc))/(2*a);
			t1=(-b+(float)Math.sqrt(disc))/(2*a);
			if (t0 > ray.maxt || t1 < ray.mint)
				return false;
			if (t0 < ray.mint) {
				if (t1 > ray.maxt) 
					return false;
			}
			return true;
		}
	}
}
import java.lang.Math;
public class Triangle extends Shape{
	public Point p1, p2, p3;
	public Vector n1, n2, n3;
	public Triangle(){
	}
	public Triangle(Point p1, Point p2, Point p3, Vector n1, Vector n2, Vector n3, RGB rd){
		this.p1 = new Point(p1);
		this.p2 = new Point(p2);
		this.p3 = new Point(p3);
		this.n1 = new Vector(n1);
		this.n2 = new Vector(n2);
		this.n3 = new Vector(n3);
		this.rd = new RGB(rd);
	}
	public Triangle(Triangle other){
		this.p1 = new Point(other.p1);
		this.p2 = new Point(other.p2);
		this.p3 = new Point(other.p3);
		this.n1 = new Vector(other.n1);
		this.n2 = new Vector(other.n2);
		this.n3 = new Vector(other.n3);
		this.rd = new RGB(other.rd);
	}
	public boolean equals(Triangle other){
		if(this.p1.equals(other.p1)&&this.p2.equals(other.p2)&&this.p3.equals(other.p3)&&this.n1.equals(other.n1)&&this.n2.equals(other.n2)&&this.n3.equals(other.n3)&&this.rd.equals(other.rd))
			return true;
		else
			return false;
	}
	public boolean equals(Sphere other){
		return false;
	}
	public Intersection Intersect(Ray ray){
		Vector v1=new Vector();
		Vector v2=new Vector();
		Vector n1=new Vector();
		v1=this.p2.sub(this.p1);
		v2=this.p3.sub(this.p1);
		n1=v1.cross(v2);
		n1=n1.normalize();
		Intersection ni = null;
		
		float dd = n1.dot(ray.d);
		if(dd == 0)
			return ni;
		float d = -((this.p1.x*n1.x) + (this.p1.y*n1.y) + (this.p1.z*n1.z));
		float no = ((ray.o.x*n1.x) + (ray.o.y*n1.y) + (ray.o.z*n1.z));
		float thit = -(d+no)/(dd);
		
		if(thit<0)
			return ni; //grows backwards
		if(thit<ray.mint || thit>ray.maxt)
			return ni;
		Point phit = new Point();
		phit=ray.at(thit);
		
		//in or out of triangle
		float uu, uv, vv, wu, wv, divisor;
		Vector w = new Vector();
		uu = v1.dot(v1);
		vv = v2.dot(v2);
		uv = v1.dot(v2);
		w = phit.sub(this.p1);
		wu = w.dot(v1);
		wv = w.dot(v2);
		divisor = uu*vv-uv*uv;
		float tests, testt;
		tests = (vv*wu-uv*wv)/divisor;
		testt = (uu*wv-uv*wu)/divisor;
		if((tests>=0.0&&tests<=1.0) && (testt>=0.0&&testt<=1.0) && ((tests+testt)<=1.0)){
			
			float testr =(float)1.0-tests-testt;
			Vector n = new Vector(testr, tests, testt);
			Intersection i = new Intersection(phit, n, this);
			ray.maxt = thit;
			return i;
		}
		else
			return ni; //false, return null
	}
	public boolean IntersectP(Ray ray){
		Vector v1=new Vector();
		Vector v2=new Vector();
		Vector n1=new Vector();
		v1=this.p2.sub(this.p1);
		v2=this.p3.sub(this.p1);
		n1=v1.cross(v2);
		n1=n1.normalize();
		
		float dd = n1.dot(ray.d);
		if(dd==0)
			return false;
		float d = this.p1.x*n1.x+this.p1.y*n1.y+this.p1.z*n1.z;
		float no = ray.o.x*n1.x+ray.o.y*n1.y+ray.o.z*n1.z;
		float thit = -(d+no)/(dd);
		
		if(thit<0)
			return false; //grows backwards
		if(thit<ray.mint || thit>ray.maxt)
			return false;
		Point phit = new Point();
		phit=ray.at(thit);
		
		//in or out of triangle
		float uu, uv, vv, wu, wv, divisor;
		Vector w = new Vector();
		uu = v1.dot(v1);
		vv = v2.dot(v2);
		uv = v1.dot(v2);
		w = phit.sub(this.p1);
		wu = w.dot(v1);
		wv = w.dot(v2);
		divisor = uv*uv-uu*vv;
		float tests, testt;
		tests = (uv*wv-vv*wu)/divisor;
		if(tests<0.0||tests>1.0)
			return false;
		testt = (uv*wu-uu*wv)/divisor;
		if(testt<0.0 ||(tests+testt)>1.0)
			return false;

		return true;
	
	}
}
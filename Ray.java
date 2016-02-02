public class Ray{
	public Point o;
	public Vector d;
	public float mint, maxt;
	public int depth;
	public Ray(){
	}
	public Ray(Point o, Vector d){
		this.o = new Point(o);
		this.d = new Vector(d);
		this.mint = 0;
		this.maxt = 1000;
	}
	public boolean equals(Ray other){
		if(this.o.equals(other.o)&&this.d.equals(other.d)&&this.mint==other.mint&&this.maxt==other.maxt)
			return true;
		else
			return false;
	}
	public String toString(){
		return("from the point "+this.o.toString()+" extending in the direction of "+this.d.toString());		
	}
	public Point at(float t){
		Point result=new Point();
		Vector m= new Vector();
		m=this.d.mul(t);
		result=this.o.add(m);
		return result;
	}
}
import java.lang.Math;

public class Vector{
	public float x,y,z;
	public Vector(){
	}
	public Vector(float x, float y, float z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public Vector(Vector other){
		this.x=other.x;
		this.y=other.y;
		this.z=other.z;
	}
	public Vector(Point p){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public boolean equals(Vector other){
		if(this.x==other.x&&this.y==other.y&&this.z==other.z)
			return true;
		else
			return false;
	}
	public String toString(){
		return(this.x+","+this.y+","+this.z);
	}
	public Vector add(Vector other){
		Vector result=new Vector();
		result.x=this.x+other.x;
		result.y=this.y+other.y;
		result.z=this.z+other.z;
		return result;
	}
    public Vector sub(Vector other){
		Vector result=new Vector();
		result.x=this.x-other.x;
		result.y=this.y-other.y;
		result.z=this.z-other.z;
		return result;
	}
	public Vector neg(){
		Vector result=new Vector();
		result.x=-this.x;
		result.y=-this.y;
		result.z=-this.z;
		return result;
	}
	public Vector mul(float a){
		Vector result=new Vector();
		result.x=a*this.x;
		result.y=a*this.y;
		result.z=a*this.z;
		return result;
	}
	public Vector div(float a){
		Vector result=new Vector();
		result.x=this.x/a;
		result.y=this.y/a;
		result.z=this.z/a;
		return result;
	}
	public float dot(Vector other){
		float result;
		result=this.x*other.x+this.y*other.y+this.z*other.z;
		return result;
	}
	public float absdot(Vector other){
		float result;
		result=this.x*other.x+this.y*other.y+this.z*other.z;
		if(result<0)
			result=-result;
		return result;
	}
	public Vector cross(Vector other){
		Vector result=new Vector();
		result.x=this.y*other.z-this.z*other.y;
		result.y=this.z*other.x-this.x*other.z;
		result.z=this.x*other.y-this.y*other.x;
		return result;
	}
	public float length(){
		float result;
		result=this.lengthsquared();
		result=(float)Math.sqrt(result);
		return result;
	}
	public float lengthsquared(){
		float result;
		result=this.x*this.x+this.y*this.y+this.z*this.z;
		return result;
	}
	public Vector normalize(){
		float n;
		Vector result=new Vector();
		n=this.length();
		result.x=this.x/n;
		result.y=this.y/n;
		result.z=this.z/n;
		return result;
	}
}
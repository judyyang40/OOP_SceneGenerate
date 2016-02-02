import java.lang.Math;

public class Point{
	float x, y, z;
	public Point(float x, float y, float z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public Point(){
	}
	public Point(Point other){
		this.x=other.x;
		this.y=other.y;
		this.z=other.z;
	}
	public boolean equals(Point other){
		if(this.x==other.x&&this.y==other.y&&this.z==other.z)
			return true;
		else
			return false;
	}
	public String toString(){
		return(this.x+","+this.y+","+this.z);
	}
	public Point add(Vector other){
		Point result=new Point();
		result.x=this.x+other.x;
		result.y=this.y+other.y;
		result.z=this.z+other.z;
		return result;
	}
	public Point sub(Vector other){
		Point result=new Point();
		result.x=this.x-other.x;
		result.y=this.y-other.y;
		result.z=this.z-other.z;
		return result;
	}
	public Vector sub(Point other){
		Vector result=new Vector();
		result.x=this.x-other.x;
		result.y=this.y-other.y;
		result.z=this.z-other.z;
		return result;
	}
	public Point add(Point other){
		Point result=new Point();
		result.x=this.x+other.x;
		result.y=this.y+other.y;
		result.z=this.z+other.z;
		return result;
	}
	public Point mul(float a){
		Point result=new Point();
		result.x=a*this.x;
		result.y=a*this.y;
		result.z=a*this.z;
		return result;
	}
	public Point div(float a){
		Point result=new Point();
		result.x=this.x/a;
		result.y=this.y/a;
		result.z=this.z/a;
		return result;
	}
	public float distancesquared(Point other){
		float result;
		result=(other.x-this.x)*(other.x-this.x)+(other.y-this.y)*(other.y-this.y)+(other.z-this.z)*(other.z-this.z);
		return result;
	}
	public float distance(Point other){
		float result;
		result=this.distancesquared(other);
		result=(float)Math.sqrt(result);
		return result;
	}
}
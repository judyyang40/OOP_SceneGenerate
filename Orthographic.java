public class Orthographic extends Camera{
	public Orthographic(float left, float right, float up, float bottom, int width, int height){
		super(left, right, up, bottom, width, height);
	}
	public Ray GenerateRay(int x, int y){
		float u, v;
		u = this.left+(float)(x/(float)this.width)*(this.right-this.left);
		v = this.top-(float)(y/(float)this.height)*(this.top-this.bottom);
		Point o = new Point(u,v,1);
		Vector d = new Vector(0,0,1);
		Ray r = new Ray(o, d);
		return r;
	}
}
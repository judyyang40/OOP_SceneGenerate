public class Perspective extends Camera{
	public Perspective(float left, float right, float up, float bottom, int width, int height){
		super(left, right, up, bottom, width, height);
	}
	public Ray GenerateRay(int x, int y){
		float u, v;
		float w;
		u = this.left+(float)(x/(float)this.width)*(this.right-this.left);
		v = this.top-(float)(y/(float)this.height)*(this.top-this.bottom);
		Point o = new Point(0,0,0);
		Vector d = new Vector(u,v,1);
		d=d.normalize();
		Ray r = new Ray(o, d);
		return r;
	}
}
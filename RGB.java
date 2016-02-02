public class RGB{
	public float r, g, b;
	public RGB(){
	}
	public RGB(float r, float g, float b){
		this.r=r;
		this.g=g;
		this.b=b;
	}
	public RGB(RGB other){
		this.r=other.r;
		this.g=other.g;
		this.b=other.b;
	}
	public RGB add(RGB other){
		RGB result = new RGB();
		result.r = this.r + other.r;
		result.g = this.g + other.g;
		result.b = this.b + other.b;
		return result;
	}
	public RGB mul(RGB other){
		RGB result = new RGB();
		result.r = this.r * other.r;
		result.g = this.g * other.g;
		result.b = this.b * other.b;
		return result;
	}
	public RGB scale(float a){
		RGB result = new RGB();
		result.r = this.r *a;
		result.g = this.g *a;
		result.b = this.b *a;
		return result;
	}	
	public boolean equals(RGB other){
		if(this.r==other.r&&this.g==other.g&&this.b==other.b)
			return true;
		else
			return false;
	}
	public String toString(){
		return(r+" "+g+" "+b);
	}
}
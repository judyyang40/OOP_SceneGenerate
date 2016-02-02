import java.io.*;

public abstract class Camera{
	protected float left, right;
	protected float top, bottom;
	protected int width, height;
	protected RGB[][] film = new RGB[1000][1000]; 
	
	public Camera(float left, float right, float up, float bottom, int width, int height){
		this.left=left;
		this.right=right;
		this.top=up;
		this.bottom=bottom;
		this.width=width;
		this.height=height;
		film = new RGB[this.height][this.width];
	}
	public abstract Ray GenerateRay(int x, int y);
	public boolean AddSample(int x, int y, RGB p){
		film[y][x] = new RGB(p);
		return true;
	}
	public boolean WriteImage(String fname){
		DataOutputStream outputStream = null;
		try{
			outputStream = new DataOutputStream(new FileOutputStream(fname));
			String s = "PF\n";
			byte[] b = s.getBytes("US-ASCII");
			outputStream.write(b, 0, b.length);
			String s2 = this.width+" "+this.height+"\n";
			byte[] b2 = s2.getBytes("US-ASCII");
			outputStream.write(b2, 0, b2.length);
			String s3 = "1.0000\n";
			byte[] b3 = s3.getBytes("US-ASCII");
			outputStream.write(b3, 0, b3.length);
			for(int i=0;i<this.height;i++){
				for(int j=0;j<this.width;j++){
					outputStream.writeFloat(this.film[i][j].r);
					outputStream.writeFloat(this.film[i][j].g);
					outputStream.writeFloat(this.film[i][j].b);
				}
			}
			outputStream.flush();
			outputStream.close();
		}
		catch(IOException e){
		}
		return true;
	}
}

import java.util.Scanner;
import java.io.*;
public class RayTracer{
	static Camera camera;
	static Shape[] shape = new Shape[260];
	static PointLight[] light = new PointLight[20];
	static int ShapeCount=0;
	static int LightCount=0;
	public static void main(String args[]) {
		//open and parse
		String in = null;
		Scanner inputStream = null;
		try{
			inputStream = new Scanner(new FileInputStream(args[0]));
		}
		catch(FileNotFoundException e){
			System.exit(0);
		}
		while(inputStream.hasNextLine()){
			in = inputStream.next();
			
			if(in.equals("Orthographic")){
				float left, right, up, bottom;
				int	width, height;
				left = inputStream.nextFloat();
				right = inputStream.nextFloat();
				up = inputStream.nextFloat();
				bottom = inputStream.nextFloat();
				width = inputStream.nextInt();
				height = inputStream.nextInt();
				camera = new Orthographic(left, right, up, bottom, width, height);
			}
			if(in.equals("Perspective")){
				float left, right, up, bottom;
				int width, height;
				left = inputStream.nextFloat();
				right = inputStream.nextFloat();
				up = inputStream.nextFloat();
				bottom = inputStream.nextFloat();
				width = inputStream.nextInt();
				height = inputStream.nextInt();
				camera = new Perspective(left, right, up, bottom, width, height);
			}
			if(in.equals("PointLight")){
				float x, y, z, r, g, b;
				x = inputStream.nextFloat();
				y = inputStream.nextFloat();
				z = inputStream.nextFloat();
				r = inputStream.nextFloat();
				g = inputStream.nextFloat();
				b = inputStream.nextFloat();
				light[LightCount] = new PointLight(x, y, z, r, g, b);
				LightCount++;
			}
			if(in.equals("Sphere")){
				float x, y, z, radius, r, g, b;
				x = inputStream.nextFloat();
				y = inputStream.nextFloat();
				z = inputStream.nextFloat();
				Point p = new Point(x, y, z);
				radius = inputStream.nextFloat();
				r = inputStream.nextFloat();
				g = inputStream.nextFloat();
				b = inputStream.nextFloat();
				RGB rd = new RGB(r, g, b);
				shape[ShapeCount] = new Sphere(p, radius, rd);
				ShapeCount++;
			}
			if(in.equals("Triangle")){
				float x, y, z, r, g, b;
				x = inputStream.nextFloat();
				y = inputStream.nextFloat();
				z = inputStream.nextFloat();
				Point p1 = new Point(x, y, z);
				x = inputStream.nextFloat();
				y = inputStream.nextFloat();
				z = inputStream.nextFloat();
				Point p2 = new Point(x, y, z);
				x = inputStream.nextFloat();
				y = inputStream.nextFloat();
				z = inputStream.nextFloat();
				Point p3 = new Point(x, y, z);
				x = inputStream.nextFloat();
				y = inputStream.nextFloat();
				z = inputStream.nextFloat();
				Vector v1 = new Vector(x, y, z);
				x = inputStream.nextFloat();
				y = inputStream.nextFloat();
				z = inputStream.nextFloat();
				Vector v2 = new Vector(x, y, z);
				x = inputStream.nextFloat();
				y = inputStream.nextFloat();
				z = inputStream.nextFloat();
				Vector v3 = new Vector(x, y, z);
				r = inputStream.nextFloat();
				g = inputStream.nextFloat();
				b = inputStream.nextFloat();
				RGB rd = new RGB(r, g, b);
				shape[ShapeCount] = new Triangle(p1, p2, p3, v1, v2, v3, rd);
				ShapeCount++;
			}
		}
		inputStream.close();
		//finish parsing scene file
		for(int y=0; y<camera.height; y++){
			for(int x=0; x<camera.width; x++){
				camera.film[y][x] = new RGB();
				Ray r = camera.GenerateRay(x, y);
				Intersection isect = null;
				Intersection new_isect = null;
				for(int i=0; i<ShapeCount; i++){
					new_isect = shape[i].Intersect(r);
					if(new_isect != null){
						isect = new Intersection(new_isect);
					}
				}
				if(isect != null){
					camera.AddSample(x, y, isect.Shade(light, LightCount));
				}
			}
		}	
		camera.WriteImage(args[1]);
	}
}
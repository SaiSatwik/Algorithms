import java.util.*;
class Point{
	int x;
	int y;
	Point(int x,int y){
		this.x=x;
		this.y=y;
	}
}

public class JarvixConvexHull {
	
	
	public  int crossproduct(Point a, Point b, Point c) {
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        return y2 * x1 - y1 * x2;
	}
	public  int distance(Point a, Point b, Point c) {
		int y1 = a.y - b.y;
	    int y2 = a.y - c.y;
	    int x1 = a.x - b.x;
	    int x2 = a.x - c.x;
	    return Integer.compare(y1 * y1 + x1 * x1, y2 * y2 + x2 * x2);
	}
	
	public  List<Point> findConvexHull(Point[] points){
		Point start=points[0];
		for(int i=1;i<points.length;i++) {
			if(points[i].x<start.x) {
				start=points[i];
			}
		}
		Point now=start;
		Set<Point> result=new HashSet<>();
		result.add(start);
		List<Point> collinearPoints=new ArrayList<>();
		while(true) {
			Point next=points[0];
			for(int i=1;i<points.length;i++) {
				if(points[i]==now) {
					continue;
				}
				int che=crossproduct(now,next,points[i]);
				if(che>0) {
					next=points[i];
					collinearPoints=new ArrayList<>();
				}
				else if(che==0) {
					if(distance(now,next,points[i])<0) {
						collinearPoints.add(next);
						next=points[i];
					}
					else {
						collinearPoints.add(points[i]);
					}
				}
			}
			for(int j=0;j<collinearPoints.size();j++) {
				result.add(collinearPoints.get(j));
			}
			if (next == start) {
                break;
            }
			result.add(next);
			now=next;
			
		}
		return new ArrayList<>(result);
		
		
	}
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JarvixConvexHull ob=new JarvixConvexHull(); 
        Point points[] = new Point[6];
        points[0]=new Point(1,1);
        points[1]=new Point(2,2);
        points[2]=new Point(2,0);
        points[3]=new Point(2,4);
        points[4]=new Point(3,3);
        points[5]=new Point(4,2);
        //points[6]=new Point(3, 3);
         
        List<Point>result=new ArrayList<>();
        result=ob.findConvexHull(points);
        for(int i=0;i<result.size();i++) {
        	System.out.println(result.get(i).x+" "+result.get(i).y);
        }
	}

}

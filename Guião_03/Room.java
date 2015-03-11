

public class Room {
	private String room;
	private Point bl, tr;
	
	public Room(Point bl, Point tr, String room){
		this.bl = bl;
		this.tr = tr;
		this.room = room;
	}
	public String roomType(){
		return room;
	}
	public Point bottomLeft(){
		return bl;
	}
	public Point topRight(){
		return tr;
	}
	public Point geomCenter(){
		return bl.halfWayTo(tr);
	}
	public double area(){
		return (tr.y() - bl.y()) * (tr.x() - bl.x());
	}
}

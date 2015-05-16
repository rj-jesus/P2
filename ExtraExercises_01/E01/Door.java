

public class Door {
	private int RoomId1, RoomId2;
	private double width, height;
   public Door(int r1, int r2, double w, double h) {
	assert w > 0 && h > 0: "Width and Height must be positive numbers.";
	assert r1 != r2: "Can't put a door connecting the same room.";
	RoomId1 = r1;
	RoomId2 = r2;
	width = w;
	height = h;
   }
   public double area(){
	   return width * height;
   }
   public int RoomId1(){
	   return RoomId1;
   }
   public int RoomId2(){
	   return RoomId2;
   }
}


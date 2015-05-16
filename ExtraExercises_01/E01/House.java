
import static java.lang.System.*;

public class House {

   public House(String houseType,int maxSize,int extensionSize) {
      this.houseType = houseType;
      this.extensionSize = extensionSize;
      rooms = new Room[maxSize];
      size = 0;
      doors = new Door[maxSize];
      numDoors = 0;
   }

   public House(String houseType) {
      this(houseType,8,4);
   } 

   public int size() {
      return size;
   }

   public int maxSize() {
      return rooms.length;
   }

   public Room room(int i) {
      return rooms[i];
   }

   public int addRoom(Room r) {
      if (size == rooms.length) extendHouse();
      rooms[size++] = r;
      return size - 1;
   }

   private void extendHouse() {
      Room [] newRooms = new Room[rooms.length+extensionSize];
      arraycopy(rooms, 0, newRooms, 0, rooms.length);
      rooms = newRooms;
   } 

   private String houseType;
   private int extensionSize;
   private Room [] rooms;
   private int size;
   private Door [] doors;
   private int numDoors;

   public void addDoor(Door d) {
	   if(numDoors == doors.length){
		   Door[] temp = doors;
		   doors = new Door[temp.length + extensionSize];
		   for(int i = 0; i < temp.length; i++) doors[i] = temp[i];
	   }
      doors[numDoors++] = d;
   }

   public int numDoors() {
      return numDoors;
   }

   public int maxNumDoors() {
      return doors.length;
   }
	public int maxDoorsInAnyRoom(){
		int[] n = new int[rooms.length];
		for(int i = 0; i < numDoors; i++){
			n[doors[i].RoomId1()] += 1;
			n[doors[i].RoomId2()] += 1;
		}
		int max = 0;
		for(int i : n) if(i > max) max = i;
		return max;
	}
	public int roomClosestToRoomType(String roomType){
		int index = -1;
		double distance = Integer.MAX_VALUE;
		for(Room room : rooms){
			if(room != null && room.roomType().equals(roomType)){
				for(int i = 0; i < size; i++){
					double this_distance = room.geomCenter().distTo(rooms[i].geomCenter());
					if(this_distance != 0 && this_distance < distance){
						distance = this_distance;
						index = i;
					}
				}
			}
		}
		return index;
	}
}


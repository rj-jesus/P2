

public class House {
	private String houseType;
	private Room[] rooms;
	private int expandBy;
	private int size;
	
	public House(String houseType){
		this.houseType = houseType;
		rooms = new Room[8];
		expandBy = 3;
	}
	public House(String houseType, int size, int expandBy){
		if(size <= 0) throw new AssertionError("Error: Can't start a house with either no or negative rooms!");
		if(expandBy <= 0) throw new AssertionError("Error: For safe usage keep a positive value to expand the house by!");
		this.houseType = houseType;
		rooms = new Room[size];
		this.expandBy = expandBy;
	}
	private Room[] expand(){
		Room[] tmp = new Room[rooms.length + expandBy];
		for(int i = 0; i < size; i++) tmp[i] = rooms[i];
		return tmp;
	}
	public void addRoom(Room x){
		if(rooms.length == size){
			rooms = expand();
			System.out.print("Notice: House was expanded.");
		}
		rooms[size] = x;
		size++;
	}
	public int size(){
		return size;
	}
	public int maxSize(){
		return rooms.length+1;
	}
	public Room room(int i){
		if(i < 0 || i >= size) throw new AssertionError("Error: Invalid room's index!");
		return rooms[i];
	}
	public double area(){
		double sum = 0;
		for(int i = 0; i < size; i++) sum += rooms[i].area();
		return sum;
	}
	public RoomTypeCount[] getRoomTypeCounts(){
		RoomTypeCount[] tmp = new RoomTypeCount[size];
		int trueSize = 0;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(tmp[j] == null){
					tmp[j] = new RoomTypeCount(rooms[i].roomType());
					trueSize++;
					break;
				}
				if(tmp[j].getRoomType().equals(rooms[i].roomType())){
					tmp[j].plusOne();
					break;
				}
			}
		}
		return trim(tmp, trueSize);
	}
	private static RoomTypeCount[] trim(RoomTypeCount[] a, int size){
		RoomTypeCount[] tmp = new RoomTypeCount[size];
		for(int i = 0; i < a.length && a[i] != null; i++) tmp[i] = a[i];
		return tmp;
	}
	public double averageRoomDistance(){
		if(size == 0) throw new AssertionError("Error: Invalid amount of rooms to get averege distance from!");
		double dist = 0;
		int divide = 0;
		for(int i = 0; i < size; i++){
			for(int j = i; j < size; j++){
				dist += rooms[i].geomCenter().distTo(rooms[j].geomCenter());
				divide++;
			}
		}
		return dist / divide;
	}
	public final class HouseType{
		public static final String APARTMENT = "apartment";
	}
	protected class RoomTypeCount{
		String roomType;
		int count;
		
		protected RoomTypeCount(String roomType){
			this.roomType = roomType;
			count++;
		}
		protected void plusOne(){
			count++;
		}
		protected String getRoomType(){
			return roomType;
		}
	}
}


package lesson15.HomeWork2;

public class GoogleAPI implements API {
    Room[] rooms;


    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room roomer=new Room(0,price,persons,null,hotel,city);
        int i = 0;
        for (Room room : rooms) {
            if(roomer.equals(room))
                i++;
        }
       Room[] rooms1= new Room[i];
        i=0;
        for (Room room : rooms) {
            if(roomer.equals(room))
            {
                rooms1[i]=room;
                i++;
            }
        }
        return rooms1;
    }


    @Override
    public Room[] getAll() {
        return rooms;
    }
}

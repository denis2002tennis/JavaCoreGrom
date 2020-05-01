package lesson11.homework;

public class GoogleAPI implements API {
    Room[] rooms;


    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int i = 0;
        for (Room room : rooms) {
            if (room.getPrice() == price && room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel){
                i++;
            }
        }
       Room[] rooms1= new Room[i];
        i=0;
        for (Room room : rooms) {
            if (room.getPrice() == price && room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel){
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

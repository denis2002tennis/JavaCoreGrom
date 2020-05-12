package lesson15.HomeWork2;

public class TripAdvisorAPI implements API {


    Room[] rooms;

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int i = 0;
        for (Room room : rooms) {
            if (room.getPrice() == price && room.getCityName() == city && room.getHotelName() == hotel) {
                int personss = room.getPersons();
                if ((persons + 1) > personss || personss > (persons - 1) || persons == personss)
                    i++;
            }
        }
        Room[] rooms1 = new Room[i];
        i = 0;
        for (Room room : rooms) {
            if (room.getPrice() == price && room.getCityName() == city && room.getHotelName() == hotel) {
                int personss = room.getPersons();
                if ((persons + 1) > personss || personss > (persons - 1) || persons == personss){
                    rooms1[i] = room;
                    i++;
                }
            }
        }

        return rooms1;
    }



    @Override
    public Room[] getAll() {
        return rooms;
    }

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }
}

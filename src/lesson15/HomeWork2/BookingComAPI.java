package lesson15.HomeWork2;

public class BookingComAPI implements API {


    Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int i = 0;
        for (Room room : rooms) {
            if (room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel) {
                int pricee = room.getPrice();
                if ((price + 100) > pricee || pricee > (price - 100) || price == pricee)
                    i++;
            }
        }
        Room[] rooms1 = new Room[i];
        i = 0;
        for (Room room : rooms) {
            if (room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel) {
                int pricee = room.getPrice();
                if ((price + 100) > pricee || pricee > (price - 100) || price == pricee) {
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
}

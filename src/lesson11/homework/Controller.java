package lesson11.homework;

public class Controller {
    API[] apis;
    Room[] rooms2;
    Room roomy;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        int i = 0;
        for (API api : apis) {
            for (Room room : api.getAll()) {
                if (room.getPrice() == price && room.getPersons() == persons && room.getCityName() == city && room.getHotelName() == hotel) {
                    rooms2[i] = room;
                }
            }
        }
        return rooms2;
    }

    public Room[] check(API api1, API api2) {
        int i = 0;

        for (Room room : api1.getAll()) {
            for (Room room2 : api2.getAll()) {
                if (room != null && room2 != null) {
                    if (room.getCityName() == room2.getCityName() && room.getPrice() == room2.getPrice() &&
                            room.getHotelName() == room2.getHotelName() && room.getPersons() == room2.getPersons())
                        i++;
                }
            }
        }

        Room[] rooms = new Room[i];
        i=0;
        for (Room room : api1.getAll()) {
            for (Room room2 : api2.getAll()) {
                if (room != null && room2 != null) {
                    if (room.getCityName() == room2.getCityName() && room.getPrice() == room2.getPrice() &&
                            room.getHotelName() == room2.getHotelName() && room.getPersons() == room2.getPersons()) {
                        rooms[i] = room;
                        i++;
                    }
                }
            }
        }

        return rooms;
    }

    public Room cheapestRoom() {
        for (API api : apis) {
            for (Room room : api.getAll())
                if (room.getPrice() < roomy.getPrice()) {
                    roomy = room;
                }
        }
        return roomy;
    }


}

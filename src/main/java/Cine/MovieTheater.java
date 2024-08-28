package Cine;

import com.github.javafaker.Faker;

public class MovieTheater {
    private Movie movie;
    private int ticketPrice;
    private Person[][] seats;

    public Movie getMovie() {
        return movie;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public MovieTheater(int ticketPrice, Movie movie) {
        this.ticketPrice = ticketPrice;
        this.movie = movie;
        this.seats = new Person[8][6];
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(Person[] line : this.seats){
            for(Person person : line){
                if(person == null){
                    s.append(" _ ");
                }else{
                    s.append(" X ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    private void assignSeat(Person person, int row, int column){
        this.seats[row][column] = person;
        System.out.println(person.getName() + " is in the row: " + row + " and in the column: " + column);
    }

    private boolean findSeat (Person person){
        Faker faker = new Faker();
        int row = faker.number().numberBetween(0,8);
        int column = faker.number().numberBetween(0,6);
        if(this.seats[row][column] == null){
            assignSeat(person, row, column);
            return true;
        }else{
            for(int i = 0; i<this.seats.length; i++){
                for(int j = 0; j<this.seats[i].length; j++){
                    if(this.seats[i][j] == null){
                        assignSeat(person, i, j);
                        return true;
                    }
                }
            }
        }

        System.out.println(person.getName() + " the theater is full.");
        return false;
    }

    public boolean checkInPerson(Person person){
        if(person.getMoney() >= this.ticketPrice && person.getAge() >= this.movie.getMinimunAge()){
            return findSeat(person);
        }
        if(person.getMoney() < this.ticketPrice){
            System.out.println(person.getName() + " is someone without money, $" + person.getMoney());
        }
        if(person.getAge() < this.movie.getMinimunAge()){
            System.out.println(person.getName() + " is a baby, " + person.getAge());
        }
        return false;
    }
}

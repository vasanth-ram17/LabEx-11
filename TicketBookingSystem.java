/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Vasanth
 */
public class TicketBookingSystem {
 public static void main(String[] args){
       int as =Booking.as;
        Booking reserve = new Booking(); 
        while(as > 0){
        People b = new People(reserve);
        b.start();
        as =Booking.as;
        }
    }
}
class Booking
{
    static int as = 100; 
   synchronized void reservingSeats() throws InterruptedException 
    {   int rs;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of seats to be reserved : ");
        rs = input.nextInt();
        System.out.println("Thread ID " + Thread.currentThread().getId() + " entered.");
        System.out.println("Available seats : " + as + " \nRequested seats : " + rs);
        if (as >= rs)
        {
            System.out.println("Seats are Available... Reserve now!");
             Thread.sleep(100);
            System.out.println(rs + " seats reserved.");
            as = as - rs;
            
        }
        else
        {
            System.out.println(" Sorry for the inconvenience... Requested seats are not available");
        }
    } 
}

class People extends Thread
{
    Booking reserve;
    public People(Booking reserve)
    {
        this.reserve = reserve;
    }


    @Override
    public void run() 
    {
        try {
            reserve.reservingSeats();
        } 
        catch (InterruptedException ex) {
           System.out.println(ex);
        }
    } 
 }     


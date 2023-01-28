package Appointment;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

enum Reminder { none, TEXT, EMAIL }

class Contact {
    private StringBuilder name;
    private String email;
    private String phone;

    private Reminder remind;
    private ZoneId zone;

    Contact (String fName, String lName, String email, String phone, Reminder r, ZoneId z) {
        this.name = new StringBuilder();
        this.name.append(fName).append(" ").append(lName);
        this.email = email;
        this.phone = phone;
        this.remind = r;
        this.zone = z;
    } //constructor

    public StringBuilder getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    public Reminder getReminder()
    {
        return remind;
    }

    public ZoneId getZone()
    {
        return zone;
    }
    @Override
    public String toString() {
        String s = this.name + " email: " + this.email + " phone: " + this.phone + " reminder: " + this.remind + " time zone: " + this.zone;
        return s;
    }
}
public class Appointment {

    private Contact contact;
    private String appointment_title;
    private String appointment_desc;
    private ZonedDateTime appointmenttime;
    private ZonedDateTime remindertime;



    // accessor and mutator for user
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void setAppointment(String apptitle, String apptdesc, ZonedDateTime appt, ZonedDateTime rm)
    {
        this.appointment_title=apptitle;
        this.appointment_desc=apptdesc;
        this.appointmenttime=appt;
        this.remindertime=rm;
    }

    public void display()
    {
        System.out.println("Title: " + this.appointment_title);
        System.out.println("Description: " + this.appointment_desc);
        System.out.println("Client: " + this.contact.toString());
        System.out.println("Appointment Date and Time: " + this.appointmenttime);
        System.out.println("Reminder Time: " + this.remindertime);
    }


    public static void main(String[] args) {

        //set appt general information
        var apptdate = LocalDate.of(2023, 5, 24);
        var appttime = LocalTime.of(13,0);
        var reminder = apptdate.minusDays(2);
        var zone =ZoneId.of("US/Eastern");
        var appointmenttime = ZonedDateTime.of(apptdate,appttime, zone);
        var remindertime = ZonedDateTime.of(reminder, appttime,zone);
        String apptitle="Medical Appointment with Dr. IC Spots.";
        String description="Pending Appointment.";
        Reminder R=Reminder.TEXT;

        //create objects
        Appointment  clientappt = new Appointment();
        Contact client = new Contact("Jane", "Smith","Jane.Smith@att.net","919-666-2424",R,zone);
        // set the information
        clientappt.setContact(client); //set the client info
        clientappt.setAppointment(apptitle, description, appointmenttime,remindertime);
        clientappt.display();

        // print the user's information

    }


}





package org.example.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Resident")
public class ResidentEntity {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String company;
    private String subscriptionPlan;
    private List<BookingEntity> bookings;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "First_Name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "Last_Name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "Email_Address", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "Contact_Number", nullable = false)
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Column(name = "Company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "Subscription_Plan", nullable = false)
    public String getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(String subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    @OneToMany(mappedBy = "resident")
    public List<BookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingEntity> bookings) {
        this.bookings = bookings;
    }
}
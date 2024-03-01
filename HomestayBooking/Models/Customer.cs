using System;
using System.Collections.Generic;

namespace HomestayBooking.Models;

public partial class Customer
{
    public int Custid { get; set; }

    public string? Firstname { get; set; }

    public string? Lastname { get; set; }

    public string? Address { get; set; }

    public string? Phone { get; set; }

    public string? Emailid { get; set; }

    public string Adhar { get; set; } = null!;

    public int? Userid { get; set; }

    public virtual ICollection<Booking> Bookings { get; set; } = new List<Booking>();

    public virtual ICollection<Payment> Payments { get; set; } = new List<Payment>();

    public virtual ICollection<Rating> Ratings { get; set; } = new List<Rating>();

    public virtual User? User { get; set; }
}

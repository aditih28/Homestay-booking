using System;
using System.Collections.Generic;

namespace HomestayBooking.Models;

public partial class Hotel
{
    public int Hotelid { get; set; }

    public string? Hotelname { get; set; }

    public string? Address { get; set; }

    public string? Emailid { get; set; }

    public string? Phone { get; set; }

    public string? Description { get; set; }

    public int? Ownerid { get; set; }

    public int? Totalrooms { get; set; }

    public int? Stateid { get; set; }

    public int? Cityid { get; set; }

    public int? Totalroms { get; set; }

    public virtual ICollection<Booking> Bookings { get; set; } = new List<Booking>();

    public virtual City? City { get; set; }

    public virtual Owner? Owner { get; set; }

    public virtual ICollection<Rating> Ratings { get; set; } = new List<Rating>();

    public virtual State? State { get; set; }
}

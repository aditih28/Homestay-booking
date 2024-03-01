using System;
using System.Collections.Generic;

namespace HomestayBooking.Models;

public partial class Booking
{
    public int Bookingid { get; set; }

    public int? Hotelid { get; set; }

    public DateOnly? Startdate { get; set; }

    public DateOnly? Enddate { get; set; }

    public DateOnly? Bookingdate { get; set; }

    public int? Custid { get; set; }

    public int? Noofrooms { get; set; }

    public virtual Customer? Cust { get; set; }

    public virtual Hotel? Hotel { get; set; }

    public virtual ICollection<Payment> Payments { get; set; } = new List<Payment>();
}

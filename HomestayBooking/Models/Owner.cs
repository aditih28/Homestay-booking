using System;
using System.Collections.Generic;

namespace HomestayBooking.Models;

public partial class Owner
{
    public int Ownerid { get; set; }

    public string? Firstname { get; set; }

    public string? Lastname { get; set; }

    public string? Address { get; set; }

    public string? Phone { get; set; }

    public string? Emailid { get; set; }

    public int? Userid { get; set; }

    public string? Propertytype { get; set; }

    public string? Adhar { get; set; }

    public virtual ICollection<Homestay> Homestays { get; set; } = new List<Homestay>();

    public virtual ICollection<Hotel> Hotels { get; set; } = new List<Hotel>();

    public virtual User? User { get; set; }
}

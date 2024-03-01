using System;
using System.Collections.Generic;

namespace HomestayBooking.Models;

public partial class City
{
    public int Cityid { get; set; }

    public string? Cityname { get; set; }

    public int? Stateid { get; set; }

    public virtual ICollection<Homestay> Homestays { get; set; } = new List<Homestay>();

    public virtual ICollection<Hotel> Hotels { get; set; } = new List<Hotel>();

    public virtual State? State { get; set; }
}

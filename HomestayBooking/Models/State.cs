using System;
using System.Collections.Generic;

namespace HomestayBooking.Models;

public partial class State
{
    public int Stateid { get; set; }

    public string? Statename { get; set; }

    public virtual ICollection<City> Cities { get; set; } = new List<City>();

    public virtual ICollection<Homestay> Homestays { get; set; } = new List<Homestay>();

    public virtual ICollection<Hotel> Hotels { get; set; } = new List<Hotel>();
}

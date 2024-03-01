using System;
using System.Collections.Generic;

namespace HomestayBooking.Models;

public partial class User
{
    public int Userid { get; set; }

    public string? Username { get; set; }

    public string? Password { get; set; }

    public int? Roleid { get; set; }

    public sbyte? Status { get; set; }

    public ulong? Approvestatus { get; set; }

    public virtual ICollection<Customer> Customers { get; set; } = new List<Customer>();

    public virtual ICollection<Owner> Owners { get; set; } = new List<Owner>();

    public virtual Role? Role { get; set; }
}

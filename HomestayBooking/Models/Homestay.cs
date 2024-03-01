using System;
using System.Collections.Generic;

namespace HomestayBooking.Models;

public partial class Homestay
{
    public int Homestayid { get; set; }

    public string? Name { get; set; }

    public string? Address { get; set; }

    public string? Emailid { get; set; }

    public string? Phone { get; set; }

    public string? Description { get; set; }

    public int? Ownerid { get; set; }

    public int? Capacity { get; set; }

    public int? Stateid { get; set; }

    public int? Cityid { get; set; }

    public virtual City? City { get; set; }

    public virtual Owner? Owner { get; set; }

    public virtual State? State { get; set; }
}

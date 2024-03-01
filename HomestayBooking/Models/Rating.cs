using System;
using System.Collections.Generic;

namespace HomestayBooking.Models;

public partial class Rating
{
    public int Ratingid { get; set; }

    public int? Hotelid { get; set; }

    public int? Custid { get; set; }

    public int? Rate { get; set; }

    public string? Comment { get; set; }

    public virtual Customer? Cust { get; set; }

    public virtual Hotel? Hotel { get; set; }
}

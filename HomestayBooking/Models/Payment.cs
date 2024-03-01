using System;
using System.Collections.Generic;

namespace HomestayBooking.Models;

public partial class Payment
{
    public int Paymentid { get; set; }

    public int? Custid { get; set; }

    public int? Bookingid { get; set; }

    public int? Amount { get; set; }

    public string? Transactionid { get; set; }

    public virtual Booking? Booking { get; set; }

    public virtual Customer? Cust { get; set; }
}

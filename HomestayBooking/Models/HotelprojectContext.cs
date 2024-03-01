using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Pomelo.EntityFrameworkCore.MySql.Scaffolding.Internal;

namespace HomestayBooking.Models;

public partial class HotelprojectContext : DbContext
{
    public HotelprojectContext()
    {
    }

    public HotelprojectContext(DbContextOptions<HotelprojectContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Booking> Bookings { get; set; }

    public virtual DbSet<City> Cities { get; set; }

    public virtual DbSet<Customer> Customers { get; set; }

    public virtual DbSet<Homestay> Homestays { get; set; }

    public virtual DbSet<Hotel> Hotels { get; set; }

    public virtual DbSet<Owner> Owners { get; set; }

    public virtual DbSet<Payment> Payments { get; set; }

    public virtual DbSet<Rating> Ratings { get; set; }

    public virtual DbSet<Role> Roles { get; set; }

    public virtual DbSet<State> States { get; set; }

    public virtual DbSet<User> Users { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseMySql("server=localhost;port=3307;user=root;password=root;database=hotelproject", Microsoft.EntityFrameworkCore.ServerVersion.Parse("8.0.34-mysql"));

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder
            .UseCollation("utf8mb4_0900_ai_ci")
            .HasCharSet("utf8mb4");

        modelBuilder.Entity<Booking>(entity =>
        {
            entity.HasKey(e => e.Bookingid).HasName("PRIMARY");

            entity.ToTable("booking");

            entity.HasIndex(e => e.Custid, "cust_idx_idx");

            entity.HasIndex(e => e.Hotelid, "hotel_idx_idx");

            entity.Property(e => e.Bookingid).HasColumnName("bookingid");
            entity.Property(e => e.Bookingdate).HasColumnName("bookingdate");
            entity.Property(e => e.Custid).HasColumnName("custid");
            entity.Property(e => e.Enddate).HasColumnName("enddate");
            entity.Property(e => e.Hotelid).HasColumnName("hotelid");
            entity.Property(e => e.Noofrooms).HasColumnName("noofrooms");
            entity.Property(e => e.Startdate).HasColumnName("startdate");

            entity.HasOne(d => d.Cust).WithMany(p => p.Bookings)
                .HasForeignKey(d => d.Custid)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("cust_idx");

            entity.HasOne(d => d.Hotel).WithMany(p => p.Bookings)
                .HasForeignKey(d => d.Hotelid)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("hotel_idx");
        });

        modelBuilder.Entity<City>(entity =>
        {
            entity.HasKey(e => e.Cityid).HasName("PRIMARY");

            entity.ToTable("cities");

            entity.HasIndex(e => e.Stateid, "fk_stateid_idx");

            entity.Property(e => e.Cityid).HasColumnName("cityid");
            entity.Property(e => e.Cityname)
                .HasMaxLength(45)
                .HasColumnName("cityname");
            entity.Property(e => e.Stateid).HasColumnName("stateid");

            entity.HasOne(d => d.State).WithMany(p => p.Cities)
                .HasForeignKey(d => d.Stateid)
                .HasConstraintName("fk_stateid");
        });

        modelBuilder.Entity<Customer>(entity =>
        {
            entity.HasKey(e => e.Custid).HasName("PRIMARY");

            entity.ToTable("customer");

            entity.HasIndex(e => e.Userid, "userid");

            entity.Property(e => e.Custid).HasColumnName("custid");
            entity.Property(e => e.Address)
                .HasMaxLength(50)
                .HasColumnName("address");
            entity.Property(e => e.Adhar)
                .HasMaxLength(20)
                .HasColumnName("adhar");
            entity.Property(e => e.Emailid)
                .HasMaxLength(50)
                .HasColumnName("emailid");
            entity.Property(e => e.Firstname)
                .HasMaxLength(20)
                .HasColumnName("firstname");
            entity.Property(e => e.Lastname)
                .HasMaxLength(20)
                .HasColumnName("lastname");
            entity.Property(e => e.Phone)
                .HasMaxLength(20)
                .HasColumnName("phone");
            entity.Property(e => e.Userid).HasColumnName("userid");

            entity.HasOne(d => d.User).WithMany(p => p.Customers)
                .HasForeignKey(d => d.Userid)
                .OnDelete(DeleteBehavior.SetNull)
                .HasConstraintName("customer_ibfk_1");
        });

        modelBuilder.Entity<Homestay>(entity =>
        {
            entity.HasKey(e => e.Homestayid).HasName("PRIMARY");

            entity.ToTable("homestays");

            entity.HasIndex(e => e.Cityid, "cityid_fk_idx");

            entity.HasIndex(e => e.Ownerid, "ownerid_idx");

            entity.HasIndex(e => e.Stateid, "stateid_fkk_idx");

            entity.Property(e => e.Homestayid).HasColumnName("homestayid");
            entity.Property(e => e.Address)
                .HasMaxLength(45)
                .HasColumnName("address");
            entity.Property(e => e.Capacity).HasColumnName("capacity");
            entity.Property(e => e.Cityid).HasColumnName("cityid");
            entity.Property(e => e.Description)
                .HasMaxLength(45)
                .HasColumnName("description");
            entity.Property(e => e.Emailid)
                .HasMaxLength(45)
                .HasColumnName("emailid");
            entity.Property(e => e.Name)
                .HasMaxLength(45)
                .HasColumnName("name");
            entity.Property(e => e.Ownerid).HasColumnName("ownerid");
            entity.Property(e => e.Phone)
                .HasMaxLength(45)
                .HasColumnName("phone");
            entity.Property(e => e.Stateid).HasColumnName("stateid");

            entity.HasOne(d => d.City).WithMany(p => p.Homestays)
                .HasForeignKey(d => d.Cityid)
                .HasConstraintName("cityid_fk");

            entity.HasOne(d => d.Owner).WithMany(p => p.Homestays)
                .HasForeignKey(d => d.Ownerid)
                .HasConstraintName("owneri");

            entity.HasOne(d => d.State).WithMany(p => p.Homestays)
                .HasForeignKey(d => d.Stateid)
                .HasConstraintName("stateid_fkk");
        });

        modelBuilder.Entity<Hotel>(entity =>
        {
            entity.HasKey(e => e.Hotelid).HasName("PRIMARY");

            entity.ToTable("hotels");

            entity.HasIndex(e => e.Cityid, "fk_cityid_idx");

            entity.HasIndex(e => e.Stateid, "fk_stateid_idx");

            entity.HasIndex(e => e.Ownerid, "owner_idx");

            entity.Property(e => e.Hotelid).HasColumnName("hotelid");
            entity.Property(e => e.Address)
                .HasMaxLength(45)
                .HasColumnName("address");
            entity.Property(e => e.Cityid).HasColumnName("cityid");
            entity.Property(e => e.Description)
                .HasMaxLength(45)
                .HasColumnName("description");
            entity.Property(e => e.Emailid)
                .HasMaxLength(45)
                .HasColumnName("emailid");
            entity.Property(e => e.Hotelname)
                .HasMaxLength(45)
                .HasColumnName("hotelname");
            entity.Property(e => e.Ownerid).HasColumnName("ownerid");
            entity.Property(e => e.Phone)
                .HasMaxLength(45)
                .HasColumnName("phone");
            entity.Property(e => e.Stateid).HasColumnName("stateid");
            entity.Property(e => e.Totalroms).HasColumnName("totalroms");
            entity.Property(e => e.Totalrooms).HasColumnName("totalrooms");

            entity.HasOne(d => d.City).WithMany(p => p.Hotels)
                .HasForeignKey(d => d.Cityid)
                .HasConstraintName("fk_cityid");

            entity.HasOne(d => d.Owner).WithMany(p => p.Hotels)
                .HasForeignKey(d => d.Ownerid)
                .OnDelete(DeleteBehavior.SetNull)
                .HasConstraintName("owner_idx");

            entity.HasOne(d => d.State).WithMany(p => p.Hotels)
                .HasForeignKey(d => d.Stateid)
                .HasConstraintName("stateid_fk");
        });

        modelBuilder.Entity<Owner>(entity =>
        {
            entity.HasKey(e => e.Ownerid).HasName("PRIMARY");

            entity.ToTable("owner");

            entity.HasIndex(e => e.Userid, "userid");

            entity.Property(e => e.Ownerid).HasColumnName("ownerid");
            entity.Property(e => e.Address)
                .HasMaxLength(50)
                .HasColumnName("address");
            entity.Property(e => e.Adhar)
                .HasMaxLength(45)
                .HasColumnName("adhar");
            entity.Property(e => e.Emailid)
                .HasMaxLength(50)
                .HasColumnName("emailid");
            entity.Property(e => e.Firstname)
                .HasMaxLength(20)
                .HasColumnName("firstname");
            entity.Property(e => e.Lastname)
                .HasMaxLength(20)
                .HasColumnName("lastname");
            entity.Property(e => e.Phone)
                .HasMaxLength(20)
                .HasColumnName("phone");
            entity.Property(e => e.Propertytype)
                .HasMaxLength(45)
                .HasColumnName("propertytype");
            entity.Property(e => e.Userid).HasColumnName("userid");

            entity.HasOne(d => d.User).WithMany(p => p.Owners)
                .HasForeignKey(d => d.Userid)
                .OnDelete(DeleteBehavior.SetNull)
                .HasConstraintName("owner_ibfk_1");
        });

        modelBuilder.Entity<Payment>(entity =>
        {
            entity.HasKey(e => e.Paymentid).HasName("PRIMARY");

            entity.ToTable("payment");

            entity.HasIndex(e => e.Bookingid, "bookingid_idx");

            entity.HasIndex(e => e.Custid, "custid_idx");

            entity.Property(e => e.Paymentid).HasColumnName("paymentid");
            entity.Property(e => e.Amount).HasColumnName("amount");
            entity.Property(e => e.Bookingid).HasColumnName("bookingid");
            entity.Property(e => e.Custid).HasColumnName("custid");
            entity.Property(e => e.Transactionid)
                .HasMaxLength(45)
                .HasColumnName("transactionid");

            entity.HasOne(d => d.Booking).WithMany(p => p.Payments)
                .HasForeignKey(d => d.Bookingid)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("bookingid");

            entity.HasOne(d => d.Cust).WithMany(p => p.Payments)
                .HasForeignKey(d => d.Custid)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("custid");
        });

        modelBuilder.Entity<Rating>(entity =>
        {
            entity.HasKey(e => e.Ratingid).HasName("PRIMARY");

            entity.ToTable("rating");

            entity.HasIndex(e => e.Custid, "custi_idx_idx");

            entity.HasIndex(e => e.Hotelid, "hoteli_idx_idx");

            entity.Property(e => e.Ratingid).HasColumnName("ratingid");
            entity.Property(e => e.Comment)
                .HasMaxLength(45)
                .HasColumnName("comment");
            entity.Property(e => e.Custid).HasColumnName("custid");
            entity.Property(e => e.Hotelid).HasColumnName("hotelid");
            entity.Property(e => e.Rate).HasColumnName("rate");

            entity.HasOne(d => d.Cust).WithMany(p => p.Ratings)
                .HasForeignKey(d => d.Custid)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("custi_idx");

            entity.HasOne(d => d.Hotel).WithMany(p => p.Ratings)
                .HasForeignKey(d => d.Hotelid)
                .OnDelete(DeleteBehavior.Cascade)
                .HasConstraintName("hoteli_idx");
        });

        modelBuilder.Entity<Role>(entity =>
        {
            entity.HasKey(e => e.Roleid).HasName("PRIMARY");

            entity.ToTable("role");

            entity.Property(e => e.Roleid).HasColumnName("roleid");
            entity.Property(e => e.Rolename)
                .HasMaxLength(20)
                .HasColumnName("rolename");
        });

        modelBuilder.Entity<State>(entity =>
        {
            entity.HasKey(e => e.Stateid).HasName("PRIMARY");

            entity.ToTable("states");

            entity.Property(e => e.Stateid).HasColumnName("stateid");
            entity.Property(e => e.Statename)
                .HasMaxLength(255)
                .HasColumnName("statename");
        });

        modelBuilder.Entity<User>(entity =>
        {
            entity.HasKey(e => e.Userid).HasName("PRIMARY");

            entity.ToTable("users");

            entity.HasIndex(e => e.Roleid, "roleid");

            entity.HasIndex(e => e.Username, "username_UNIQUE").IsUnique();

            entity.Property(e => e.Userid).HasColumnName("userid");
            entity.Property(e => e.Approvestatus)
                .HasColumnType("bit(1)")
                .HasColumnName("approvestatus");
            entity.Property(e => e.Password)
                .HasMaxLength(20)
                .HasColumnName("password");
            entity.Property(e => e.Roleid).HasColumnName("roleid");
            entity.Property(e => e.Status).HasColumnName("status");
            entity.Property(e => e.Username)
                .HasMaxLength(20)
                .HasColumnName("username");

            entity.HasOne(d => d.Role).WithMany(p => p.Users)
                .HasForeignKey(d => d.Roleid)
                .OnDelete(DeleteBehavior.SetNull)
                .HasConstraintName("users_ibfk_1");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}

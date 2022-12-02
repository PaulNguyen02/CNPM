create database MiniStore24H
use MiniStore24H

create table nhanvien(
	manv char(10) not null primary key,
	ten varchar(25),
	ngsinh char(25),
	dchi varchar(30),
	sdt char(10),
	cvu varchar(10),
	pass varchar(25),
	isdeleted int
)

create table donnhan(
	madn char(10) not null primary key,
	ngnhan char(25),
	dot int,
	manv char(10) foreign key references nhanvien(manv),
	tong int,
	isdeleted int
)


create table sanpham(
	masp char(10) not null primary key,
	tensp varchar(25),
	sl int,
	gia int,
	loai varchar(20),
	tenncc varchar(20), 
	isdeleted int
)

create table ctdn(
	madn char(10) foreign key references donnhan(madn),
	masp char(10) foreign key references sanpham(masp),
	soluong int,
	gia int,
	constraint PK_CTDN primary key (madn, masp)
)

create table hoadon(
	mahd char(10) not null primary key,
	ngayxuat char(25),
	manv char(10) foreign key references nhanvien(manv),
	tongtien int,
	isdeleted int
)

create table khuyenmai(
	makm char(10) not null primary key,
	nghl char(25),
	isdeleted int
)

create table ctkm(
	makm char(10) foreign key references khuyenmai(makm),
	masp char(10) foreign key references sanpham(masp),
	giam int,
	constraint PK_CTKM primary key(makm, masp)
)


create table cthd(
	mahd char(10) foreign key references hoadon(mahd),
	masp char(10) foreign key references sanpham(masp),
	sl int,
	makm char(10) foreign key references khuyenmai(makm),
	dongia int,
	constraint PK_CTHD primary key(mahd, masp)
)

create table doanhthu(
	thoigian char(10),
	doanthu int,
	banduoc int,
	primary key (thoigian)
) 

insert nhanvien values ('3120410412','Phuc','2/3/2002','152/7','0973645754','warehouse','12345678',0)
insert nhanvien values ('3120410419','Phuong','9/8/2002','154/6','0973645754','casher','12345678',0)
insert nhanvien values ('3120410092','Duy','2/6/2002','155/5','0973645754','manager','12345678',0)
insert doanhthu values ('2022-05-01',501,294)
insert doanhthu values ('2022-05-14',300,112)
insert doanhthu values	('2022-05-15',221,50)
insert doanhthu values	('2022-06-04',1234,182)
insert doanhthu values	('2022-06-14',4510,89)

insert sanpham 
values ('SP123','Keo Chanh',150,5000,'Candy','VNPROV',0),
		('SP456','Banh Oreo',200,10000,'Cookie','VNPROV',0),
		('SP789','Cocacola',100,12000,'Drink','VNPROV',0)

insert khuyenmai 
values ('KM123','23-6-2022',0)

insert ctkm values('KM123','SP456',2000)
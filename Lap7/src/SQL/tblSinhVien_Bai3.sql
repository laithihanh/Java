USE qlsv;
go
create table tblSinhVien_Lap7(
	id int identity primary key,
	rollNo varchar(8) Unique,
	sv_name nvarchar(256),
	sv_address nvarchar(521),
	sv_phone varchar(11),
	sv_email varchar(64) Unique,
)
go
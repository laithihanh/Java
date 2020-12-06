CREATE DATABASE qlsv;
go
USE qlsv;
go
create table tblNhaXuatBan (id int identity primary key,TenXuatBan nvarchar(200),DiaChi nvarchar(200),Sdt int)
insert into tblNhaXuatBan values (N'Chính trị Quốc gia',N'Hà Nội','0113557739')
insert into tblNhaXuatBan values (N'Tư pháp',N'Nam Định','0775669925')
insert into tblNhaXuatBan values (N'Thanh niên',N'Hà Nội','0335667789')
insert into tblNhaXuatBan values (N' Lao động',N'Hà Nội','0335667756')
go

 create table tblTheLoai (id int identity primary key,TenTheLoai nvarchar(200),MoTa nvarchar(200))
 insert into tblTheLoai values (N'Chính trị – pháp luật',N'Kích thích tinh thần')
insert into tblTheLoai values (N'Văn hóa xã hội – Lịch sử',N'Trau dồi kiến thức')
insert into tblTheLoai values (N'Tâm lý, tâm linh, tôn giáo',N'Củng cố vốn từ và cách hành văn')
insert into tblTheLoai values (N'Văn học nghệ thuật',N'Tăng khả năng tập trung')
 go
 create table tblSach (
	 MaSach int identity primary key, 
	 TenSach nvarchar(200),
	 TheLoai int foreign key references tblTheLoai(id),
	 NXB int foreign key references tblNhaXuatBan(id),
	 SoTrang int,
	 GiaTien float
 )
 go
create database BaiKtraJava2
go
use BaiKtraJava2
go
create table SinhVien(
	id int IDENTITY(1,1) NOT NULL, 
	ten nvarchar(32) NULL,
	gioiTinh bit ,  
	tuoi int NULL,
	toan float,
	ly float,
	hoa float,
	TrungBinh float
)
go
--Thêm mới 
create proc proc_sv_addSV	
	@ten nvarchar(32),
	@gioiTinh bit ,  
	@tuoi int NULL,
	@toan float,
	@ly float,
	@hoa float,
	@TrungBinh float
as
	insert into SinhVien(ten,gioiTinh,tuoi,toan,ly,hoa,TrungBinh)
	values (@ten,@gioiTinh,@tuoi,@toan,@ly,@hoa,@TrungBinh)
go

--Hiển thị 
create proc	proc_sv_getAllSV
as
	SELECT * FROM SinhVien order by ten ASC
go
select *from SinhVien
go

--Thủ tục sửa sản phẩm

create proc proc_sv_Update
	@id int,
	@ten nvarchar(32),
	@gioiTinh bit ,  
	@tuoi int NULL,
	@toan float,
	@ly float,
	@hoa float,
	@TrungBinh float
as 
	update SinhVien set ten = @ten,
	gioiTinh = @gioiTinh,
	tuoi = @tuoi,
	toan= @toan,
	ly= @ly,
	hoa= @hoa,
	TrungBinh = @TrungBinh

	WHERE id = @id
go

--Thủ tục xóa

create proc proc_sv_delete
@id int
as 
	delete from SinhVien where id = @id

go

--Tìm kiếm theo tên
CREATE PROC proc_sv_getNameSv
@ten nvarchar(32)
AS
	SELECT * FROM SinhVien WHERE ten like '%'+@ten+ '%'

GO
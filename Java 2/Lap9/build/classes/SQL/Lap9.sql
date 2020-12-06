CREATE DATABASE Lap09
go
use Lap09
go
create table GiaoDich(
	MaGD int IDENTITY(1,1) NOT NULL, 
	TenGD nvarchar(100) NULL, 
	LoaiGD nvarchar(100) NULL,
	GioGD time NULL, 
	NgayGD date NULL,
	Mota ntext NULL,
)
go
--Hiển thị giao dich
create proc proc_transaction_GetAll	
as
	SELECT * FROM GiaoDich
go
--Thêm mới giao dịch
create proc proc_transaction_Insert
	@TenGD nvarchar(100),
	@LoaiGD nvarchar,
	@GioGD time,
	@NgayGD date,
	@Mota ntext,
	@Msg nvarchar(100) 
	out
as
	if(exists(select * from GiaoDich where TenGD like @TenGD))
	begin 
		set @Msg = N'Tên giao dịch đã tồn tại';
		return
	end
	insert into GiaoDich(TenGD,LoaiGD,GioGD,NgayGD,Mota)
	values (@TenGD,@LoaiGD,@GioGD,@NgayGD,@Mota)

	set @Msg =''

go
-- Thủ tục tìm kiếm  theo tên
CREATE PROC proc_transaction_SearchByName
@TenGD nvarchar(100)
AS
	SELECT * FROM GiaoDich WHERE TenGD like '%'+@TenGD + '%'

GO

create proc proc_product_count_date
@YEAR int
as 
	
	select count(*) AS SoLuongNam from GiaoDich WHERE YEAR(NgayGD) = @YEAR

GO
exec proc_product_count_date 2020
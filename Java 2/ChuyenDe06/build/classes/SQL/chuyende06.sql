﻿CREATE DATABASE ChuyenDe06
GO
use ChuyenDe06
go
create table tblShoes(
	id int IDENTITY(1,1) NOT NULL, 
	name nvarchar(32) NULL,
	price float NULL,  
	year int NULL,
	description nvarchar(64) NULL,
)
go
--Hiển thị 
create proc proc_product_getAllShoes
as
	SELECT * FROM tblShoes order by name ASC
go
--Thêm mới 
create proc proc_product_addShoes	
	@name nvarchar(32),
	@price float ,  
	@year int ,
	@description nvarchar(64),
	@Msg nvarchar(100)
	out
as
	if(exists(select * from tblShoes where name like @name))
	begin 
		set @Msg = N'Tên sản phẩm đã tồn tại';
		return
	end
	insert into tblShoes(name,price,year,description)
	values (@name,@price,@year,@description)

	set @Msg =''

go
--Thủ tục sửa sản phẩm

create proc proc_product_Update
	@id int,
	@name nvarchar(32),
	@price float ,  
	@year int ,
	@description nvarchar(64)
as 
	update tblShoes set name = @name,
	price = @price,
	year = @year,
	description = @description

	WHERE id = @id
go
--Thủ tục xóa

create proc proc_product_delete
@id int
as 
	delete from tblShoes where id = @id

go
--Tìm kiếm theo mã 
create proc proc_product_searchByCateLogID 

 @id int

 as
	SELECT * FROM tblShoes WHERE id = @id
GO
--Tìm kiếm theo tên
CREATE PROC proc_product_getShoesByName
@name nvarchar(32)
AS
	SELECT * FROM tblShoes WHERE name like '%'+@name + '%'

GO
DELETE FROM tblShoes WHERE id = 4
go
use qlsv;
go
CREATE TABLE dboProductLap7_1(
	ProductId int IDENTITY(1,1) NOT NULL, 
	CatelogId int NULL, 
	ProductName nvarchar(100) NULL, 
	Content nvarchar(250) NULL, 
	ContentDetail ntext NULL, 
	PriceInput float NULL,
	PriceOutput float NULL, 
	Created date NULL, 
	Views int NULL, 
	BuyItem int NULL, 
	Status bit NULL 
) 
--Thủ tục lấy tất cả các bản ghi có trong database
go 
create proc proc_product_GetAll
as
	SELECT * FROM dboProductLap7_1
go
--Thủ tục thêm mới sản phẩm
create proc proc_product_Insert
	@CatelogId int,
	@ProductName nvarchar(100),
	@Content nvarchar(250),
	@ContentDetail ntext,
	@PriceInput float,
	@PriceOutput float,
	@Created date,
	@Views int,
	@BuyItem int,
	@Status bit,
	@Msg nvarchar(100) 
	out
as
	if(exists(select * from dboProductLap7_1 where ProductName like @ProductName))
	begin 
		set @Msg = N'Tên sản phẩm đã tồn tại';
		return
	end
	insert into dboProductLap7_1(CatelogId,ProductName,Content,ContentDetail,PriceInput,PriceOutput,Created,[Views],BuyItem,[Status])
	values (@CatelogId ,@ProductName,@Content,@ContentDetail ,@PriceInput ,@PriceOutput,@Created ,@Views,@BuyItem,@Status)

	set @Msg =''

go

--Thủ tục sửa sản phẩm

create proc proc_product_Update
	@ProductId int,
	@CatelogId int,
	@ProductName nvarchar(100),
	@Content nvarchar(250),
	@ContentDetail ntext,
	@PriceInput float,
	@PriceOutput float,
	@Created date,
	@Views int,
	@BuyItem int,
	@Status bit
as 
	update dboProductLap7_1 set CatelogId = @CatelogId,
	ProductName = @ProductName,
	Content = @Content,
	ContentDetail = @ContentDetail,
	PriceInput = @PriceInput,
	PriceOutput = @PriceOutput,
	Created = @Created,
	[Views] = @Views,
	BuyItem = @BuyItem,
	[Status] = @Status

	WHERE ProductId = @ProductId
go
--Thủ tục xóa

create proc proc_product_delete
@ProductId int
as 
	delete from dboProductLap7_1 where ProductId = @ProductId

--Tìm kiếm theo mã danh mục
go
create proc proc_product_searchByCateLogID 

 @CatelogId int

 as
	SELECT * FROM dboProductLap7_1 WHERE CatelogId = @CatelogId
GO
--sắp xếp theo ngày

create proc proc_product_sort_date

as 
	select * from dboProductLap7_1 order by convert(datetime, Created) DESC

GO
DROP proc proc_product_count_date
GO
create proc proc_product_count_date
@YEAR int
as 
	
	select count(*) AS SoLuongNam from dboProductLap7_1 WHERE YEAR(Created) = @YEAR

GO
exec proc_product_count_date 2020
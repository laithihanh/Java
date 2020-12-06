USE qlsv;
go
create table tblProduct (
	mahh int identity, 
	tenhh nvarchar(200),
	nhasx nvarchar(200), 
	soluong int, 
	giagoc float,
	vat int
)
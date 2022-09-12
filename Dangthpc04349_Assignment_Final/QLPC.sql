use master 
USE QLPC
create database QLPC
DROP database QLPC

CREATE TABLE TAIKHOAN
(
	TENTAIKHOAN NVARCHAR(50) NOT NULL,
	TENDANGNHAP VARCHAR(12) PRIMARY KEY not null,
	MATKHAU  VARCHAR(8) NOT NULL,
	EMAIL VARCHAR(50),
	CHUCVU NVARCHAR(20),
	TRANGTHAI BIT,
	QRCODE VARCHAR(50)
)
--DROP TABLE TAIKHOAN

CREATE TABLE SANPHAM
(
	MASANPHAM VARCHAR(9) not null primary key,
	MAHANG VARCHAR(12)  not null,
	TENSANPHAM VARCHAR(30),
	HINHANH VARCHAR(50),
	
	HEDIEUHANH VARCHAR(50),
	CPU NVARCHAR(50),
	CARDDOHOA NVARCHAR(50), 
	PIN VARCHAR(50),
	--TRONGLUONG VARCHAR(10)
	TRONGLUONG float,
	MANHINH VARCHAR(50),
	RAM VARCHAR(50),
	ODIA NVARCHAR(50),

	SOLUONG INT,
	GIA int,
	NOISANXUAT NVARCHAR(50),
	MAUSAC NVARCHAR(20),
	TENTAIKHOAN NVARCHAR(50)	--tên người chỉnh sửa, thêm sản phẩm
	--primary key(MASANPHAM) 
)

--delete from sanpham
--DROP TABLE SANPHAM

CREATE TABLE HANG
(
	MAHANG VARCHAR(12) not null PRIMARY KEY,
	TENHANG VARCHAR(9),
)
-------------------------------------------------------------------------------------

insert into TAIKHOAN
Values  (N'Trần Hữu Đang', 'admin', '123', 'dangthpc04349@fpt.edu.vn', N'Quản lí', 1,'mp_u^Dq\{DevH<th/T3NYzthean'),
		(N'Nguyễn Khánh Đan',	'dannk'	,'dannk123',	'dannkpc04351@fpt.edu.vn',	N'Nhân viên'	,1,	'w7yOcX9~=DcAH45(/TXl\2thean'),
		(N'Trần Thị Mỹ Duyên', 'mduyen', '123', 'duyenttmpc05508@fpt.edu.vn', N'Nhân viên', 1,'Fs[eMCWW&D)tHl6IpT)D[Rthean'),
		(N'Lê Bích Vi',	'thebank',	'090103',	'vilbpc04354@fpt.edu.vn',	N'Nhân viên',	1	,'/T6YJqZJ[D>`H;@n3T,6LUthean'),
		(N'Nguyễn Thị Diễm Ngân', 'nganmay', '123', 'nganntd@ctu.edu.vn', N'Nhân viên', 1,'B)MX%en"HD/AHkhC;T0C7Lthean'),
		(N'Đoàn Hiệp Sỹ', 'hiepsylon', '123', 'sydhpc04388@fpt.edu.vn', N'Nhân viên', 0,'.H;m{LLE$DUGH3rJVTF7)-thean'),
		(N'Phùng Quốc Vinh', 'vinhpq', '123', 'vinhpqpc@fpt.edu.vn', N'Nhân viên', 0,'x{QX~;5rlDxtH8t|nTp1>ithean'),
		(N'Lê Thị Ngọc Hân', 'hannah', '123', 'ltnhan-nna16@tdu.edu.vn', N'Nhân viên', 1,'mEgFZNOU`Do>H>(3bTWjKythean')


--delete from taikhoan

insert into SANPHAM
Values  ('DELL01', 'd03', 'DELL LATUTADE 145', '', 'WINDOWS 10 Home', 'Intel Core i5, 2.70 GHz, 12MB',N'Card rời - NVIDIA GeForce RTX3050, 4 GB',
			'3-cell Li-ion, 56 Wh',2.81,'15.6 inch, Full HD (1920 x 1080)','DDR4, 32GB','256 GB SSD NVMe PCIe',125,28000000,N'Nhật bản',N'Đỏ-đen',N'Trần Hữu Đang'),
		('DELL02', 'd03', 'DELL Gaming G15', '', 'WINDOWS 10 Pro', 'Intel Core i7, 2.70 GHz, 12MB',N'Card rời - NVIDIA GeForce RTX3050, 5 GB',
			'3-cell Li-ion, 56 Wh',2.81,'15.6 inch, Full HD (1920 x 1080)','DDR4, 32GB','256 GB SSD NVMe PCIe',87,32000000,N'Trung Quốc',N'Đỏ-đen',N'Trần Hữu Đang'),
		('LENOVO01', 'ln05', 'Lenovo legion 5', '', 'WINDOWS 10 Pro', 'Intel Core i7, 2.70 GHz, 12MB',N'NVIDIA GeForce RTX3050, 5 GB',
			'3-cell Li-ion, 56 Wh',2.81,'15.6 inch, Full HD (1920 x 1080)','DDR4, 32GB','256 GB SSD NVMe PCIe',150,21000000,N'Trung Quốc',N'Xanh-đen',N'Trần Hữu Đang'),
		('HP02', 'l04', 'HP envy 13', '', 'WINDOWS 10', 'Intel Core i5, 2.70 GHz, 12MB',N'Ryzoint GeForce RTX3050, 5 GB',
			'3-cell Li-ion, 56 Wh',2.81,'15.6 inch, Full HD (1920 x 1080)','DDR4, 32GB','256 GB SSD NVMe PCIe',200,17000000,N'Trung Quốc',N'Xanh-đen',N'Trần Hữu Đang'),
		('ASUS09', 'as5', 'Asus Gaming G21', '', 'WINDOWS 10', 'Intel Core i5, 2.70 GHz, 12MB',N'LIMITC GeForce RTX3050, 5 GB',
			'3-cell Li-ion, 56 Wh',2.81,'15.6 inch, Full HD (1920 x 1080)','DDR4, 32GB','256 GB SSD NVMe PCIe',100,17000000,N'Trung Quốc',N'Trắng(kim loại)',N'Trần Hữu Đang')

--delete from sanpham

insert into hang
Values  ('d03', 'DELL'),
		('ln05','LENOVO'),
		('as5','ASUS'),
		('l6','LG'),
		('l04','HP'),
		('m51','MSI'),
		('t53','TOSHIBA')

--delete from hang

		---------------------------------------------------
--DROP TABLE HANG

--ALTER TABLE dbo.SANPHAM ADD PRIMARY KEY (MAHANG)
--ALTER TABLE SANPHAM ADD PRIMARY KEY (MASANPHAM)


ALTER TABLE dbo.SANPHAM ADD FOREIGN KEY(MAHANG) REFERENCES HANG(MAHANG)

--select 
select * from sanpham
select * from TAIKHOAN
select * from HANG
select a.*, b.TENHANG from SANPHAM a, HANG b where a.MAHANG = b.MAHANG
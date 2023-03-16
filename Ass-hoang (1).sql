USE [master]
GO

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'ananas')
BEGIN
	ALTER DATABASE [ananas] SET OFFLINE WITH ROLLBACK IMMEDIATE;
	ALTER DATABASE [ananas] SET ONLINE;
	DROP DATABASE [ananas];
END

GO

CREATE DATABASE [ananas]
GO

USE [ananas]
GO

/*******************************************************************************
	Drop tables if exists
*******************************************************************************/
DECLARE @sql nvarchar(MAX) 
SET @sql = N'' 

SELECT @sql = @sql + N'ALTER TABLE ' + QUOTENAME(KCU1.TABLE_SCHEMA) 
    + N'.' + QUOTENAME(KCU1.TABLE_NAME) 
    + N' DROP CONSTRAINT ' -- + QUOTENAME(rc.CONSTRAINT_SCHEMA)  + N'.'  -- not in MS-SQL
    + QUOTENAME(rc.CONSTRAINT_NAME) + N'; ' + CHAR(13) + CHAR(10) 
FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS AS RC 

INNER JOIN INFORMATION_SCHEMA.KEY_COLUMN_USAGE AS KCU1 
    ON KCU1.CONSTRAINT_CATALOG = RC.CONSTRAINT_CATALOG  
    AND KCU1.CONSTRAINT_SCHEMA = RC.CONSTRAINT_SCHEMA 
    AND KCU1.CONSTRAINT_NAME = RC.CONSTRAINT_NAME 

EXECUTE(@sql) 

GO
DECLARE @sql2 NVARCHAR(max)=''

SELECT @sql2 += ' Drop table ' + QUOTENAME(TABLE_SCHEMA) + '.'+ QUOTENAME(TABLE_NAME) + '; '
FROM   INFORMATION_SCHEMA.TABLES
WHERE  TABLE_TYPE = 'BASE TABLE'

Exec Sp_executesql @sql2 
GO 

CREATE TABLE Users (
	[Username] [varchar](16) NOT NULL PRIMARY KEY,
	[Password] [varchar](32) NOT NULL,
	[FirstName] [nvarchar](50) NULL,
	[LastName] [nvarchar](50) NULL,
	[Address] [nvarchar](250) NULL,
	[Email] [nvarchar](50) NULL,
	[Phone] [nvarchar](20) NULL,
	[Role] [nvarchar](25) NULL,
	[gender] int null,
	[CreateDate] [datetime] NULL default(GETDATE()),
)
GO
CREATE TABLE Review (
	[ProductCode] [varchar](10) NOT NULL,
	[Username] [varchar](16) NOT NULL,
	[name] varchar(15)not null,
	[email] varchar(25) not null,
	[rating] [int]  null,
	[content] varchar(255) null,
	primary key ([ProductCode], [Username], [name])
)
GO

CREATE TABLE Categories (
	[ID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[CategoryName] [nvarchar](50) NULL unique,
)
GO

CREATE TABLE Products (
	[ProductCode] [varchar](10) NOT NULL primary key,
	[ProductName] [nvarchar](1000) NULL,
	[CategoryID] [int] NULL,
	[Price] [decimal](18, 0) NULL,
	[Description] [nvarchar](500) NULL,
	[Status] [nvarchar](50) NULL,
	[Gender] INT NULL,
	[CollectionID] [int] NULL,
	[Quantity] [int] NULL,
	[Style] [nvarchar](100) NULL,
	[DetailProduct] [nvarchar](1000) NULL,
)
GO

CREATE TABLE Collections (
	[ID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[CollectionName] [nvarchar](100) NOT NULL,
	[CollectionImage] [nvarchar](500) NULL,
)
GO

CREATE TABLE Orders (
	[ID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Username] [varchar](16) NULL,
	[Total] [decimal](18, 0) NULL,
	[Status] [nvarchar](50) NULL,
	[Address] [nvarchar](250) NULL,
	[Phone] [nvarchar](20) NULL,
	[FirstName] [nvarchar](50) NULL,
	[LastName] [nvarchar](50) NULL,
	[OrderDate] [date] NULL,
)
GO

CREATE TABLE OrderDetails (
	[orderDetailID] int identity(1, 1) not null,
	[ID] [int] NOT NULL,
	[ProductCode] [varchar](10) NOT NULL,
	[Size] [varchar](4) NOT NULL,
	[Quantity] [int] NOT NULL,
	primary key ([orderDetailID], [ID], [ProductCode])
)
GO

CREATE TABLE ProductImages (
	[ProductCode] [varchar](10) primary key,
	[image1] varchar(255)null,
	[image2] varchar(255)null,
	[image3] varchar(255)null,
)
GO

CREATE TABLE ProductSize (
	[ProductCode] [varchar](10) primary key,
	[size1] varchar(255) null,
	[size2] varchar(255) null,
	[size3] varchar(255) null,
	[size4] varchar(255)  null,
	[size5] varchar(255) null,
	[size6] varchar(255)null,
	[size7] varchar(255)null,
	[size8] varchar(255)null,
	[size9] varchar(255)null,
	[size10] varchar(255)null,
	[size11] varchar(255)null,
	[size12] varchar(255)null,
	
)
GO

ALTER TABLE Orders
ADD CONSTRAINT pk_order_user FOREIGN KEY ([Username]) REFERENCES Users([Username])
GO
ALTER TABLE Review
ADD CONSTRAINT pk_review_product FOREIGN KEY ([ProductCode]) REFERENCES Products([ProductCode]),
	CONSTRAINT pk_review_user FOREIGN KEY ([Username]) REFERENCES Users([Username])
GO
ALTER TABLE OrderDetails
ADD CONSTRAINT pk_orderDetail_order FOREIGN KEY ([ID]) REFERENCES Orders([ID]),
	CONSTRAINT pk_orderDetail_product FOREIGN KEY ([ProductCode]) REFERENCES Products([ProductCode])
GO
ALTER TABLE Products
ADD CONSTRAINT pk_product_colection FOREIGN KEY ([CollectionID]) REFERENCES Collections([ID]),
	CONSTRAINT pk_product_category FOREIGN KEY ([CategoryID]) REFERENCES Categories([ID])
GO


ALTER TABLE ProductImages
ADD CONSTRAINT pk_image_product FOREIGN KEY ([ProductCode]) REFERENCES Products([ProductCode])
GO

ALTER TABLE ProductSize
ADD CONSTRAINT pk_size_product FOREIGN KEY ([ProductCode]) REFERENCES Products([ProductCode])
GO


/**/
INSERT [dbo].[Users] ([Username], [Password], [FirstName], [LastName], [Address], [Email], [Phone], [Role], [CreateDate]) VALUES (N'admin', N'123', N'Nas', N'Ana ', N'Đại học FPT Hà Nội', N'ananas3353@gmail.com', N'0793382816', N'admin', CAST(N'2022-11-11 00:00:00.000' AS DateTime))
INSERT [dbo].[Users] ([Username], [Password], [FirstName], [LastName], [Address], [Email], [Phone], [Role], [CreateDate]) VALUES (N'vodien', N'123', N'Diện', N'Vô', N'Tân Xã, Thạch Thất, Hà Nội', N'', N'0793382816', N'customer', CAST(N'2022-11-10 23:52:06.130' AS DateTime))
INSERT [dbo].[Users] ([Username], [Password], [FirstName], [LastName], [Address], [Email], [Phone], [Role], [CreateDate]) VALUES (N'nguyentrai', N'123', N'Nguyen', N'Trãi', N'Đại học FPT Hà Nội', N'nguyentrai3353@gmail.com', N'0793382816', N'customer', CAST(N'2022-11-12 06:08:58.313' AS DateTime))
INSERT [dbo].[Users] ([Username], [Password], [FirstName], [LastName], [Address], [Email], [Phone], [Role], [CreateDate]) VALUES (N'HuyHoang', N'123', N'Huy', N'Hoàng', N'Đại học FPT Hà Nội', N'hoangthhe161351@fpt.edu.vn', N'0795482815', N'admin', CAST(N'2022-11-12 06:08:58.313' AS DateTime))
/**/
INSERT [dbo].[Categories] ( [CategoryName]) VALUES ( N'Footwear | Giày')
INSERT [dbo].[Categories] ( [CategoryName]) VALUES ( N'Top | Nửa trên')
INSERT [dbo].[Categories] ( [CategoryName]) VALUES ( N'Accessories | Phụ Kiện')
/**/
INSERT [dbo].[Collections] ( [CollectionName], [CollectionImage]) VALUES ( N'Track 6 OG', N'ảnh')
INSERT [dbo].[Collections] ( [CollectionName], [CollectionImage]) VALUES ( N'Ananas x Lucky Luke', NULL)
INSERT [dbo].[Collections] ( [CollectionName], [CollectionImage]) VALUES ( N'Yesterday', NULL)
INSERT [dbo].[Collections] ( [CollectionName], [CollectionImage]) VALUES ( N'Mister', NULL)

INSERT [dbo].[Orders] ( [Username], [Total], [Status], [Address], [Phone], [FirstName], [LastName], [OrderDate]) VALUES ( N'admin', CAST(455000 AS Decimal(18, 0)), N'Complete', N'Tân Xã, Thạch Hòa, Thạch Thất, Hà Nội', N'12345', N'Long', N'Chun', CAST(N'2022-01-28' AS Date))
INSERT [dbo].[Orders] ( [Username], [Total], [Status], [Address], [Phone], [FirstName], [LastName], [OrderDate]) VALUES ( N'HuyHoang', CAST(715000 AS Decimal(18, 0)), N'Complete', N'Tân Xã, Thạch Hòa, Thạch Thất, Hà Nội', N'1234', N'Quang', N'Nguyễn', CAST(N'2022-02-14' AS Date))
INSERT [dbo].[Orders] ( [Username], [Total], [Status], [Address], [Phone], [FirstName], [LastName], [OrderDate]) VALUES ( N'vodien', CAST(550000 AS Decimal(18, 0)), N'Complete', N'Tân Xã, Thạch Hòa, Thạch Thất, Hà Nội', N'123', N'Cường', N'Bùi', CAST(N'2022-05-25' AS Date))
INSERT [dbo].[Orders] ( [Username], [Total], [Status], [Address], [Phone], [FirstName], [LastName], [OrderDate]) VALUES ( N'vodien', CAST(610000 AS Decimal(18, 0)), N'Complete', N'Tân Xã, Thạch Hòa, Thạch Thất, Hà Nội', N'12345', N'Long', N'Nguyễn', CAST(N'2022-11-01' AS Date))
INSERT [dbo].[OrderDetails] ([ID], [ProductCode], [Size], [Quantity]) VALUES (1, N'AHCLLS04', N'free', 1)
INSERT [dbo].[OrderDetails] ([ID], [ProductCode], [Size], [Quantity]) VALUES (2, N'A6T003', N'38', 1)
INSERT [dbo].[OrderDetails] ([ID], [ProductCode], [Size], [Quantity]) VALUES (3, N'AHCLLS04', N'free', 1)
INSERT [dbo].[OrderDetails] ([ID], [ProductCode], [Size], [Quantity]) VALUES (4, N'A6T004', N'36', 1)







/*track6*/
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'A6T003', N'Ananas Track 6 - LOW TOP - BOTANICAL GARDEN', 1, CAST(999000 AS Decimal(18, 0)), N' Với cảm hứng từ Retro Sneakers và âm nhạc giai đoạn 1970s, Ananas Track 6 ra đời với danh hiệu là mẫu giày Cold Cement đầu tiên của Ananas - một thương hiệu giày Vulcanized. Chất liệu Storm Leather đáng giá "càn quét" toàn bộ bề mặt upper cùng những chi tiết thiết kế đặc trưng và mang nhiều ý nghĩa. Chắc rằng, Track 6 sẽ đem đến cho bạn sự tự nhiên thú vị như chính thông điệp bài hát Let it be của huyền thoại The Beatles gửi gắm. Màu all white chắc nhiều bạn sẽ thích.', N'New Arrival',  2, 1,  5, N'Low Top',  N'Gender: Unisex Size run: 35 – 46 Upper: Storm Leather Outsole: Rubber  Sản phẩm được Double Box khi giao hàng. Khuyến nghị chọn truesize hoặc +1 size (tùy form chân) so với giày Ananas Vulcanized.')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'A6T004', N'Ananas Track 6 - LOW TOP - 70S WHITE', 1, CAST(999000 AS Decimal(18, 0)), N' Với cảm hứng từ Retro Sneakers và âm nhạc giai đoạn 1970s, Ananas Track 6 ra đời với danh hiệu là mẫu giày Cold Cement đầu tiên của Ananas - một thương hiệu giày Vulcanized. Chất liệu Storm Leather đáng giá "càn quét" toàn bộ bề mặt upper cùng những chi tiết thiết kế đặc trưng và mang nhiều ý nghĩa. Chắc rằng, Track 6 sẽ đem đến cho bạn sự tự nhiên thú vị như chính thông điệp bài hát Let it be của huyền thoại The Beatles gửi gắm. Màu all white chắc nhiều bạn sẽ thích.', N'New Arrival', 2, 1,  5, N'Low Top',  N'Gender: Unisex Size run: 35 – 46 Upper: Storm Leather Outsole: Rubber  Sản phẩm được Double Box khi giao hàng. Khuyến nghị chọn truesize hoặc +1 size (tùy form chân) so với giày Ananas Vulcanized.')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'A6T005', N'Ananas Track 6 - LOW TOP - TRIPLE WHITE ', 1, CAST(999000 AS Decimal(18, 0)), N' Với cảm hứng từ Retro Sneakers và âm nhạc giai đoạn 1970s, Ananas Track 6 ra đời với danh hiệu là mẫu giày Cold Cement đầu tiên của Ananas - một thương hiệu giày Vulcanized. Chất liệu Storm Leather đáng giá "càn quét" toàn bộ bề mặt upper cùng những chi tiết thiết kế đặc trưng và mang nhiều ý nghĩa. Chắc rằng, Track 6 sẽ đem đến cho bạn sự tự nhiên thú vị như chính thông điệp bài hát Let it be của huyền thoại The Beatles gửi gắm. Màu all white chắc nhiều bạn sẽ thích.', N'New Arrival',  2, 1,  5, N'Low Top',  N'Gender: Unisex Size run: 35 – 46 Upper: Storm Leather Outsole: Rubber  Sản phẩm được Double Box khi giao hàng. Khuyến nghị chọn truesize hoặc +1 size (tùy form chân) so với giày Ananas Vulcanized.')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'A6T006', N'Ananas Track 6 - LOW TOP - Tripple Black', 1, CAST(999000 AS Decimal(18, 0)), N'Với cảm hứng từ Retro Sneakers và âm nhạc giai đoạn 1970s, Ananas Track 6 ra đời với danh hiệu là mẫu giày Cold Cement đầu tiên của Ananas - một thương hiệu giày Vulcanized. Chất liệu Storm Leather đáng giá "càn quét" toàn bộ bề mặt upper cùng những chi tiết thiết kế đặc trưng và mang nhiều ý nghĩa. Chắc rắng, Track 6 sẽ đem đến cho bạn sự tự nhiên thú vị như chính thông điệp bài hát Let it be của huyền thoại The Beatles gửi gắm. Màu all black huyền bí luôn có mặt trong danh sách best seller.', N'New Arrival',  2, 1, 2, N'Low Top',  N'Gender: Unisex Size run: 35 – 46 Upper: Storm Leather Outsole: Rubber  Sản phẩm được Double Box khi giao hàng. Khuyến nghị chọn truesize hoặc +1 size (tùy form chân) so với giày Ananas Vulcanized.')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'A6T007', N'Ananas Track 6 - LOW TOP - DUSTY BLUE', 1, CAST(999000 AS Decimal(18, 0)), N' Với cảm hứng từ Retro Sneakers và âm nhạc giai đoạn 1970s, Ananas Track 6 ra đời với danh hiệu là mẫu giày Cold Cement đầu tiên của Ananas - một thương hiệu giày Vulcanized. Chất liệu Storm Leather đáng giá "càn quét" toàn bộ bề mặt upper cùng những chi tiết thiết kế đặc trưng và mang nhiều ý nghĩa. Chắc rằng, Track 6 sẽ đem đến cho bạn sự tự nhiên thú vị như chính thông điệp bài hát Let it be của huyền thoại The Beatles gửi gắm. Màu all white chắc nhiều bạn sẽ thích.', N'New Arrival', 2, 1, 5, N'Low Top',  N'Gender: Unisex Size run: 35 – 46 Upper: Storm Leather Outsole: Rubber  Sản phẩm được Double Box khi giao hàng. Khuyến nghị chọn truesize hoặc +1 size (tùy form chân) so với giày Ananas Vulcanized.')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'A6T008', N'Ananas Track 6 - LOW TOP - NARCISSUEDE', 1, CAST(999000 AS Decimal(18, 0)), N' Với cảm hứng từ Retro Sneakers và âm nhạc giai đoạn 1970s, Ananas Track 6 ra đời với danh hiệu là mẫu giày Cold Cement đầu tiên của Ananas - một thương hiệu giày Vulcanized. Chất liệu Storm Leather đáng giá "càn quét" toàn bộ bề mặt upper cùng những chi tiết thiết kế đặc trưng và mang nhiều ý nghĩa. Chắc rằng, Track 6 sẽ đem đến cho bạn sự tự nhiên thú vị như chính thông điệp bài hát Let it be của huyền thoại The Beatles gửi gắm. Màu all white chắc nhiều bạn sẽ thích.', N'New Arrival', 2, 1, 5, N'Low Top', N'Gender: Unisex Size run: 35 – 46 Upper: Storm Leather Outsole: Rubber  Sản phẩm được Double Box khi giao hàng. Khuyến nghị chọn truesize hoặc +1 size (tùy form chân) so với giày Ananas Vulcanized.')
--
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'AV00175', N'VINTAS LANDFORMS - LOW TOP - MARMALADE', 1, CAST(199000 AS Decimal(18, 0)), N'Sales sập sàn ', N'Best Seller', 2, null, 10, N'Low Top', N'Gender: Unisex Size run: 35 – 46 Upper: Storm Leather Outsole: Rubber  Sản phẩm được Double Box khi giao hàng. Khuyến nghị chọn truesize hoặc +1 size (tùy form chân) so với giày VINTAS LANDFORMS.')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'AV00176', N'VINTAS LANDFORMS - LOW TOP - RAIN DRUM', 1, CAST(199000 AS Decimal(18, 0)), N'Sales sập sàn ', N'Best Seller', 2, null, 10, N'Low Top', N'Gender: Unisex Size run: 35 – 46 Upper: Storm Leather Outsole: Rubber  Sản phẩm được Double Box khi giao hàng. Khuyến nghị chọn truesize hoặc +1 size (tùy form chân) so với giày VINTAS LANDFORMS.')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'AV00177', N'VINTAS LANDFORMS - LOW TOP - GREEN MOSS', 1, CAST(199000 AS Decimal(18, 0)), N'Sales sập sàn ', N'Best Seller', 2, null, 20, N'Low Top', N'Gender: Unisex Size run: 35 – 46 Upper: Storm Leather Outsole: Rubber  Sản phẩm được Double Box khi giao hàng. Khuyến nghị chọn truesize hoặc +1 size (tùy form chân) so với giày VINTAS LANDFORMS.')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'A61079', N'BASAS MONO - HIGH TOP - ALL DARK GREY', 1, CAST(499000 AS Decimal(18, 0)), N'Dáng giày high top cá tính, kết hợp upper và phần đế "ton-sur-ton" đã giúp "Basas Mono" Pack trở nên thu hút. Đôi giày này hứa hẹn sẽ là một điểm nhấn thú vị cho mọi set đồ của bạn. ', N'Best Seller', 2, null, 20, N'Low Top', N'Gender: Unisex Size run: 35 – 46 Upper: Storm Leather Outsole: Rubber  Sản phẩm được Double Box khi giao hàng. Khuyến nghị chọn truesize hoặc +1 size (tùy form chân).')

/**/
/*nửa trên*/
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'AGT0013', N'GRAPHIC TEE - LUCKY LUKE COMICS - CAVIAR BLACK', 2, CAST(365000 AS Decimal(18, 0)), N'Những chiếc áo Ananas Graphic Tee có phom dáng thoải mái, rộng linh hoạt được kết hợp cùng hoạ tiết lấy cảm hứng từ bộ truyện tuổi thơ Lucky Luke. Đây sẽ là một mảnh ghép cho những outfit thú vị, dù đủ bộ hay mặc riêng lẻ vẫn khẳng định cá tính riêng biệt, ghi dấu ấn cho lần hợp tác quốc tế đầu tiên của Ananas.', N'New Arrival', 1, 2,  2, N'Oversize',  N'Gender – /Unisex/ Hình in – /Lucky Luke Comics/ Chất liệu – /100% Cotton/ Size – /S – M – L – XL/ Màu sắc: Caviar Black In 2D')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'ASW1004', N'Lucky Luke Typo Sweatshirt - Storm', 2, CAST(500000 AS Decimal(18, 0)), N'Chiếc Sweatshirt nằm trong dự án hợp tác đặc biệt giữa Ananas x Lucky Luke. Với chất liệu nỉ dày dặn cho dịp cuối năm, phom áo oversize thoải mái pha trộn cùng hình thêu graphic độc đáo mà bắt mắt. Vừa đơn giản như outfit thường ngày nhưng vẫn mang điểm nhấn riêng. Khuyến khích mua cho đủ cả bộ sưu tập.', N'New Arrival',  2, 2,  4, N'Oversize',  N'Gender: Unisex Form: Oversize Size run: S – M – L – XL Chất liệu: 100% Cotton Hình thêu 2D màu sắc, chìm nổi tương phản')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'AGT0014', N'GRAPHIC TEE - LUCKY LUKE COMICS - CAVIAR BLACK', 2, CAST(365000 AS Decimal(18, 0)), N'Những chiếc áo Ananas Graphic Tee có phom dáng thoải mái, rộng linh hoạt được kết hợp cùng hoạ tiết lấy cảm hứng từ bộ truyện tuổi thơ Lucky Luke. Đây sẽ là một mảnh ghép cho những outfit thú vị, dù đủ bộ hay mặc riêng lẻ vẫn khẳng định cá tính riêng biệt, ghi dấu ấn cho lần hợp tác quốc tế đầu tiên của Ananas.', N'New Arrival', 1, null,  2, N'Oversize', N'Gender – /Unisex/ Hình in – /Lucky Luke Comics/ Chất liệu – /100% Cotton/ Size – /S – M – L – XL/ Màu sắc: Caviar Black In 2D')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'AGT0015', N'GRAPHIC TEE - LUCKY LUKE COMICS - CAVIAR BLACK', 2, CAST(365000 AS Decimal(18, 0)), N'Những chiếc áo Ananas Graphic Tee có phom dáng thoải mái, rộng linh hoạt được kết hợp cùng hoạ tiết lấy cảm hứng từ bộ truyện tuổi thơ Lucky Luke. Đây sẽ là một mảnh ghép cho những outfit thú vị, dù đủ bộ hay mặc riêng lẻ vẫn khẳng định cá tính riêng biệt, ghi dấu ấn cho lần hợp tác quốc tế đầu tiên của Ananas.', N'New Arrival',  1, null,  2, N'Oversize',  N'Gender – /Unisex/ Hình in – /Lucky Luke Comics/ Chất liệu – /100% Cotton/ Size – /S – M – L – XL/ Màu sắc: Caviar Black In 2D')

/*phụ kiện*/
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'AHCLLS04', N'High Crew Socks - LL Elements - Chestnut', 3, CAST(105000 AS Decimal(18, 0)), N'Vớ cổ cao với điểm nhấn ở má ngoài bằng những đặc trưng của vùng viễn Tây. Hình thêu đơn giản, phối đồ gì cũng hợp.', N'New Arrival', 1, null,10, N'', N'Gender – /Unisex/ Họa tiết – /Lucky Luke Elements/ Thành phần – 80% cotton, 15% poly, 5% Spandex Thêu 2D đơn giản')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'AHCLLS05', N'Kính Crew Socks ', 3, CAST(105000 AS Decimal(18, 0)), N'Những đặc trưng của vùng viễn Tây. Thiết kế đơn giản, phối đồ gì cũng hợp.', N'Best Seller', 1, null,  10, N'', N'Gender – /Unisex/ ')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'AHCLLS06', N'Túi Crew Socks ', 3, CAST(105000 AS Decimal(18, 0)), N'Những đặc trưng của vùng viễn Tây. Thiết kế đơn giản, phối đồ gì cũng hợp.', N'Best Seller',  1, null, 10, N'',  N'Gender – /Unisex/ ')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'AHCLLS07', N'BUCKET HAT - ANANAS TYPO BOX - BLACK ', 3, CAST(105000 AS Decimal(18, 0)), N'Những đặc trưng của vùng viễn Tây. Thiết kế đơn giản, phối đồ gì cũng hợp.', N'New Arrival',  1, null, 10, N'',  N'Chiếc Bucket Hat màu Black với hình thêu Ananas Typo Box nổi bật. Thiết kế cổ điển và đơn giản khiến nó trở thành một must-have-item đem lại tính ứng dụng cao trong mọi trường hợp. ')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'AHCLLS08', N'BLANK SHOELACES - ANTIQUE BRONZE ', 3, CAST(105000 AS Decimal(18, 0)), N'Dây giày bản dẹp, đặc biệt nổi bật ở phần màu sắc. Phù hợp để tạo điểm nhấn mới mẻ, vừa phá cách trên chính đôi giày của bạn.', N'New Arrival',  1, null, 10, N'',  N'Gender – /Unisex/ ')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'AHCLLS09', N'Ví Crew Socks ', 3, CAST(105000 AS Decimal(18, 0)), N'Những đặc trưng của vùng viễn Tây. Thiết kế đơn giản, phối đồ gì cũng hợp.', N'New Arrival', 1, null, 10, N'', N'Gender – /Unisex/ ')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'AHCLLS010', N'STRIPES SHOELACES - PRIDE FLAG ', 3, CAST(105000 AS Decimal(18, 0)), N'Dây giày dẹp có phối trộn 6 dải màu "kì lạ". Một sự lựa chọn phá cách, cực kỳ độc đáo cho những bạn mong muốn thể hiện cá tính riêng biệt, chắc chắn sẽ thêm phần sắc màu khi kết hợp với bất cứ đôi giày nào của bạn.', N'New Arrival',  1, null, 10, N'', N'Chất liệu – /100% Polyester/Hoạ tiết sọc 6 màu/Bản dẹp 8mm/Dệt đan xen ')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'AHCLLS011', N'CREW SOCKS - ANANAS TYPO - WHITE ', 3, CAST(105000 AS Decimal(18, 0)), N'Vớ cổ cao, cao hơn vớ cổ trung một khúc, tăng phần cổ chân tạo độ ấm vừa phải. Thích hợp mang cho mọi tình huống của cuộc sống.', N'New Arrival', 1, null, 10, N'', N'Gender – /Unisex/Họa tiết – /Ananas Typo/Thành phần – /95% cotton, 5% Spandex/')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'ABH002', N'BUCKET HAT - GO SKATE - BEIGE', 3, CAST(105000 AS Decimal(18, 0)), N'Chiếc Bucket Hat với phối màu Beige trung tính, thiết kế đơn giản nhằm thể hiện artwork màu sắc, nhấn mạnh thông điệp "Go Skate" mang nhiều năng lượng tích cực, thể hiện cái tôi riêng biệt. Phù hợp cho những người trẻ yêu thích sự va chạm, mong muốn vượt các thử thách bằng chính khả năng của mình.', N'Best Seller', 1, null, 10, N'', N'Gender – /Unisex/Họa tiết – /Ananas Typo/Thành phần – /95% cotton, 5% Spandex/')

/**/
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'A610441', N'Vintas Yesterday - High Top - Moonstruck Pirate', 1, CAST(550000 AS Decimal(18, 0)), N'Sử dụng đồng thời chất liệu da Suede, da Nappa và vải Canvas, ', N'New Arrival', 1,3, 4, N'High Top', N'– Gender: Unisex – Size run: 35 – 46 – Upper: Canvas / Leather / Suede – Outsole: Rubber')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'A610442', N'Vintas Yesterday - High Top - RUSTIC', 1, CAST(550000 AS Decimal(18, 0)), N'Sử dụng đồng thời chất liệu da Suede, da Nappa và vải Canvas, ', N'New Arrival', 1,3, 4, N'High Top', N'– Gender: Unisex – Size run: 35 – 46 – Upper: Canvas / Leather / Suede – Outsole: Rubber')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'A610443', N'Vintas Yesterday - High Top - VAPOROUS GRAY', 1, CAST(550000 AS Decimal(18, 0)), N'Sử dụng đồng thời chất liệu da Suede, da Nappa và vải Canvas, ', N'New Arrival', 1,3, 4, N'High Top', N'– Gender: Unisex – Size run: 35 – 46 – Upper: Canvas / Leather / Suede – Outsole: Rubber')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'A610444', N'Vintas Yesterday - High Top - SULPHUR', 1, CAST(550000 AS Decimal(18, 0)), N'Sử dụng đồng thời chất liệu da Suede, da Nappa và vải Canvas, ', N'New Arrival', 1,3, 4, N'High Top', N'– Gender: Unisex – Size run: 35 – 46 – Upper: Canvas / Leather / Suede – Outsole: Rubber')

/**/
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'A611011', N'VINTAS MISTER NE - HIGH TOP - CHOCOLATE BROWN', 1, CAST(610000 AS Decimal(18, 0)), N'Công thức pha trộn từ hai chất liệu vải và da lộn đặc trưng, điều thường thấy ở bộ Vintas Mister. Sự kết hợp mạnh mẽ tạo nên nét cổ điển, hoài niệm. Chắc chắn là sự lựa chọn ', N'New Arrival', 0, 4, 5, N'High Top',  N'Gender: Unisex Size run: 35 – 46 Upper: Canvas/Suede Outsole: Rubber')
INSERT [dbo].[Products] ([ProductCode], [ProductName], [CategoryID], [Price], [Description], [Status], [Gender], [CollectionID], [Quantity], [Style],[DetailProduct]) 
VALUES (N'A611012', N'VINTAS MISTER - LOW TOP - NARCISSUEDE', 1, CAST(610000 AS Decimal(18, 0)), N'Công thức pha trộn từ hai chất liệu vải và da lộn đặc trưng, điều thường thấy ở bộ Vintas Mister. Sự kết hợp mạnh mẽ tạo nên nét cổ điển, hoài niệm. Chắc chắn là sự lựa chọn ', N'New Arrival', 0, 4, 5, N'High Top',  N'Gender: Unisex Size run: 35 – 46 Upper: Canvas/Suede Outsole: Rubber')

/**/
/*Images*/
--giày
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'A6T003', N'images/BOTANICALGARDEN.png', N'images/VINTAS AUNTER - LOW TOP - BOTANICAL GARDEN2.png',N'images/VINTAS AUNTER - LOW TOP - BOTANICAL GARDEN3.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'A6T004', N'images/TRACK6OG-LOWTOP-70SWHITE.png', N'images/TRACK 6 OG - LOW TOP - 70S WHITE2.png',N'images/TRACK 6 OG - LOW TOP - 70S WHITE3.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'A6T005', N'images/TRACK6TRIPLEWHITE-LOWTOP-WHITE.png', N'images/TRACK 6 TRIPLE WHITE - LOW TOP - WHITE2.png',N'images/TRACK 6 TRIPLE WHITE - LOW TOP - WHITE3.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'A6T006', N'images/pro_track6_A6T003_1.jpg', N'images/TRACK 6 TRIPLE BLACK - LOW TOP - BLACK2.png',N'images/TRACK 6 TRIPLE BLACK - LOW TOP - BLACK3.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'A6T007', N'images/VINTASAUNTER-LOWTOP-DUSTYBLUE.png', N'images/VINTAS AUNTER - LOW TOP - DUSTY BLUE2.png',N'images/VINTAS AUNTER - LOW TOP - DUSTY BLUE3.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'A6T008', N'images/VINTASAUNTER-LOWTOP-SOYBEAN.png', N'images/VINTAS AUNTER - LOW TOP - SOYBEAN2.png',N'images/VINTAS AUNTER - LOW TOP - SOYBEAN3.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'AV00175', N'images/VINTASLANDFORMS-LOWTOP-MARMALADE.png', N'images/VINTAS LANDFORMS - LOW TOP - MARMALADE2.png',N'images/VINTAS LANDFORMS - LOW TOP - MARMALADE3.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'AV00176', N'images/VINTASLANDFORMS-LOW TOP-RAIN DRUM.png', N'images/VINTAS LANDFORMS - LOW TOP - RAIN DRUM2.png',N'images/VINTAS LANDFORMS - LOW TOP - RAIN DRUM3.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'AV00177', N'images/VINTASLANDFORMS-LOWTOP-GREEN MOSS.png', N'images/VINTAS LANDFORMS - LOW TOP - GREEN MOSS2.png',N'images/VINTAS LANDFORMS - LOW TOP - GREEN MOSS3.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'A61079', N'images/pro_basas_A61079_1.jpg', N'images/pro_basas_A61079_2.jpg',N'images/pro_basas_A61079_3.jpg')

--áo
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'AGT0013', N'images/AGT0013_1.jpg', N'images/AGT0013_1.jpg',N'images/AGT0013_1.jpg')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'ASW1004', N'images/pro_ASW1004_1_1.jpg', N'images/pro_ASW1004_1_1.jpg',N'images/pro_ASW1004_1_1.jpg.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'AGT0014', N'images/product_9.png', N'images/product_9.png',N'images/product_9.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'AGT0015', N'images/product_10.png', N'images/product_10.png.png',N'images/product_10.png.png')
--phụ kiện
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3])
VALUES (N'AHCLLS04', N'images/pro_sock_AHCLLS04_1.jpg', N'images/pro_sock_AHCLLS04_1.jpg',N'images/pro_sock_AHCLLS04_1.jpg.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'AHCLLS05', N'images/product_6.png', N'images/product_6.png',N'images/product_6.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'AHCLLS06', N'images/product_4.png', N'images/product_4.png',N'images/product_4.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'AHCLLS07', N'images/BUCKETHAT-ANANASTYPOBOX-BLACK.png', N'images/BUCKET HAT - ANANAS TYPO BOX - BLACK2.png',N'images/BUCKET HAT - ANANAS TYPO BOX - BLACK3.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'AHCLLS08', N'images/BLANKSHOELACES-ANTIQUEBRONZE.png', N'images/BLANK SHOELACES - ANTIQUE BRONZE2.png',N'images/BLANK SHOELACES - ANTIQUE BRONZE3.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'AHCLLS09', N'images/product_8.png', N'images/product_8.png',N'images/product_8.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'AHCLLS010', N'images/STRIPESSHOELACES-PRIDEFLAG.png', N'images/STRIPES SHOELACES - PRIDE FLAG2.png',N'images/STRIPES SHOELACES - PRIDE FLAG3.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'AHCLLS011', N'images/CREWSOCKS-ANANASTYPO-WHITE.png', N'images/CREWSOCKS-ANANASTYPO-WHITE.png',N'images/CREWSOCKS-ANANASTYPO-WHITE.png')
--
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'ABH002', N'images/pro_ABH002_1-2.jpg', N'images/pro_ABH002_2.jpg',N'images/pro_ABH002_3.jpg')

--mister
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'A611011', N'images/pro_A61101_1_1.jpg', N'images/VINTAS MISTER NE - HIGH TOP - CHOCOLATE BROWN2.png',N'images/VINTAS MISTER NE - HIGH TOP - CHOCOLATE BROWN2.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'A611012', N'images/VINTASMISTER-LOWTOP-NARCISSUEDE.png', N'images/VINTAS MISTER - LOW TOP - NARCISSUEDE2.png',N'images/VINTAS MISTER - LOW TOP - NARCISSUEDE3.png')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'A610441', N'images/Pro_AV00192_1.jpg', N'images/Pro_AV00192_2.jpg',N'images/Pro_AV00192_3.jpg')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'A610442', N'images/pro_AV00136_1.jpg', N'images/pro_AV00136_2.jpg',N'images/pro_AV00136.jpg')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'A610443', N'images/pro_AV00133_1-1.jpg', N'images/pro_AV00133_2.jpg',N'images/pro_AV00133_3.jpg')
INSERT [dbo].[ProductImages] ([ProductCode], [image1], [image2], [image3]) 
VALUES (N'A610444', N'images/pro_A61107_1.jpg', N'images/pro_A61107_2.jpg',N'images/pro_A61107_3.jpg')

/*Size*/
--giày
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'A6T003', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'A6T004', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'A6T005', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'A6T006', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'A6T007', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'A611011', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'A611012', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'A610441', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'AV00175', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'AV00176', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'AV00177', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'A610441', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'A610442', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'A610443', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'A610444', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'A61079', N'35',N'36',N'37',N'38',N'39',N'40',N'41',N'42',N'43',N'44',N'45',N'46')

--phụ kiện
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'A6T008', N'FREE',null,null,null,null,null,null,null,null,null,null,null)
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'AHCLLS04', N'FREE',null,null,null,null,null,null,null,null,null,null,null)
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'AHCLLS05', N'FREE',null,null,null,null,null,null,null,null,null,null,null)
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'AHCLLS06', N'FREE',null,null,null,null,null,null,null,null,null,null,null)
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'AHCLLS07', N'FREE',null,null,null,null,null,null,null,null,null,null,null)
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'AHCLLS08', N'FREE',null,null,null,null,null,null,null,null,null,null,null)
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'AHCLLS09', N'FREE',null,null,null,null,null,null,null,null,null,null,null)
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'AHCLLS010', N'FREE',null,null,null,null,null,null,null,null,null,null,null)
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'AHCLLS011', N'FREE',null,null,null,null,null,null,null,null,null,null,null)
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'ABH002', N'FREE',null,null,null,null,null,null,null,null,null,null,null)

--áo
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'AGT0013', N'M',N'S',N'L',null,null,null,null,null,null,null,null,null)
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'ASW1004', N'M',N'S',N'L',null,null,null,null,null,null,null,null,null)
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'AGT0014', N'M',N'S',N'L',null,null,null,null,null,null,null,null,null)
INSERT [dbo].[ProductSize] ([ProductCode], [size1], [size2], [size3],[size4],[size5],[size6],[size7],[size8],[size9],[size10],[size11],[size12]) 
VALUES (N'AGT0015', N'M',N'S',N'L',null,null,null,null,null,null,null,null,null)
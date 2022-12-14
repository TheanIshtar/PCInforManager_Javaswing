USE [master]
GO
/****** Object:  Database [QLPC]    Script Date: 8/19/2022 11:41:46 PM ******/
CREATE DATABASE [QLPC]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLPC', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\QLPC.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLPC_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\QLPC_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QLPC] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLPC].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLPC] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLPC] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLPC] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLPC] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLPC] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLPC] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QLPC] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLPC] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLPC] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLPC] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLPC] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLPC] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLPC] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLPC] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLPC] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QLPC] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLPC] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLPC] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLPC] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLPC] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLPC] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLPC] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLPC] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLPC] SET  MULTI_USER 
GO
ALTER DATABASE [QLPC] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLPC] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLPC] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLPC] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLPC] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLPC] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QLPC] SET QUERY_STORE = OFF
GO
USE [QLPC]
GO
/****** Object:  Table [dbo].[HANG]    Script Date: 8/19/2022 11:41:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HANG](
	[MAHANG] [varchar](12) NOT NULL,
	[TENHANG] [varchar](9) NULL,
PRIMARY KEY CLUSTERED 
(
	[MAHANG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SANPHAM]    Script Date: 8/19/2022 11:41:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SANPHAM](
	[MASANPHAM] [varchar](9) NOT NULL,
	[MAHANG] [varchar](12) NOT NULL,
	[TENSANPHAM] [varchar](30) NULL,
	[HINHANH] [varchar](50) NULL,
	[HEDIEUHANH] [varchar](50) NULL,
	[CPU] [nvarchar](50) NULL,
	[CARDDOHOA] [nvarchar](50) NULL,
	[PIN] [varchar](50) NULL,
	[TRONGLUONG] [float] NULL,
	[MANHINH] [varchar](50) NULL,
	[RAM] [varchar](50) NULL,
	[ODIA] [nvarchar](50) NULL,
	[SOLUONG] [int] NULL,
	[GIA] [int] NULL,
	[NOISANXUAT] [nvarchar](50) NULL,
	[MAUSAC] [nvarchar](20) NULL,
	[TENTAIKHOAN] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MASANPHAM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TAIKHOAN]    Script Date: 8/19/2022 11:41:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TAIKHOAN](
	[TENTAIKHOAN] [nvarchar](50) NOT NULL,
	[TENDANGNHAP] [varchar](12) NOT NULL,
	[MATKHAU] [varchar](8) NOT NULL,
	[EMAIL] [varchar](50) NULL,
	[CHUCVU] [nvarchar](20) NULL,
	[TRANGTHAI] [bit] NULL,
	[QRCODE] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[TENDANGNHAP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[SANPHAM]  WITH CHECK ADD FOREIGN KEY([MAHANG])
REFERENCES [dbo].[HANG] ([MAHANG])
GO
USE [master]
GO
ALTER DATABASE [QLPC] SET  READ_WRITE 
GO

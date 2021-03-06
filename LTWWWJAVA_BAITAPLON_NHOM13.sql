USE [dataWeb7]
GO
ALTER TABLE [dbo].[SanPham] DROP CONSTRAINT [FKd5h0l020nng0vtc15xuflnlao]
GO
ALTER TABLE [dbo].[NhanVien] DROP CONSTRAINT [FKmwcvxjdkbt7a4euofa06badva]
GO
ALTER TABLE [dbo].[NhaCungCap] DROP CONSTRAINT [FK1sv43bqalof3eq10y28wtc8bh]
GO
ALTER TABLE [dbo].[KhachHang] DROP CONSTRAINT [FK9frs0p1jr9qtacnnie16w6ksj]
GO
ALTER TABLE [dbo].[HoaDon] DROP CONSTRAINT [FKt2e7s2wj123d09u2w7hyp7ctk]
GO
ALTER TABLE [dbo].[ChiTietHoaDon] DROP CONSTRAINT [FKejf6wxmnfy005jit9otqmoohs]
GO
ALTER TABLE [dbo].[ChiTietHoaDon] DROP CONSTRAINT [FK10x5nsly7wuexlot0miqv2nan]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 7/4/2020 6:28:27 PM ******/
DROP TABLE [dbo].[TaiKhoan]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 7/4/2020 6:28:27 PM ******/
DROP TABLE [dbo].[SanPham]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 7/4/2020 6:28:27 PM ******/
DROP TABLE [dbo].[NhanVien]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 7/4/2020 6:28:27 PM ******/
DROP TABLE [dbo].[NhaCungCap]
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 7/4/2020 6:28:27 PM ******/
DROP TABLE [dbo].[LoaiSanPham]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 7/4/2020 6:28:27 PM ******/
DROP TABLE [dbo].[KhachHang]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 7/4/2020 6:28:27 PM ******/
DROP TABLE [dbo].[HoaDon]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 7/4/2020 6:28:27 PM ******/
DROP TABLE [dbo].[ChiTietHoaDon]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 7/4/2020 6:28:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[idCTHD] [numeric](19, 0) NOT NULL,
	[diaChiGiaoDich] [varchar](255) NULL,
	[soLuongMua] [int] NOT NULL,
	[idHD] [numeric](19, 0) NOT NULL,
	[idSP] [numeric](19, 0) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idCTHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 7/4/2020 6:28:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HoaDon](
	[idMaHD] [numeric](19, 0) NOT NULL,
	[ngayLapHoaDon] [datetime] NULL,
	[kh_id] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idMaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 7/4/2020 6:28:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[idKH] [varchar](255) NOT NULL,
	[diaChi] [varchar](255) NULL,
	[email] [varchar](255) NULL,
	[gioiTinh] [varchar](255) NULL,
	[ngaySinh] [varchar](255) NULL,
	[sdt] [varchar](255) NULL,
	[tenKH] [varchar](255) NULL,
	[tk_taiKhoan] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 7/4/2020 6:28:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[idLoaiSP] [numeric](19, 0) NOT NULL,
	[tenLoaiSP] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idLoaiSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 7/4/2020 6:28:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[idNCC] [numeric](19, 0) NOT NULL,
	[tenNCC] [varchar](255) NULL,
	[xuatXuNCC] [varchar](255) NULL,
	[sp_id] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[idNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 7/4/2020 6:28:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[idNV] [varchar](255) NOT NULL,
	[diaChi] [varchar](255) NULL,
	[email] [varchar](255) NULL,
	[gioiTinh] [varchar](255) NULL,
	[sdt] [varchar](255) NULL,
	[tenNV] [varchar](255) NULL,
	[tk_taiKhoan] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 7/4/2020 6:28:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SanPham](
	[idSP] [numeric](19, 0) NOT NULL,
	[giaSP] [float] NOT NULL,
	[moTa] [varchar](255) NULL,
	[namSXSP] [datetime] NULL,
	[soLuong] [int] NOT NULL,
	[tenSP] [varchar](255) NULL,
	[thoiGianBaoHanh] [datetime] NULL,
	[thongSoKiThuat] [varchar](255) NULL,
	[url] [varchar](255) NULL,
	[id_LoaiSP] [numeric](19, 0) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 7/4/2020 6:28:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[taiKhoan] [varchar](255) NOT NULL,
	[matKhau] [varchar](255) NULL,
	[quyenHan] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[taiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[ChiTietHoaDon] ([idCTHD], [diaChiGiaoDich], [soLuongMua], [idHD], [idSP]) VALUES (CAST(98 AS Numeric(19, 0)), N'TP HCM', 1, CAST(675 AS Numeric(19, 0)), CAST(1112 AS Numeric(19, 0)))
INSERT [dbo].[ChiTietHoaDon] ([idCTHD], [diaChiGiaoDich], [soLuongMua], [idHD], [idSP]) VALUES (CAST(281 AS Numeric(19, 0)), N'TP HCM', 1, CAST(467 AS Numeric(19, 0)), CAST(1002 AS Numeric(19, 0)))
INSERT [dbo].[HoaDon] ([idMaHD], [ngayLapHoaDon], [kh_id]) VALUES (CAST(467 AS Numeric(19, 0)), CAST(N'2020-07-04 18:24:46.800' AS DateTime), N'90')
INSERT [dbo].[HoaDon] ([idMaHD], [ngayLapHoaDon], [kh_id]) VALUES (CAST(675 AS Numeric(19, 0)), CAST(N'2020-07-04 18:25:04.523' AS DateTime), N'90')
INSERT [dbo].[KhachHang] ([idKH], [diaChi], [email], [gioiTinh], [ngaySinh], [sdt], [tenKH], [tk_taiKhoan]) VALUES (N'22', N'An Giang', N'daiviet1023@gmail.com', N'Nam', N'1999-08-27', N'4254', N'Dai', N'dai')
INSERT [dbo].[KhachHang] ([idKH], [diaChi], [email], [gioiTinh], [ngaySinh], [sdt], [tenKH], [tk_taiKhoan]) VALUES (N'90', N'TP HCM', N'daiviet1023@gmail.com', N'Nam', N'1999-06-29', N'4254', N'Hau', N'hau')
INSERT [dbo].[LoaiSanPham] ([idLoaiSP], [tenLoaiSP]) VALUES (CAST(1 AS Numeric(19, 0)), N'Camera')
INSERT [dbo].[LoaiSanPham] ([idLoaiSP], [tenLoaiSP]) VALUES (CAST(2 AS Numeric(19, 0)), N'SmartHome')
INSERT [dbo].[LoaiSanPham] ([idLoaiSP], [tenLoaiSP]) VALUES (CAST(3 AS Numeric(19, 0)), N'SmartKey')
INSERT [dbo].[NhaCungCap] ([idNCC], [tenNCC], [xuatXuNCC], [sp_id]) VALUES (CAST(1001 AS Numeric(19, 0)), N'Â EZVIZ', N'Chines', CAST(1001 AS Numeric(19, 0)))
INSERT [dbo].[NhaCungCap] ([idNCC], [tenNCC], [xuatXuNCC], [sp_id]) VALUES (CAST(1002 AS Numeric(19, 0)), N'HIKVISION', N'japan', CAST(1002 AS Numeric(19, 0)))
INSERT [dbo].[NhaCungCap] ([idNCC], [tenNCC], [xuatXuNCC], [sp_id]) VALUES (CAST(1003 AS Numeric(19, 0)), N'PTA', N'Chines', CAST(1003 AS Numeric(19, 0)))
INSERT [dbo].[NhaCungCap] ([idNCC], [tenNCC], [xuatXuNCC], [sp_id]) VALUES (CAST(1004 AS Numeric(19, 0)), N'KBVISION', N'japan', CAST(1004 AS Numeric(19, 0)))
INSERT [dbo].[NhaCungCap] ([idNCC], [tenNCC], [xuatXuNCC], [sp_id]) VALUES (CAST(1005 AS Numeric(19, 0)), N'Â EZVIZ', N'Chines', CAST(1005 AS Numeric(19, 0)))
INSERT [dbo].[NhaCungCap] ([idNCC], [tenNCC], [xuatXuNCC], [sp_id]) VALUES (CAST(1006 AS Numeric(19, 0)), N'HIKVISION', N'japan', CAST(1006 AS Numeric(19, 0)))
INSERT [dbo].[NhaCungCap] ([idNCC], [tenNCC], [xuatXuNCC], [sp_id]) VALUES (CAST(1007 AS Numeric(19, 0)), N'PTA', N'Chines', CAST(1007 AS Numeric(19, 0)))
INSERT [dbo].[NhaCungCap] ([idNCC], [tenNCC], [xuatXuNCC], [sp_id]) VALUES (CAST(1008 AS Numeric(19, 0)), N'Â EZVIZ', N'Chines', CAST(1008 AS Numeric(19, 0)))
INSERT [dbo].[NhaCungCap] ([idNCC], [tenNCC], [xuatXuNCC], [sp_id]) VALUES (CAST(1111 AS Numeric(19, 0)), N'AMOS', N'Chines', CAST(1111 AS Numeric(19, 0)))
INSERT [dbo].[NhaCungCap] ([idNCC], [tenNCC], [xuatXuNCC], [sp_id]) VALUES (CAST(1112 AS Numeric(19, 0)), N'KARASSN ', N'Chines', CAST(1112 AS Numeric(19, 0)))
INSERT [dbo].[NhaCungCap] ([idNCC], [tenNCC], [xuatXuNCC], [sp_id]) VALUES (CAST(1113 AS Numeric(19, 0)), N'KARASSN ', N'Chines', CAST(1113 AS Numeric(19, 0)))
INSERT [dbo].[NhaCungCap] ([idNCC], [tenNCC], [xuatXuNCC], [sp_id]) VALUES (CAST(1114 AS Numeric(19, 0)), N'AMOS', N'japan', CAST(1114 AS Numeric(19, 0)))
INSERT [dbo].[NhaCungCap] ([idNCC], [tenNCC], [xuatXuNCC], [sp_id]) VALUES (CAST(3333 AS Numeric(19, 0)), N'TTES', N'Chines', CAST(3333 AS Numeric(19, 0)))
INSERT [dbo].[NhaCungCap] ([idNCC], [tenNCC], [xuatXuNCC], [sp_id]) VALUES (CAST(3334 AS Numeric(19, 0)), N'DDF', N'india', CAST(3334 AS Numeric(19, 0)))
INSERT [dbo].[SanPham] ([idSP], [giaSP], [moTa], [namSXSP], [soLuong], [tenSP], [thoiGianBaoHanh], [thongSoKiThuat], [url], [id_LoaiSP]) VALUES (CAST(1001 AS Numeric(19, 0)), 790, N'Camera cam bien hong ngoai', CAST(N'2020-06-29 00:00:00.000' AS DateTime), 50, N'Camera IP Wifi EZVIZ C1C 1080P (CS-C1C-1D2WFR)', CAST(N'2020-08-02 00:00:00.000' AS DateTime), N'2.0 Megapixel', N'camera4.jpg', CAST(1 AS Numeric(19, 0)))
INSERT [dbo].[SanPham] ([idSP], [giaSP], [moTa], [namSXSP], [soLuong], [tenSP], [thoiGianBaoHanh], [thongSoKiThuat], [url], [id_LoaiSP]) VALUES (CAST(1002 AS Numeric(19, 0)), 4600000, N'Camera IP Cube  6MP', CAST(N'2020-06-29 00:00:00.000' AS DateTime), 7, N'Camera IP Cube 6MP Hikvision DS-2CD2463G0-IW', CAST(N'2020-08-09 00:00:00.000' AS DateTime), N'1/3â?³ Progressive Scan CMOS', N'camera12.jpg', CAST(1 AS Numeric(19, 0)))
INSERT [dbo].[SanPham] ([idSP], [giaSP], [moTa], [namSXSP], [soLuong], [tenSP], [thoiGianBaoHanh], [thongSoKiThuat], [url], [id_LoaiSP]) VALUES (CAST(1003 AS Numeric(19, 0)), 4600000, N'Camera IP Cube  6MP', CAST(N'2020-06-29 00:00:00.000' AS DateTime), 54, N'Camera 4in1 Dome 2MP KBVISION KX-C2004CA)', CAST(N'2020-08-09 00:00:00.000' AS DateTime), N'1.0 Megapixel Chip CMOS', N'camera19.jpg', CAST(1 AS Numeric(19, 0)))
INSERT [dbo].[SanPham] ([idSP], [giaSP], [moTa], [namSXSP], [soLuong], [tenSP], [thoiGianBaoHanh], [thongSoKiThuat], [url], [id_LoaiSP]) VALUES (CAST(1004 AS Numeric(19, 0)), 3360333, N' Day/Night(ICR), 3DNR, AWB,AGC,BL Â Camera 4 in 1 (CVI, TVI,AHD,Analog)', CAST(N'2020-06-29 00:00:00.000' AS DateTime), 17, N'Camera 4in1 Dome 2MP KBVISION KX-C2004CA)', CAST(N'2020-09-06 00:00:00.000' AS DateTime), N'1/3â?³ 1.3 Megapixel Aptina 1.3 Megapixel Chip CMOS', N'camera17.jpg', CAST(1 AS Numeric(19, 0)))
INSERT [dbo].[SanPham] ([idSP], [giaSP], [moTa], [namSXSP], [soLuong], [tenSP], [thoiGianBaoHanh], [thongSoKiThuat], [url], [id_LoaiSP]) VALUES (CAST(1005 AS Numeric(19, 0)), 100000, N'Camera IP Cube  6MP', CAST(N'2020-06-29 00:00:00.000' AS DateTime), 86, N'Camera X3350', CAST(N'2020-08-09 00:00:00.000' AS DateTime), N'1/3â?³ 1.3 Megapixel Aptina 1.3 Megapixel Chip CMOS', N'camera20.jpg', CAST(1 AS Numeric(19, 0)))
INSERT [dbo].[SanPham] ([idSP], [giaSP], [moTa], [namSXSP], [soLuong], [tenSP], [thoiGianBaoHanh], [thongSoKiThuat], [url], [id_LoaiSP]) VALUES (CAST(1006 AS Numeric(19, 0)), 454545, N' Day/Night(ICR), 3DNR, AWB,AGC,BL Â Camera 4 in 1 (CVI, TVI,AHD,Analog)', CAST(N'2020-06-29 00:00:00.000' AS DateTime), 38, N'Camera X3780', CAST(N'2020-08-05 00:00:00.000' AS DateTime), N'1/3â?³ 1.3 Megapixel Aptina 1.3 Megapixel Chip CMOS', N'mini13.jpg', CAST(1 AS Numeric(19, 0)))
INSERT [dbo].[SanPham] ([idSP], [giaSP], [moTa], [namSXSP], [soLuong], [tenSP], [thoiGianBaoHanh], [thongSoKiThuat], [url], [id_LoaiSP]) VALUES (CAST(1007 AS Numeric(19, 0)), 533358, N'4k', CAST(N'2020-06-29 00:00:00.000' AS DateTime), 9, N'Camera X33631', CAST(N'2020-08-05 00:00:00.000' AS DateTime), N'1.0 Megapixel Chip CMOS', N'camera13.jpg', CAST(1 AS Numeric(19, 0)))
INSERT [dbo].[SanPham] ([idSP], [giaSP], [moTa], [namSXSP], [soLuong], [tenSP], [thoiGianBaoHanh], [thongSoKiThuat], [url], [id_LoaiSP]) VALUES (CAST(1008 AS Numeric(19, 0)), 100000, N'Camera IP Cube  6MP', CAST(N'2020-06-29 00:00:00.000' AS DateTime), 86, N'Camera X33', CAST(N'2020-08-09 00:00:00.000' AS DateTime), N'1/3â?³ 1.3 Megapixel Aptina 1.3 Megapixel Chip CMOS', N'mini14.jpg', CAST(1 AS Numeric(19, 0)))
INSERT [dbo].[SanPham] ([idSP], [giaSP], [moTa], [namSXSP], [soLuong], [tenSP], [thoiGianBaoHanh], [thongSoKiThuat], [url], [id_LoaiSP]) VALUES (CAST(1111 AS Numeric(19, 0)), 830000, N'DC 12V, Coi khong day', CAST(N'2020-06-29 00:00:00.000' AS DateTime), 67, N'BÃO Äá»?NG AM-S626W', CAST(N'2020-07-26 00:00:00.000' AS DateTime), N'150m-110 db', N'baodong14.jpg', CAST(2 AS Numeric(19, 0)))
INSERT [dbo].[SanPham] ([idSP], [giaSP], [moTa], [namSXSP], [soLuong], [tenSP], [thoiGianBaoHanh], [thongSoKiThuat], [url], [id_LoaiSP]) VALUES (CAST(1112 AS Numeric(19, 0)), 3800000, N'Thiet bi chong trom Karassks dung sim KS-899GSM', CAST(N'2020-06-29 00:00:00.000' AS DateTime), 22, N'SIM KS-899GSM', CAST(N'2020-07-26 00:00:00.000' AS DateTime), N'900MHz/1800MHz; 850MHz/1900MHz', N'baodong2.jpg', CAST(2 AS Numeric(19, 0)))
INSERT [dbo].[SanPham] ([idSP], [giaSP], [moTa], [namSXSP], [soLuong], [tenSP], [thoiGianBaoHanh], [thongSoKiThuat], [url], [id_LoaiSP]) VALUES (CAST(1113 AS Numeric(19, 0)), 1785230, N'Khoa dien tu XTHY-530', CAST(N'2020-06-29 00:00:00.000' AS DateTime), 7, N'XTHY-530', CAST(N'2020-07-26 00:00:00.000' AS DateTime), N'H5832596', N'khoa3.jpg', CAST(2 AS Numeric(19, 0)))
INSERT [dbo].[SanPham] ([idSP], [giaSP], [moTa], [namSXSP], [soLuong], [tenSP], [thoiGianBaoHanh], [thongSoKiThuat], [url], [id_LoaiSP]) VALUES (CAST(1114 AS Numeric(19, 0)), 153698, N'Cua dien tu chong trom', CAST(N'2020-07-01 00:00:00.000' AS DateTime), 32, N'DS-2CD2463G0-IW', CAST(N'2020-08-21 00:00:00.000' AS DateTime), N' Megapixel 8968', N'khoa6.jpg', CAST(2 AS Numeric(19, 0)))
INSERT [dbo].[SanPham] ([idSP], [giaSP], [moTa], [namSXSP], [soLuong], [tenSP], [thoiGianBaoHanh], [thongSoKiThuat], [url], [id_LoaiSP]) VALUES (CAST(3333 AS Numeric(19, 0)), 10000000, N'Cong do kim loai', CAST(N'2020-07-06 00:00:00.000' AS DateTime), 3, N'Cong H7642', CAST(N'2020-08-02 00:00:00.000' AS DateTime), N'Hiwsd1758', N'cong6.jpg', CAST(3 AS Numeric(19, 0)))
INSERT [dbo].[SanPham] ([idSP], [giaSP], [moTa], [namSXSP], [soLuong], [tenSP], [thoiGianBaoHanh], [thongSoKiThuat], [url], [id_LoaiSP]) VALUES (CAST(3334 AS Numeric(19, 0)), 790, N'Cong Xht50', CAST(N'2020-06-02 00:00:00.000' AS DateTime), 4, N'XXR5', CAST(N'2020-08-09 00:00:00.000' AS DateTime), N'XXCVC', N'cong10.jpg', CAST(3 AS Numeric(19, 0)))
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau], [quyenHan]) VALUES (N'Admin', N'Admin', N'Admin')
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau], [quyenHan]) VALUES (N'dai', N'123', N'KH')
INSERT [dbo].[TaiKhoan] ([taiKhoan], [matKhau], [quyenHan]) VALUES (N'hau', N'123', N'KH')
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK10x5nsly7wuexlot0miqv2nan] FOREIGN KEY([idSP])
REFERENCES [dbo].[SanPham] ([idSP])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK10x5nsly7wuexlot0miqv2nan]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FKejf6wxmnfy005jit9otqmoohs] FOREIGN KEY([idHD])
REFERENCES [dbo].[HoaDon] ([idMaHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FKejf6wxmnfy005jit9otqmoohs]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FKt2e7s2wj123d09u2w7hyp7ctk] FOREIGN KEY([kh_id])
REFERENCES [dbo].[KhachHang] ([idKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FKt2e7s2wj123d09u2w7hyp7ctk]
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FK9frs0p1jr9qtacnnie16w6ksj] FOREIGN KEY([tk_taiKhoan])
REFERENCES [dbo].[TaiKhoan] ([taiKhoan])
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FK9frs0p1jr9qtacnnie16w6ksj]
GO
ALTER TABLE [dbo].[NhaCungCap]  WITH CHECK ADD  CONSTRAINT [FK1sv43bqalof3eq10y28wtc8bh] FOREIGN KEY([sp_id])
REFERENCES [dbo].[SanPham] ([idSP])
GO
ALTER TABLE [dbo].[NhaCungCap] CHECK CONSTRAINT [FK1sv43bqalof3eq10y28wtc8bh]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FKmwcvxjdkbt7a4euofa06badva] FOREIGN KEY([tk_taiKhoan])
REFERENCES [dbo].[TaiKhoan] ([taiKhoan])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FKmwcvxjdkbt7a4euofa06badva]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FKd5h0l020nng0vtc15xuflnlao] FOREIGN KEY([id_LoaiSP])
REFERENCES [dbo].[LoaiSanPham] ([idLoaiSP])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FKd5h0l020nng0vtc15xuflnlao]
GO

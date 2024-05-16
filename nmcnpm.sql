-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 16, 2024 lúc 06:05 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `nmcnpm`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblhoadonthuesan96`
--

CREATE TABLE `tblhoadonthuesan96` (
  `id` varchar(36) NOT NULL,
  `userId` varchar(36) DEFAULT NULL,
  `phieuThueSanId` varchar(36) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `paymentAmount` float DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblhoadonthuesan96`
--

INSERT INTO `tblhoadonthuesan96` (`id`, `userId`, `phieuThueSanId`, `createTime`, `paymentAmount`, `status`, `note`) VALUES
('1', '1', '1', '2024-04-26 10:00:00', 1500, 'completed', 'Thanh toán đầy đủ'),
('2', '2', '2', '2024-04-26 11:30:00', 2000, 'completed', 'Thanh toán trước'),
('3', '1', '3', '2024-04-26 12:45:00', 1800, 'pending', 'Chưa thanh toán'),
('395374bc-ee22-474e-be7f-83a5c1e8e93f', '1', '2', NULL, 720, NULL, NULL),
('4', '2', '1', '2024-04-26 14:00:00', 1200, 'completed', 'Thanh toán bằng thẻ'),
('575a12eb-52c6-47b8-b90e-828abf716971', '1', '4', '2024-05-16 00:00:00', 394, 'Da thanh toan', NULL),
('6ed7fc0f-3347-40bd-9626-29cf0de260d8', '1', '4', '2024-05-16 00:00:00', 394, 'Đã thanh toán', NULL),
('742092fc-7e6e-43e0-b6a2-4e17f1be6cc2', '1', '4', '2024-05-13 00:00:00', 0, 'Đã thanh toán', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblkhachhang96`
--

CREATE TABLE `tblkhachhang96` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblkhachhang96`
--

INSERT INTO `tblkhachhang96` (`id`, `name`, `phoneNumber`, `email`, `address`, `birthday`) VALUES
('1', 'John Doe', '1234567890', 'john@example.com', '123 Main St, City, Country', '1990-05-15'),
('2', 'Jane Smith', '0987654321', 'jane@example.com', '456 Oak St, Town, Country', '1985-10-20'),
('3', 'Alice Johnson', '5551234567', 'alice@example.com', '789 Elm St, Village, Country', '1995-03-25'),
('4', 'Bob Brown', '7778889999', 'bob@example.com', '101 Pine St, Hamlet, Country', '1980-08-12'),
('5', 'Eva Green', '3332221111', 'eva@example.com', '202 Cedar St, Suburb, Country', '1975-12-30'),
('72', 'Duy Thong', '0397403808', 'duythong.ptit@gmail.com', '182 Yen Binh, Phuc La', '2003-07-02');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblmathang96`
--

CREATE TABLE `tblmathang96` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `cost` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblmathang96`
--

INSERT INTO `tblmathang96` (`id`, `name`, `cost`, `price`, `description`) VALUES
('1', 'Nước lọc', 5, 15, 'Nước lavie.'),
('2', 'Nước ngọt', 10, 25, 'trà xanh 0 độ'),
('3', 'Bimnim', 8, 18, 'bimbim siêu ngon');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblmathangdasudung96`
--

CREATE TABLE `tblmathangdasudung96` (
  `id` varchar(36) NOT NULL,
  `matHangId` varchar(36) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total` float DEFAULT NULL,
  `phieuThueSanId` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblmathangdasudung96`
--

INSERT INTO `tblmathangdasudung96` (`id`, `matHangId`, `quantity`, `total`, `phieuThueSanId`) VALUES
('1', '1', 5, 75, '4'),
('2', '2', 3, 60, '4');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblphieuthuesan96`
--

CREATE TABLE `tblphieuthuesan96` (
  `id` varchar(36) NOT NULL,
  `khachHangId` varchar(36) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `paymentAmount` float DEFAULT NULL,
  `deposit` float DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblphieuthuesan96`
--

INSERT INTO `tblphieuthuesan96` (`id`, `khachHangId`, `createTime`, `paymentAmount`, `deposit`, `status`) VALUES
('1', '2', '2024-04-26 14:07:11', 100, 50, 'pending'),
('2', '3', '2024-04-26 14:07:11', 150, 75, 'pending'),
('3', '3', '2024-04-26 14:07:11', 200, 100, 'pending'),
('4', '72', '2024-05-16 04:01:13', 560, 56, 'Da thanh toan'),
('5', '72', '2024-05-13 04:45:11', 1000, 100, 'Chua Thanh Toan');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblsanmini96`
--

CREATE TABLE `tblsanmini96` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblsanmini96`
--

INSERT INTO `tblsanmini96` (`id`, `name`, `price`, `type`, `description`) VALUES
('uuid1', 'Sân 1', 150, 'Sân 7 người', 'Sân bóng mini cỏ nhân tạo chất lượng cao, thích hợp cho đá bóng 7 người'),
('uuid2', 'Sân 2', 120, 'Sân 5 người', 'Sân bóng mini mat lưới giá cả hợp lý, phù hợp cho luyện tập kỹ thuật'),
('uuid3', 'Sân 3', 150, 'Sân 7 người', 'Sân futsal mini đạt chuẩn thi đấu, mặt sân lý tưởng cho các trận đấu futsal');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblsanthue96`
--

CREATE TABLE `tblsanthue96` (
  `id` varchar(36) NOT NULL,
  `sanMiniId` varchar(36) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `phieuThueSanId` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblsanthue96`
--

INSERT INTO `tblsanthue96` (`id`, `sanMiniId`, `price`, `phieuThueSanId`) VALUES
('1', 'uuid1', 2500, '2'),
('2', 'uuid2', 2000, '2'),
('3', 'uuid2', 1000, '1'),
('4', 'uuid1', 2350, '4'),
('5', 'uuid2', 1500, '4');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblsanthuephatsinh96`
--

CREATE TABLE `tblsanthuephatsinh96` (
  `id` varchar(36) NOT NULL,
  `sanMiniId` varchar(36) DEFAULT NULL,
  `thoiGianThueId` varchar(36) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `phieuThueSanId` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblthoigian96`
--

CREATE TABLE `tblthoigian96` (
  `id` varchar(36) NOT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `sanThueId` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tblthoigian96`
--

INSERT INTO `tblthoigian96` (`id`, `startTime`, `endTime`, `sanThueId`) VALUES
('1', '2024-04-26 08:00:00', '2024-04-26 10:00:00', '2'),
('2', '2024-04-26 11:00:00', '2024-04-26 13:00:00', '2'),
('3', '2024-04-26 14:00:00', '2024-04-26 16:00:00', '2'),
('4', '2024-04-26 14:00:00', '2024-04-26 16:00:00', '4');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblthoigianphatsinh96`
--

CREATE TABLE `tblthoigianphatsinh96` (
  `id` varchar(36) NOT NULL,
  `startTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  `sanThuePhatSinhId` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbluser96`
--

CREATE TABLE `tbluser96` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tbluser96`
--

INSERT INTO `tbluser96` (`id`, `name`, `email`, `address`, `position`) VALUES
('1', 'TMLan', 'lan@company.com', '123 Main Street', 'Staff'),
('2', 'THVan', 'van@company.com', '456 Elm Street', 'Staff');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tblhoadonthuesan96`
--
ALTER TABLE `tblhoadonthuesan96`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userId` (`userId`),
  ADD KEY `phieuThueSanId` (`phieuThueSanId`);

--
-- Chỉ mục cho bảng `tblkhachhang96`
--
ALTER TABLE `tblkhachhang96`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tblmathang96`
--
ALTER TABLE `tblmathang96`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tblmathangdasudung96`
--
ALTER TABLE `tblmathangdasudung96`
  ADD PRIMARY KEY (`id`),
  ADD KEY `matHangId` (`matHangId`),
  ADD KEY `phieuThueSanId` (`phieuThueSanId`);

--
-- Chỉ mục cho bảng `tblphieuthuesan96`
--
ALTER TABLE `tblphieuthuesan96`
  ADD PRIMARY KEY (`id`),
  ADD KEY `khachHangId` (`khachHangId`);

--
-- Chỉ mục cho bảng `tblsanmini96`
--
ALTER TABLE `tblsanmini96`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tblsanthue96`
--
ALTER TABLE `tblsanthue96`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sanMiniId` (`sanMiniId`);

--
-- Chỉ mục cho bảng `tblsanthuephatsinh96`
--
ALTER TABLE `tblsanthuephatsinh96`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sanMiniId` (`sanMiniId`),
  ADD KEY `thoiGianThueId` (`thoiGianThueId`);

--
-- Chỉ mục cho bảng `tblthoigian96`
--
ALTER TABLE `tblthoigian96`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_sanThueId` (`sanThueId`);

--
-- Chỉ mục cho bảng `tblthoigianphatsinh96`
--
ALTER TABLE `tblthoigianphatsinh96`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sanThuePhatSinhId` (`sanThuePhatSinhId`);

--
-- Chỉ mục cho bảng `tbluser96`
--
ALTER TABLE `tbluser96`
  ADD PRIMARY KEY (`id`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tblhoadonthuesan96`
--
ALTER TABLE `tblhoadonthuesan96`
  ADD CONSTRAINT `tblhoadonthuesan96_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tbluser96` (`id`),
  ADD CONSTRAINT `tblhoadonthuesan96_ibfk_2` FOREIGN KEY (`phieuThueSanId`) REFERENCES `tblphieuthuesan96` (`id`);

--
-- Các ràng buộc cho bảng `tblmathangdasudung96`
--
ALTER TABLE `tblmathangdasudung96`
  ADD CONSTRAINT `phieuThueSanId` FOREIGN KEY (`phieuThueSanId`) REFERENCES `tblphieuthuesan96` (`id`),
  ADD CONSTRAINT `tblmathangdasudung96_ibfk_1` FOREIGN KEY (`matHangId`) REFERENCES `tblmathang96` (`id`);

--
-- Các ràng buộc cho bảng `tblphieuthuesan96`
--
ALTER TABLE `tblphieuthuesan96`
  ADD CONSTRAINT `tblphieuthuesan96_ibfk_1` FOREIGN KEY (`khachHangId`) REFERENCES `tblkhachhang96` (`id`);

--
-- Các ràng buộc cho bảng `tblsanthue96`
--
ALTER TABLE `tblsanthue96`
  ADD CONSTRAINT `tblsanthue96_ibfk_1` FOREIGN KEY (`sanMiniId`) REFERENCES `tblsanmini96` (`id`);

--
-- Các ràng buộc cho bảng `tblsanthuephatsinh96`
--
ALTER TABLE `tblsanthuephatsinh96`
  ADD CONSTRAINT `tblsanthuephatsinh96_ibfk_1` FOREIGN KEY (`sanMiniId`) REFERENCES `tblsanmini96` (`id`),
  ADD CONSTRAINT `tblsanthuephatsinh96_ibfk_2` FOREIGN KEY (`thoiGianThueId`) REFERENCES `tblthoigian96` (`id`);

--
-- Các ràng buộc cho bảng `tblthoigian96`
--
ALTER TABLE `tblthoigian96`
  ADD CONSTRAINT `fk_sanThueId` FOREIGN KEY (`sanThueId`) REFERENCES `tblsanthue96` (`id`);

--
-- Các ràng buộc cho bảng `tblthoigianphatsinh96`
--
ALTER TABLE `tblthoigianphatsinh96`
  ADD CONSTRAINT `sanThuePhatSinhId` FOREIGN KEY (`sanThuePhatSinhId`) REFERENCES `tblsanthuephatsinh96` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

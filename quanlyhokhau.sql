-- nhom71_quanlynhankhau

CREATE TABLE `user` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `username` varchar(255),
  `password` varchar(255),
  `role_id` int
);
INSERT INTO user(username, password) VALUES ('admin', '[1]');

CREATE TABLE `role` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `roleName` varchar(255)
);

CREATE TABLE `nhankhau` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `hoTen` varchar(255),
  `ngaySinh` date,
  `gioiTinh` varchar(255),
  `noiSinh` varchar(255),
  `nguyenQuan` varchar(255),
  `danToc` varchar(255),
  `tonGiao` varchar(255),
  `quocTich` varchar(255),
  `noiThuongTru` varchar(255),
  `diaChiHienTai` varchar(255),
  `trinhDoHocVan` varchar(255),
  `ngheNghiep` varchar(255),
  `noiLamViec` varchar(255),
  `idNguoiTao` int,
  `ngayTao` date
);

CREATE TABLE `hokhau` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `idChuHo` int,
  `maHoKhau` varchar(255),
  `maKhuVuc` varchar(255),
  `diaChi` varchar(255),
  `idNguoiTao` int,
  `ngayTao` date
);

CREATE TABLE `hokhau_nhankhau` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `idNhanKhau` int,
  `idHoKhau` int,
  `quanHeVoiChuHo` varchar(255)
);

CREATE TABLE `giadinh` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `idNhanKhau` int,
  `hoTen` varchar(255),
  `ngaySinh` date,
  `gioiTinh` varchar(255),
  `quanHeVoiNhanKhau` varchar(255)
);

CREATE TABLE `chungminhnhandan` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `idNhanKhau` int,
  `soCMND` varchar(13)
);

CREATE TABLE `thaydoinhankhau` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `noiDungThayDoi` text
);

CREATE TABLE `thaydoihokhau` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `noiDungThayDoi` text
);

CREATE TABLE `tamtru` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `idNhanKhau` int,
  `maGiayTamTru` varchar(255),
  `soDienThoai` varchar(255),
  `tuNgay` date,
  `denNgay` date,
  `lyDo` varchar(255)
);

CREATE TABLE `tamvang` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `idNhanKhau` int,
  `maGiayTamVang` varchar(255),
  `soDienThoai` varchar(255),
  `diaChiTamTru` varchar(255),
  `tuNgay` date,
  `denNgay` date,
  `lyDo` varchar(255)
);

CREATE TABLE `thongtinkhaibao` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `idNhanKhau` int,
  `soDienThoai` varchar(13),
  `noiOHienTai` varchar(255),
  `ngayKhaiBao` date
);

CREATE TABLE `lichtrinh` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `idToKhai` int,
  `ngay` date,
  `noiDung` varchar(255)
);

CREATE TABLE `trieuchung` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `idToKhai` int,
  `bieuHien` varchar(255)
);

CREATE TABLE `testcovid` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `idNhanKhau` int,
  `soDienThoai` varchar(13),
  `ngayTest` date,
  `noiOHienTai` varchar(255),
  `ketQuaTest` varchar(255)
);

CREATE TABLE `cachly` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `idNhanKhau` int,
  `isCachLyTaiTramYTe` boolean,
  `diaDiemCachLy` varchar(255),
  `soDienThoai` varchar(13),
  `tuNgay` date,
  `denNgay` date,
  `thuocDien` varchar(255)
);

CREATE TABLE `khaitu` (
  `id` int PRIMARY KEY  AUTO_INCREMENT,
  `idNhanKhau` int,
  `idNguoiKhai` int,
  `ngayMat` date,
  `lyDo` varchar(255),
  `isChetDoCovid` boolean
);

ALTER TABLE `hokhau` ADD FOREIGN KEY (`id`) REFERENCES `hokhau_nhankhau` (`idHoKhau`);

ALTER TABLE `hokhau_nhankhau` ADD FOREIGN KEY (`idNhanKhau`) REFERENCES `nhankhau` (`id`);

ALTER TABLE `giadinh` ADD FOREIGN KEY (`idNhanKhau`) REFERENCES `nhankhau` (`id`);

ALTER TABLE `tamvang` ADD FOREIGN KEY (`idNhanKhau`) REFERENCES `nhankhau` (`id`);

ALTER TABLE `tamtru` ADD FOREIGN KEY (`idNhanKhau`) REFERENCES `nhankhau` (`id`);

ALTER TABLE `chungminhnhandan` ADD FOREIGN KEY (`idNhanKhau`) REFERENCES `nhankhau` (`id`);

ALTER TABLE `user` ADD FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

ALTER TABLE `trieuchung` ADD FOREIGN KEY (`idToKhai`) REFERENCES `thongtinkhaibao` (`id`);

ALTER TABLE `lichtrinh` ADD FOREIGN KEY (`idToKhai`) REFERENCES `thongtinkhaibao` (`id`);

ALTER TABLE `thongtinkhaibao` ADD FOREIGN KEY (`idNhanKhau`) REFERENCES `nhankhau` (`id`);

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 01 Feb 2025 pada 03.11
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `komputer`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` varchar(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `no_hp` varchar(13) NOT NULL,
  `email` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama`, `no_hp`, `email`, `alamat`) VALUES
('A1', 'Dhio', '089537911962', 'dhiol@gmail.com', 'Yosorejoo'),
('A2', 'Zidan', '084938493854', 'zidan@gmail.com', 'Pekalongan'),
('A4', 'Dimas', '089438493849', 'dimas@gmail.com', 'Pekalongan'),
('A5', 'ghj', '0998989897887', 'gh', 'gh');

-- --------------------------------------------------------

--
-- Struktur dari tabel `servis`
--

CREATE TABLE `servis` (
  `no_servis` varchar(10) NOT NULL,
  `id_pelanggan` varchar(10) NOT NULL,
  `id_teknisi` varchar(10) NOT NULL,
  `jenis_servis` enum('Hardware','Software') NOT NULL,
  `deskripsi_servis` varchar(100) NOT NULL,
  `harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `servis`
--

INSERT INTO `servis` (`no_servis`, `id_pelanggan`, `id_teknisi`, `jenis_servis`, `deskripsi_servis`, `harga`) VALUES
('A1', 'A1', 'A13', 'Hardware', 'Ganti SSD', 100000),
('A22', 'A4', 'A13', 'Software', 'Install ulang', 50000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `teknisi`
--

CREATE TABLE `teknisi` (
  `id_teknisi` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_hp` varchar(13) NOT NULL,
  `keahlian` enum('Hardware','Software','Keduanya') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `teknisi`
--

INSERT INTO `teknisi` (`id_teknisi`, `nama`, `no_hp`, `keahlian`) VALUES
('A12', 'Dhio', '097483743876', 'Software'),
('A13', 'Zidan', '0974837843545', 'Hardware'),
('A14', 'Dimas', '0943843943434', 'Software');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `no_transaksi` varchar(10) NOT NULL,
  `no_servis` varchar(10) NOT NULL,
  `tanggal` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`no_transaksi`, `no_servis`, `tanggal`) VALUES
('A11', 'A1', '2025-01-31'),
('A66', 'A22', '2025-02-01');

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `view_transaksi`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `view_transaksi` (
`no_transaksi` varchar(10)
,`tanggal` varchar(50)
,`nama` varchar(100)
,`deskripsi_servis` varchar(100)
,`harga` double
);

-- --------------------------------------------------------

--
-- Struktur untuk view `view_transaksi`
--
DROP TABLE IF EXISTS `view_transaksi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_transaksi`  AS SELECT `t`.`no_transaksi` AS `no_transaksi`, `t`.`tanggal` AS `tanggal`, `p`.`nama` AS `nama`, `s`.`deskripsi_servis` AS `deskripsi_servis`, `s`.`harga` AS `harga` FROM ((`transaksi` `t` join `servis` `s` on(`t`.`no_servis` = `s`.`no_servis`)) join `pelanggan` `p` on(`s`.`id_pelanggan` = `p`.`id_pelanggan`)) ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indeks untuk tabel `servis`
--
ALTER TABLE `servis`
  ADD PRIMARY KEY (`no_servis`),
  ADD KEY `id_pelanggan` (`id_pelanggan`),
  ADD KEY `id_teknisi` (`id_teknisi`);

--
-- Indeks untuk tabel `teknisi`
--
ALTER TABLE `teknisi`
  ADD PRIMARY KEY (`id_teknisi`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`no_transaksi`),
  ADD KEY `no_servis` (`no_servis`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `servis`
--
ALTER TABLE `servis`
  ADD CONSTRAINT `servis_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`),
  ADD CONSTRAINT `servis_ibfk_2` FOREIGN KEY (`id_teknisi`) REFERENCES `teknisi` (`id_teknisi`);

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`no_servis`) REFERENCES `servis` (`no_servis`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

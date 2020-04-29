-- Database export via SQLPro (https://www.sqlprostudio.com/allapps.html)
-- Exported by marwazabara at 25-02-2020 00:24.
-- WARNING: This file may contain descructive statements such as DROPs.
-- Please ensure that you are running the script at the proper location.


-- BEGIN TABLE Games
CREATE TABLE `Games` (
  `GID` bigint NOT NULL AUTO_INCREMENT,
  `player1` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  `player2` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  `winner` varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`GID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Inserting 9 rows into Games
-- Insert batch #1

-- END TABLE Games

-- BEGIN TABLE Moves
CREATE TABLE `Moves` (
  `GID` bigint NOT NULL,
  `MoveNum` int NOT NULL,
  `POS` int NOT NULL,
  `Player` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`GID`,`MoveNum`),
  CONSTRAINT `moves_ibfk_1` FOREIGN KEY (`GID`) REFERENCES `Games` (`GID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Inserting 24 rows into Moves
-- Insert batch #1


-- END TABLE Moves

-- BEGIN TABLE Players
CREATE TABLE `Players` (
  `Pname` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  `Score` bigint NOT NULL DEFAULT '0',
  `Password` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`Pname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Inserting 10 rows into Players
-- Insert batch #1


-- END TABLE Players


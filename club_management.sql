CREATE TABLE `announcement` (
  `ID` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `cont` varchar(500) NOT NULL,
  `date` varchar(30) NOT NULL
)

CREATE TABLE `event` (
  `ID` int(11) NOT NULL,
  `title` varchar(30) NOT NULL,
  `cont` varchar(500) NOT NULL,
  `venue` varchar(50) NOT NULL,
  `time` varchar(30) NOT NULL
) 


CREATE TABLE `members` (
  `ID` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `department` varchar(50) NOT NULL,
  `dob` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `favourite_animal` varchar(50) NOT NULL
)
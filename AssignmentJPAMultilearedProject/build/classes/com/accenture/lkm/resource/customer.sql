-- Dumping database structure for jpademos
drop database IF EXISTS jpademos;
create database jpademos;
use jpademos;


-- Dumping structure for table jpademos.employee
CREATE TABLE customer (
  customerId int(11) unsigned NOT NULL AUTO_INCREMENT,
  cust_name varchar(20) DEFAULT NULL,
  address varchar(30) DEFAULT NULL,
  regDate datetime DEFAULT NULL,
  walletBalance double DEFAULT NULL,
  PRIMARY KEY (customerId)
);

INSERT INTO customer (customerId, cust_name, address, regDate, walletBalance) VALUES
	(1001, 'KMS', 'Bandra', '2016-01-28 00:00:00', 500000.0),
	(1002, 'James', 'Vizag', '2016-01-28 00:00:00', 0),
	(1003, 'Rocky', 'NAMPALLY', '2016-01-28 00:00:00', 100000.0);
commit;






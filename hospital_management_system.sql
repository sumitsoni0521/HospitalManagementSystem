Create database hospital_management_system;
use hospital_management_system;

create table login(ID varchar(20), PW varchar(20));
insert into login value("hospital","123456789");

create table patient_info(
ID varchar(20), 
Number varchar(40), 
Patient_Number varchar(20), 
Gender varchar(20), 
Patient_Disease varchar(20), 
Room_Number varchar(20) NOT NULL UNIQUE, 
Time varchar(100), 
Deposite varchar(20));
select * from patient_info;

create table Room(room_no varchar(20), Available varchar(20), Price varchar(20), Room_Type varchar(100));
insert into Room values("101","Available","500","G Bed 1");
insert into Room values("102","Available","500","G Bed 2");
insert into Room values("103","Available","500","G Bed 3");
insert into Room values("104","Available","500","G Bed 4");
insert into Room values("201","Available","1500","Private Room");
insert into Room values("202","Available","1500","Private Room");
insert into Room values("203","Available","1500","Private Room");
insert into Room values("204","Available","1500","Private Room");
insert into Room values("301","Available","3500","ICU Bed 1");
insert into Room values("302","Available","3500","ICU Bed 2");
insert into Room values("303","Available","3500","ICU Bed 3");
insert into Room values("304","Available","3500","ICU Bed 4");
insert into Room values("305","Available","3500","ICU Bed 5");

select * from Room;

create table department(Department varchar(100), Phone_no varchar(20));
insert into department values("Surgical department","123456789");
insert into department values("Nursing department","123456789");
insert into department values("Operation department OT","123456789");
insert into department values("Paramedical department","123456789");
select * from department;

create table EMP_INFO(Name varchar(20), Age varchar(20), Phone_Number varchar(20),salary varchar(20),Gmail varchar(20), Aadhar_Number varchar(20));
insert into Emp_info values("Doctors1","30","856943752","50000","dr1@gmail.com","852963741456");
insert into Emp_info values("Doctors2","38","9568742362","75000","dr2@gmail.com","123456789852");

select * from EMP_INFO;


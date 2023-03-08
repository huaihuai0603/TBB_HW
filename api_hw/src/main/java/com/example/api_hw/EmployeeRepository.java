package com.example.api_hw;

import org.springframework.data.jpa.repository.JpaRepository;

//這個repository就是當作跟資料庫（後端）溝通的介面，幫助我們對資料庫做操作(更新、創建、刪除、讀取)

interface EmployeeRepository extends JpaRepository<Employee, Long> {//會註明主鍵的類別跟class的名字，也就是資料庫的宣告開頭 class Employee
//Spring Data JPA repositories are interfaces with methods supporting 
//creating, reading, updating, and deleting records against a back end data store.
//Spring makes accessing data easy. By simply declaring the following EmployeeRepository interface 
//we automatically will be able to "Create new Employees"、"Update existing ones"、"Delete Employees"、"Find Employees"


}

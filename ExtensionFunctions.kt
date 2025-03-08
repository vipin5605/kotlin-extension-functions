package com.example.myapplication


fun main() {
    val emp = Employee("Mathew", 100)

    /**
     * Invoke extension function of Employee
     * to display name
     */
    emp.printEmpName()

    /**
     * Invoke extenion function of Employee
     * to display additional info
     */
    emp.printEmpDetail {
        println(it.empDesc)
    }


}

/**
 * Basic extension function
 * to print emp name
 */
fun Employee.printEmpName() {
    println("Employee : ${this.name}")
}

/**
 * Extension function using higher order function
 */
inline fun Employee.printEmpDetail(block: (Employee) -> Unit): Employee {
    this.empDesc = "Employee name is ${this.name} and Employee ID is ${this.empId}"
    block(this)
    return this
}


data class Employee(val name : String, val empId : Int) {
    var empDesc : String = ""
}
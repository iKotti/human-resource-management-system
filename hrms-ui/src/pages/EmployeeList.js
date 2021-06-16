import React, { useState, useEffect } from "react";
import EmployeeService from "../services/EmployeeService";

export default function EmployeeList() {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    let employeeService = new EmployeeService();

    employeeService
      .getEmployees()
      .then((result) => setEmployees(result.data.data));
  });
  return (
    <div className="mb-2">
      <h4> Sistem Çalışanları </h4>
      <div className="ui cards">
        {employees.map((employee) => (
          <div className="ui blue card">
            <div className="content">
              <div className="center aligned author mb-1">
                <img
                  alt=""
                  className="ui avatar image"
                  src="https://www.pngitem.com/pimgs/m/128-1280822_check-mark-box-clip-art-blue-admin-icon.png"
                />
              </div>

              <div className="center aligned header">{employee.firstName} {employee.lastName}</div>
              <div className="center aligned description">
                <p>
                  <i className="envelope icon"></i> {employee.email}
                </p>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

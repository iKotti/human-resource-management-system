import React, { useState, useEffect } from "react";
import EmployerService from "../services/EmployerService";

export default function EmployerList() {
  const [employers, setEmployers] = useState([]);

  useEffect(() => {
    let employerService = new EmployerService();

    employerService
      .getEmployers()
      .then((result) => setEmployers(result.data.data));
  });
  return (
    <div className="mb-2">
      <h4> Sistem Çalışanları </h4>
      <div className="ui cards">
        {employers.map((employer) => (
          <div className="ui blue card">
            <div className="content">
              <div className="center aligned author mb-1">
                <img
                  alt=""
                  className="ui avatar image"
                  src="https://cdn2.iconfinder.com/data/icons/industry-7/32/industry_shop-512.png"
                />
              </div>

              <div className="center aligned header">{employer.companyName}</div>
              <div className="center aligned description">
                <p>
                  <i className="world icon"></i> {employer.webAdress}
                </p>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

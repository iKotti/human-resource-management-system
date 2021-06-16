import React from "react";
import { Link } from "react-router-dom";
import { Menu } from "semantic-ui-react";

export default function Categories() {
  return (
    <div>
      <Menu fluid vertical tabular>
        <Menu.Item name="title"> <h4> KATEGORİLER </h4></Menu.Item>
        <Menu.Item name="İş Arayanlar" as={Link} to="/candidates"/>
        <Menu.Item name="İş Verenler" as={Link} to="/employers"/>
        <Menu.Item name="Sistem Çalışanları" as={Link} to="/employees"/>
      </Menu>
    </div>
  );
}

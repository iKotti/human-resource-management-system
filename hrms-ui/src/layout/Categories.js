import React from "react";
import { Menu } from "semantic-ui-react";

export default function Categories() {
  return (
    <div>
      <Menu fluid vertical tabular>
        <Menu.Item name="title"> <h4> KATEGORİLER </h4></Menu.Item>
        <Menu.Item name="İş Arayanlar" />
        <Menu.Item name="İş Verenler" />
        <Menu.Item name="Sistem Çalışanları" />
      </Menu>
    </div>
  );
}

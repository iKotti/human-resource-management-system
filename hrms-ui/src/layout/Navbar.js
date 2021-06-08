import React from "react";
import { Menu, Segment, Container, Button, Icon } from "semantic-ui-react";

export default function Navbar() {
  return (
    <div>
      <Segment inverted>
        <Menu inverted>
          <Container>
            <Menu.Item name="icon">
              <Icon name="suitcase" size="large" /> HRMS{" "}
            </Menu.Item>
            <Menu.Item name="İş İlanları" />
            <Menu.Item name="İş Pozisyonları" />

            <Menu.Menu position="right">
            <button class="ui small gray button">
                <i class="icon user"></i>
                Giriş Yap
              </button>
              <button class="ui small green button">
                <i class="icon user plus "></i>
                Kayıt Ol
              </button>
            </Menu.Menu>
          </Container>
        </Menu>
      </Segment>
    </div>
  );
}

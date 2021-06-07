import React from "react";
import { Menu, Segment, Container, Button, Icon } from "semantic-ui-react";

export default function Navbar() {
  return (
    <div>
      <Segment inverted>
        <Menu inverted>
          <Container>
            <Menu.Item name="icon"> <Icon name='suitcase' size='large' /> HRMS </Menu.Item>
            <Menu.Item name="Anasayfa" />
            <Menu.Item name="İş İlanları" />
            <Menu.Item name="İş Pozisyonları" />

            <Menu.Menu position="right">
              <Button.Group position="right">
                <Button>Giriş Yap</Button>
                <Button.Or />
                <Button positive>Kayıt Ol</Button>
              </Button.Group>
            </Menu.Menu>
          </Container>
        </Menu>
      </Segment>
    </div>
  );
}
